package businesslogic.recordbl.info;

import java.util.ArrayList;

import dataenum.Storage;

public interface PurchaseInfo_Record {
	
	public ArrayList<String> getID(String ID, String clientName, String salesman, Storage storage);

	/**
	 * 根据ID得到进货的总额
	 * @param ID
	 * @return
	 * @author Zing
	 * @version Dec 4, 2014 11:39:15 PM
	 */
	public double getTotalPrice(String ID);

}
