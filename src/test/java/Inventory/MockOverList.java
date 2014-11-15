package Inventory;

import businesslogic.inventorybl.OverList;

public class MockOverList extends OverList {
	private String ID;
	private MockCommodity item;
	private int overNum;
	
	public MockOverList(String ID, MockCommodity item, int overNum){
		this.ID = ID;
		this.item = item;
		this.overNum = overNum;
	}
	
	public String getID(){
		return ID;
	}
	
	public MockCommodity item(){
		return item;
	}
	
	public int alarmNum(){
		return overNum;
	}
	
}
