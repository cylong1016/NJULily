package businesslogic.inventorybl.info;

import java.util.ArrayList;

public interface CommodityInfo {
	
	public ArrayList<String> getAllID();
	
	public String getName(String ID);
	
	public String getType(String ID);
	
	public int getNumber(String ID);
	
	public double getAvePrice(String ID);

}
