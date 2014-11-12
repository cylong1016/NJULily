package businesslogic.salebl;

import java.util.ArrayList;

import message.ResultMessage;
import vo.ClientVO;
import vo.SaleCommodityItemVO;
import vo.UserVO;
import dataenum.Storage;

public class Sale {
	
	private SaleList saleList;
	
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
	public void addCommodities(String name, int num, int price,
			String remark) {
		saleList.add(name, num, price, remark);
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
