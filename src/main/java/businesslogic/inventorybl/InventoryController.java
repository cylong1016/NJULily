package businesslogic.inventorybl;

import vo.InventoryBillVO;
import vo.InventoryCheckVO;
import message.ResultMessage;
import blservice.inventoryblservice.InventoryBLService;

public class InventoryController implements InventoryBLService{
	
	private Inventory inventory;
	
	public InventoryController() {
		inventory = new Inventory();
	}
	public ResultMessage viewInventory(String beginDate, String endDate) {
		inventory.viewInventory(beginDate, endDate);
		return null;
	}
	public InventoryCheckVO checkRecord() {
		return inventory.checkRecord();
	}
	
	public void addCommodity(String ID, int number) {
		inventory.addCommodity(ID, number);	
	}
	
	public void buildGift(){
		inventory.buildGift();
	}
	
	public InventoryBillVO submit(String remark) {
		return inventory.submit(remark);
	}

	//public void submit(BillType type, )
	
}
