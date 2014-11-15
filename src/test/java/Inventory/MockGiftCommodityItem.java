package Inventory;

import businesslogic.inventorybl.GiftCommodityItem;


public class MockGiftCommodityItem extends GiftCommodityItem{
	private MockCommodity commodity;
	private int number;
	
	public MockGiftCommodityItem(MockCommodity commodity, int number){
		this.commodity = commodity;
		this.number = number;
	}
	
	public MockCommodity getCommodity(){
		return commodity;
	}
	
	public int returnNumber(){
		return number;
	}
}
