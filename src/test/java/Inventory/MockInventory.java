package Inventory;

import java.util.ArrayList;

import businesslogic.inventorybl.Inventory;

public class MockInventory extends Inventory{

	private ArrayList<MockCommodity> inventory;
	
	public void add(MockCommodity commodity){
		inventory.add(commodity);
	}
	
	
}
