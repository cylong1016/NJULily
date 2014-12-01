package businesslogic.purchasebl;

import businesslogic.recordbl.info.PurchaseInfo_Record;
import businesslogic.recordbl.info.ValueObjectInfo_Record;
import vo.PurchaseVO;
import dataenum.Storage;
import dataservice.PurchaseDataService;

public class PurchaseInfo implements ValueObjectInfo_Record<PurchaseVO>, PurchaseInfo_Record{
	
	private Purchase purchase;
	
	public PurchaseInfo() {
		purchase = new Purchase();
	}
	
	private PurchaseDataService getPurData() {
		return purchase.getPurData();
	}
	
	
	public String getID(String ID, String clientName, String salesman, Storage storage) {
		return null;
	}

	public PurchaseVO show(String ID) {
		return purchase.poToVO(getPurData().find(ID));
	}
}
