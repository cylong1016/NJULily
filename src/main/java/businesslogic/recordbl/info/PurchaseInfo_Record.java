package businesslogic.recordbl.info;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.Storage;

public interface PurchaseInfo_Record {
	
	public ArrayList<String> getID(String clientName, String salesman, Storage storage) throws RemoteException;

	/**
	 * 根据ID得到进货的总额
	 * @param ID
	 * @return
	 * @author Zing
	 * @version Dec 4, 2014 11:39:15 PM
	 * @throws RemoteException 
	 */
	public double getTotalPrice(String ID) throws RemoteException;

}
