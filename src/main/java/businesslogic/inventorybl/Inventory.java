package businesslogic.inventorybl;

import message.ResultMessage;

public class Inventory {
	
	public Inventory() {
		
	}
	public ResultMessage viewInventory(String beginDate, String endDate) {
		ViewList viewList = new ViewList(beginDate, endDate);
		return null;
	}
}
