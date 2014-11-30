package businesslogic.recordbl.info;

import dataenum.Storage;

public interface SaleInfo_Record {
	
	public String getSaleDetailVO(String ID, String clientName, String salesman, Storage storage, String commodityName);

	public String getName(String ID);
	
	public String getType(String ID);
	
	public String getNumber(String ID);
	
	public double getPrice(String ID);

}
