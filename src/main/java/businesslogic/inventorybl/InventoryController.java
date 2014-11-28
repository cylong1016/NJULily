package businesslogic.inventorybl;

import java.util.ArrayList;

import vo.InventoryCheckVO;
import message.ResultMessage;
import businesslogicservice.InventoryBLService;

public class InventoryController implements InventoryBLService{
	
	private Inventory inventory;
	
	public InventoryController() {
		inventory = new Inventory();
	}
	public ResultMessage viewInventory(String beginDate, String endDate) {
		inventory.viewInventory(beginDate, endDate);
		return null;
	}
	public ArrayList<InventoryCheckVO> checkRecord() {
		inventory.checkRecord();
		return null;
	}

	
}
