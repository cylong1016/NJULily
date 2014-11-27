package businesslogic.salebl;

import java.rmi.Naming;
import java.util.ArrayList;

import po.SaleCommodityItemPO;
import po.SalesPO;
import vo.SalesVO;
import message.ResultMessage;
import dataenum.BillType;
import dataenum.Storage;
import dataservice.DataFactoryService;
import dataservice.SaleDataService;
/**
 * Sale和SaleDataService是依赖关系
 * @author Zing
 * @version Nov 15, 201410:07:38 AM
 */
public class Sale {
	
	private SaleList saleList;
	
	private SalesPO po;
		
	public Sale() {
		this.saleList = new SaleList();
	}
	
	/**
	 * 添加商品
	 * @param name
	 * @param num
	 * @param price
	 * @param remark
	 */
	public void addCommodities(String name, int num, double price, String remark) {
		SaleListItem item = new SaleListItem(name, num, price, remark);
		saleList.add(item);
	}

	/**
	 * 得到折让后的价格
	 * @param beforePrice
	 * @param allowance
	 * @param voucher
	 * @return
	 */
	public double getAfterPrice(double beforePrice, double allowance,
			double voucher) {
		return beforePrice - allowance - voucher;
	}

	/**
	 * 
	 * @param client
	 * @param salesman
	 * @param user
	 * @param storage
	 * @param allowance
	 * @param voucher
	 * @param remark
	 * @return
	 */
	public ResultMessage addSale(String client, String salesman,String user, Storage storage, 
			double allowance, double voucher, String remark) {
		try {
			DataFactoryService factory = (DataFactoryService)Naming.lookup("rmi://127.0.0.1:8888/factory");
			SaleDataService saleData = (SaleDataService)factory.getSaleData();
			double beforePrice = saleList.getBeforePrice();
			double afterPrice = getAfterPrice(beforePrice, allowance, voucher);
			String ID = saleData.getID();
			po = new SalesPO(ID, client, salesman, user, storage, saleList.getCommodities(), 
					beforePrice, allowance, voucher, remark, afterPrice, BillType.SALE);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return ResultMessage.SUCCESS;
	}

	public ResultMessage addSaleBack(String client,String salesman, String user, 
			Storage storage, double allowance, double voucher, String remark){
		try {
			DataFactoryService factory = (DataFactoryService)Naming.lookup("rmi://127.0.0.1:8888/factory");
			SaleDataService saleData = (SaleDataService)factory.getSaleData();
			double beforePrice = saleList.getBeforePrice();
			double afterPrice = getAfterPrice(beforePrice, allowance, voucher);
			String ID = saleData.getID();
			po = new SalesPO(ID, client, salesman, user, storage, saleList.getCommodities(), 
					beforePrice, allowance, voucher, remark, afterPrice, BillType.SALEBACK);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return ResultMessage.SUCCESS;
	}

	public ResultMessage submit() {
		
		return null;
	}
	
	public SaleList getSaleList(){
		return saleList;
	}
	
	public ArrayList<SalesVO> show(){
		return null;
	}

}
