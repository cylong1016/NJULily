package Inventory;

import businesslogic.inventorybl.AlarmList;

public class MockAlarmList extends AlarmList{
	private String ID;
	private MockCommodity item;
	private int alarmNum;
	
	public MockAlarmList(String ID, MockCommodity item, int alarmNum){
		this.ID = ID;
		this.item = item;
		this.alarmNum = alarmNum;
	}
	
	public String getID(){
		return ID;
	}
	
	public MockCommodity item(){
		return item;
	}
	
	public int alarmNum(){
		return alarmNum;
	}
}
