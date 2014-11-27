package businesslogic.inventorybl;

import message.ResultMessage;
import businesslogicservice.InventoryBLService;

public class InventoryController implements InventoryBLService{
	
	private Inventory inventory;
	
	public InventoryController() {
		inventory = new Inventory();
	}
	public ResultMessage viewInventory(String beginDate, String endDate) {
		return null;
	}

	
}
