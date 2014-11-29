package businesslogic.purchasebl;

import java.util.ArrayList;

import message.ResultMessage;
import vo.CommodityItemVO;
import vo.PurchaseVO;
import dataenum.BillType;
import dataenum.Storage;
import blservice.purchaseblservice.PurInputInfo;
import blservice.purchaseblservice.PurchaseBLService;

public class PurchaseController implements PurchaseBLService{
	
	private Purchase purchase;
	
	public PurchaseController(){
		purchase = new Purchase();
	}
	
	public ArrayList<PurchaseVO> show() {
		return null;
	}

	public String getID(BillType type) {
		return null;
	}

	public void addCommodities(CommodityItemVO item) {
		
	}

	public ResultMessage submit(PurInputInfo info) {
		return null;
	}

	public ResultMessage save(PurInputInfo info) {
		return null;
	}

}
