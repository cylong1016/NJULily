package businesslogic.salebl;

import java.rmi.Naming;
import java.util.ArrayList;

import message.ResultMessage;
import vo.ClientVO;
import vo.SaleCommodityItemVO;
import vo.UserVO;
import dataenum.Storage;
import dataservice.SaleDataService;

public class Sale {
	
	private SaleList saleList;
	
	private SaleDataService saleData;
	
	public Sale() {
		this.saleList = new SaleList();
		try {
			saleData = (SaleDataService)Naming.lookup("rmi://127.0.0.1:8888/factory");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * 添加商品
	 * @param name
	 * @param num
	 * @param price
	 * @param remark
	 */
	public void addCommodities(String name, int num, int price,
			String remark) {
		SaleListItem item = new SaleListItem(name, num, price, remark);
		saleList.add(item);
	}
	
	
	public ResultMessage getBeforePrice(ArrayList<SaleCommodityItemVO> commodities) {
		return null;
	}

	public ResultMessage getAfterPrice(int beforePrice, int allowance,
			int voucher) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addSale(ClientVO client, UserVO salesman,
			UserVO user, Storage storage, 
			int allowance, int voucher, String remark) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addSaleBack(ClientVO client,UserVO salesman, UserVO user, 
			Storage storage, int allowance, int voucher, String remark){
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage submit() {
		// TODO Auto-generated method stub
		return null;
	}

}
