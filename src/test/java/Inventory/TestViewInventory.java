package Inventory;



import org.junit.Test;

import blservice.inventoryblservice.InventoryBLService;
import businesslogic.inventorybl.InventoryController;

public class TestViewInventory {

	@Test
	public void test() {
		InventoryBLService inventory = new InventoryController();
		inventory.viewInventory("20141211", "20141229");
	}

}
