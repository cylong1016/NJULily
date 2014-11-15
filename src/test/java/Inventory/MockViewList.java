package Inventory;

import businesslogic.inventorybl.ViewList;

public class MockViewList extends ViewList{
	
	MockViewListItem item;
	public MockViewList(MockViewListItem item){
		this.item = item;
	}
	
	public MockViewListItem getItem(){
		return item;
	}
}
