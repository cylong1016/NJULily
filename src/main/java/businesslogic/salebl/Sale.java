package businesslogic.salebl;

import java.rmi.Naming;
import java.util.ArrayList;

import org.junit.runner.notification.Failure;

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
	
	private BillType type;
	
	private String ID;
		
	public Sale() {
		this.saleList = new SaleList();
	}
	
	/**
	 * 添加商品
	 * @param ID
	 * @param num
	 * @param price
	 * @param remark
	 */
	public void addCommodities(String ID, int num, double price, String remark) {
		SaleListItem item = new SaleListItem(ID, num, price, remark);
		saleList.add(item);
	}

	/**
	 * 得到折让后的价格
	 * @param beforePrice
	 * @param allowance
	 * @param voucher
	 * @return
	 */
	public double getAfterPrice(double beforePrice, double allowance, double voucher) {
		return beforePrice - allowance - voucher;
	}
	
	public SaleDataService getSaleData(){
		try {
			DataFactoryService factory = (DataFactoryService)Naming.lookup("rmi://127.0.0.1:8888/factory");
			SaleDataService saleData = (SaleDataService)factory.getSaleData();
			return saleData;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}

	/**
	 * 建立销售单
	 * @param client
	 * @param salesman
	 * @param user
	 * @param storage
	 * @param allowance
	 * @param voucher
	 * @param remark
	 * @return
	 */
	public ResultMessage addSale(String client,  Storage storage, double allowance, double voucher, String remark) {
		SaleDataService saleData = getSaleData();
		double beforePrice = saleList.getBeforePrice();
		double afterPrice = getAfterPrice(beforePrice, allowance, voucher);
		String ID = saleData.getID();
		po = new SalesPO(ID, client, salesman, user, storage, saleList.getCommodities(), beforePrice, allowance, voucher, remark, afterPrice, BillType.SALE);
			
<<<<<<< HEAD
=======
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMessage.FAILURE;
		} 
		
>>>>>>> FETCH_HEAD
		return ResultMessage.SUCCESS;
	}

	/**
	 * 建立销售退货单
	 * @param client
	 * @param salesman
	 * @param user
	 * @param storage
	 * @param allowance
	 * @param voucher
	 * @param remark
	 * @return
	 */
	public ResultMessage addSaleBack(String client, Storage storage, double allowance, double voucher, String remark){
		try {
			DataFactoryService factory = (DataFactoryService)Naming.lookup("rmi://127.0.0.1:8888/factory");
			SaleDataService saleData = (SaleDataService)factory.getSaleData();
			double beforePrice = saleList.getBeforePrice();
			double afterPrice = getAfterPrice(beforePrice, allowance, voucher);
			String ID = saleData.getID();
			po = new SalesPO(ID, client, salesman, user, storage, saleList.getCommodities(), 
					beforePrice, allowance, voucher, remark, afterPrice, BillType.SALEBACK);
			saleData.insert(po);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMessage.FAILURE;
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
		DataFactoryService factory;
		try {
			factory = (DataFactoryService)Naming.lookup("rmi://127.0.0.1:8888/factory");
			SaleDataService saleData = (SaleDataService)factory.getSaleData();
			// TODO 需要一个返回所有的PO的方法
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	public String getID(BillType type) {
		this.type = type;
		try {
			DataFactoryService factory = (DataFactoryService)Naming.lookup("rmi://127.0.0.1:8888/factory");
			SaleDataService saleData = (SaleDataService)factory.getSaleData();
			return saleData.getID(type);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "failure";
	}

	public ResultMessage submit(String client, Storage storage, double allowance, double voucher, String remark) {
		switch (type) {
		case SALE:
			addSale(client, salesman, user, storage, allowance, voucher, remark);
			break;
			
		case SALEBACK:
			
			break;

		default:
			break;
		}
		return null;
	}

	public ResultMessage save(String client, Storage storage, double allowance,
			double voucher, String remark) {
		// TODO Auto-generated method stub
		return null;
	}

}
