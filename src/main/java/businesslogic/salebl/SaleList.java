package businesslogic.salebl;

import java.util.ArrayList;

public class SaleList {
	private ArrayList<SaleListItem> commodities;
	
	private double beforePrice;
	
	public SaleList() {
		commodities = new ArrayList<SaleListItem>();
		beforePrice = 0;
	}

	public void add(String name, int number, int price, String remark){
		SaleListItem item = new SaleListItem(name, number, price, remark);
		commodities.add(item);
	}
	
	public void getBeforePrice(){
		for (int i = 0; i < commodities.size(); i++) {
			beforePrice+=commodities.get(i).getTotal();
		}
	}
	
	public ArrayList<SaleListItem> getCommodities() {
		return commodities;
	}
}
