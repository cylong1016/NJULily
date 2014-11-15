package Inventory;

import businesslogic.inventorybl.CheckList;

public class MockCheckList extends CheckList{
	
	String ID;
	MockInventory inventory;
	
	public MockCheckList(String ID, MockInventory inventory){
		this.ID = ID;
		this.inventory = inventory;
	}
	
	public MockInventory getCheckList(){
		return inventory;
	}
	
	public String getID(){
		return ID;
	}
	
	
}
