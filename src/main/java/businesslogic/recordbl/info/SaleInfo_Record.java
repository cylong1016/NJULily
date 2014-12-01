package businesslogic.recordbl.info;

import dataenum.Storage;

public interface SaleInfo_Record {
	
	public String getID(String ID, String clientName, String salesman, Storage storage);
	
	public String getCommodity(String ID, String CommodityName);

	public String getName(String ID);
	
	public String getType(String ID);
	
	public int getNumber(String ID);
	
	public double getPrice(String ID);
	
	public double getAfterPrice(String ID);
	
	public double getVoucher(String ID);
	
	public double getAllowance(String ID);

}
