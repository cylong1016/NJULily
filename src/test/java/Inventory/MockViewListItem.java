package Inventory;

import java.util.ArrayList;

import businesslogic.inventorybl.ViewListItem;

public class MockViewListItem extends ViewListItem {
	MockOverList overList;
	MockLossList lossList;
	MockGiftlist giftList;
	MockAlarmList alarmList;
	MockCheckList checkList;
	
	private ArrayList<Object> historyLists;
	
	public void add(MockOverList overList){
		historyLists.add(overList);
	}
	
	public void add(MockLossList lossList){
		historyLists.add(lossList);
	}
	
	public void add(MockGiftlist giftList){
		historyLists.add(giftList);
	}
	
	public void add(MockAlarmList alarmList){
		historyLists.add(alarmList);
	}
	
	public void add(MockCheckList checkList){
		historyLists.add(checkList);
	}
}
