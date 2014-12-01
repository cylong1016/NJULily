package businesslogic.inventorybl;

import java.util.ArrayList;

import po.InventoryBillPO;
import dataenum.BillType;
import dataenum.Storage;
import dataservice.InventoryDataService;
import vo.InventoryBillVO;
import businesslogic.promotionbl.InventoryInfo_Promotion;
import businesslogic.recordbl.info.InventoryInfo_Record;
import businesslogic.recordbl.info.ValueObjectInfo_Record;

public class InventoryInfo  implements InventoryInfo_Promotion, ValueObjectInfo_Record<InventoryBillVO>, InventoryInfo_Record{

	private Inventory inventory;
	
	public InventoryInfo() {
		inventory = new Inventory();
	}
	
	private InventoryDataService getInventoryData() {
		return inventory.getInventoryData();
	}
	
	public ArrayList<InventoryBillVO> getGifts() {
		return inventory.show(BillType.GIFT);
	}

	public String getID(String ID, String clientName, String salesman, Storage storage) {
		return null;
	}

	public InventoryBillVO show(String ID) {
		// TODO Auto-generated method stub
		return null;
	}
}
