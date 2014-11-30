package businesslogic.recordbl.info;

import dataenum.Storage;

public interface SaleInfo_Record {
	
	public String getSaleDetailVO(String ID, String clientName, String salesman, Storage storage, String commodityName);

}
