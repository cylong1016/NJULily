package businesslogic.purchasebl;

import java.util.ArrayList;

import message.ResultMessage;
import vo.ClientVO;
import vo.SaleCommodityItemVO;
import vo.UserVO;
import dataenum.Storage;
import businesslogicservice.PurchaseBLService;

public class PurchaseController implements PurchaseBLService{

	public ResultMessage getID() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addCommodities(String name, int num, double price,
			String remark) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage getBeforePrice(ArrayList<SaleCommodityItemVO> commodities) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addSale(String ID, ClientVO client, UserVO user,
			Storage storage, ArrayList<SaleCommodityItemVO> commodities,
			int sumPrice, String remark) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addSaleBack(String ID, ClientVO client, UserVO user,
			Storage storage, ArrayList<SaleCommodityItemVO> commodities,
			int sumPrice) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage submit() {
		// TODO Auto-generated method stub
		return null;
	}

}
