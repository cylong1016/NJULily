package businesslogic.purchasebl;

import java.util.ArrayList;

import message.ResultMessage;
import vo.PurchaseVO;
import vo.commodity.CommodityItemVO;
import dataenum.BillType;
import blservice.purchaseblservice.PurInputInfo;
import blservice.purchaseblservice.PurchaseBLService;

public class PurchaseController implements PurchaseBLService{
	
	private Purchase purchase;
	
	public PurchaseController(){
		purchase = new Purchase();
	}
	
	public ArrayList<PurchaseVO> show(BillType billType) {
		return purchase.show(billType);
	}

	public String getID(BillType type) {
		return purchase.getID(type);
	}

	public void addCommodities(CommodityItemVO item) {
		purchase.addCommodities(item);
	}

	public ResultMessage submit(PurInputInfo info) {
		return purchase.submit(info);
	}

	public ResultMessage save(PurInputInfo info) {
		return purchase.save(info);
	}

}
