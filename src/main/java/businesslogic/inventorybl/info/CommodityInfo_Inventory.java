package businesslogic.inventorybl.info;

import java.util.ArrayList;

public interface CommodityInfo_Inventory {
	
	public ArrayList<String> getAllID();
	
	public String getName(String ID);
	
	public String getType(String ID);
	
	public int getNumber(String ID);
	
	public double getAvePrice(String ID);
	
	public double getPurPrice(String ID);

}
