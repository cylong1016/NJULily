package businesslogic.purchasebl;

import dataenum.BillType;

public interface CommodityInfo_Purchase {
	
	public String getType(String ID);
	
	public String getName(String ID);

	public void changeCommodityInfo(String id, int number, double price, BillType type);	
}
