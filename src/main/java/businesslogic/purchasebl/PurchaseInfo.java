package businesslogic.purchasebl;

import java.util.ArrayList;

import businesslogic.common.Info;
import businesslogic.recordbl.info.PurchaseInfo_Record;
import businesslogic.recordbl.info.ValueObjectInfo_Record;
import vo.PurchaseVO;
import dataenum.BillType;
import dataenum.Storage;
import dataservice.PurchaseDataService;

public class PurchaseInfo extends Info<PurchaseDataService> implements ValueObjectInfo_Record<PurchaseVO>, PurchaseInfo_Record{
	
	private Purchase purchase;
	
	public PurchaseInfo() {
		purchase = new Purchase();
	}
	
	public PurchaseDataService getData() {
		return purchase.getPurData();
	}
	
	
	public ArrayList<String> getID(String ID, String clientName, String salesman, Storage storage) {
		ArrayList<String> IDs = new ArrayList<String>();
		IDs = getID(ID, clientName, salesman, storage, BillType.PURCHASE);
		return IDs;
	}

	public PurchaseVO find(String ID) {
		return purchase.poToVO(getData().find(ID));
	}
}
