package businesslogic.recordbl.info;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.Storage;

public interface SaleInfo_Record {
	
	public ArrayList<String> getID(String ID, String clientName, String salesman, Storage storage) throws RemoteException;
	
	/**
	 * 根据销售单的ID，查找特定的商品ID
	 * @param ID
	 * @param CommodityName
	 * @return
	 * @author Zing
	 * @version Dec 3, 2014 2:48:47 PM
	 * @throws RemoteException 
	 */
	public String getCommodityID(String ID, String CommodityName) throws RemoteException;

	public String getCommodityName(String ID) throws RemoteException;
	
	public String getCommodityType(String ID) throws RemoteException;
	
	public int getCommodityNumber(String ID) throws RemoteException;
	
	public double getCommodityPrice(String ID) throws RemoteException;
	
	public double getBeforePrice(String ID) throws RemoteException;
		
	public double getVoucher(String ID) throws RemoteException;
	
	public double getAllowance(String ID) throws RemoteException;

}
