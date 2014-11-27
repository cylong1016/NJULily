package businesslogic.purchasebl;

import java.util.ArrayList;

import po.CommodityItemPO;

public class PurchaseList {
	
	private ArrayList<PurchaseListItem> commodities;
	
	private double beforePrice;
	
	public PurchaseList() {
		commodities = new ArrayList<PurchaseListItem>();
		beforePrice = 0;
	}

	public void add(PurchaseListItem item){
		commodities.add(item);
	}
	
	public double getBeforePrice(){
		for (int i = 0; i < commodities.size(); i++) {
			beforePrice+=commodities.get(i).getTotal();
		}
		return beforePrice;
	}
	
	public ArrayList<CommodityItemPO> getCommodities() {
		ArrayList<CommodityItemPO> commoditiesPO = new ArrayList<CommodityItemPO>();
		for (int i = 0; i < commodities.size(); i++) {
			PurchaseListItem c = commodities.get(i);
			CommodityItemPO po = new CommodityItemPO(c.getID(), c.getName(), 
					c.getType(), c.getNumber(), c.getPrice(), c.getTotal(), c.getRemark());
			commoditiesPO.add(po);
		}
		return commoditiesPO;
	}
}
