package businesslogic.promotionbl.info;

import java.rmi.RemoteException;

public interface CommodityInfo_Promotion {

	public String getName(String ID) throws RemoteException;

	public String getType(String ID) throws RemoteException;

	public double getPurPrice(String ID) throws RemoteException;
}
