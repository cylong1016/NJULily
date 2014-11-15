package businesslogic.purchasebl;

import java.util.ArrayList;

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
	
	public ArrayList<PurchaseListItem> getCommodities() {
		return commodities;
	}
}
