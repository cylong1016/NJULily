package businesslogic.salebl;

import java.util.ArrayList;

public class SaleList {
	private ArrayList<SaleListItem> commodities;
	
	private double beforePrice;
	
	public SaleList() {
		commodities = new ArrayList<SaleListItem>();
		beforePrice = 0;
	}

	public void add(SaleListItem item){
		commodities.add(item);
	}
	
	public double getBeforePrice(){
		for (int i = 0; i < commodities.size(); i++) {
			beforePrice+=commodities.get(i).getTotal();
		}
		return beforePrice;
	}
	
	public ArrayList<SaleListItem> getCommodities() {
		return commodities;
	}
}
