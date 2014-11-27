package businesslogic.purchasebl;

import java.util.ArrayList;

import message.ResultMessage;
import vo.PurchaseVO;
import dataenum.Storage;
import businesslogicservice.PurchaseBLService;

public class PurchaseController implements PurchaseBLService{
	
	private Purchase purchase;
	
	public PurchaseController(){
		purchase = new Purchase();
	}

	public void addCommodities(String name, int num, double price,
			String remark) {
		purchase.addCommodities(name, num, price, remark);
	}

	public ResultMessage addPur(String ID, String client, String user,
			Storage storage, double sumPrice, String remark) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addPurBack(String ID, String client, String user,
			Storage storage, double sumPrice, String remark) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage submit() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<PurchaseVO> show() {
		// TODO Auto-generated method stub
		return null;
	}

}
