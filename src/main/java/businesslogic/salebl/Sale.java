package businesslogic.salebl;

import java.rmi.Naming;

import po.SalesPO;
import message.ResultMessage;
import dataenum.Storage;
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

	public ResultMessage addSale(String client, String salesman,
			String user, Storage storage, 
			double allowance, double voucher, String remark) {
		try {
			SaleDataService saleData = (SaleDataService)Naming.lookup("rmi://127.0.0.1:8888/factory");
			double beforePrice = saleList.getBeforePrice();
			double afterPrice = getAfterPrice(beforePrice, allowance, voucher);
			String ID = saleData.getID();
			// TODO
		
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return null;
	}

	public ResultMessage addSaleBack(String client,String salesman, String user, 
			Storage storage, double allowance, double voucher, String remark){
		try {
			SaleDataService saleData = (SaleDataService)Naming.lookup("rmi://127.0.0.1:8888/factory");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}

	public ResultMessage submit() {
		// TODO Auto-generated method stub
		return null;
	}

}
