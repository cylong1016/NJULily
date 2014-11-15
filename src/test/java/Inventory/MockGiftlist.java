package Inventory;

import java.util.ArrayList;

import businesslogic.inventorybl.GiftList;

public class MockGiftlist extends GiftList{
	
	private ArrayList<MockGiftCommodityItem> giftCommodities;
	private ArrayList<MockGiftlist> giftList;
	private String ID;
	private String date;
	private String builder;
	private MockGiftCommodityItem giftItem;
	
	public void add(String ID, String date, String builder, MockGiftCommodityItem giftItem){
		this.ID = ID;
		this.date = date;
		this.builder =builder;
		this.giftItem = giftItem;
		
		giftCommodities.add(giftItem);
		giftList.add(this);
		
	}
	
	public ArrayList<MockGiftCommodityItem> getCommodities(){
		return giftCommodities;
	}
	
	public ArrayList<MockGiftlist> giftList(){
		return giftList;
	}
	
	public String getID(){
		return ID;
	}
	
	public String getDate(){
		return date;
	}
	
	public String getBuilder(){
		return builder;
	}
	
	public MockGiftCommodityItem getgiftItem(){
		return giftItem;
	}
}
