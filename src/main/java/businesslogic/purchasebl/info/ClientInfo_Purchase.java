package businesslogic.purchasebl.info;

import java.rmi.RemoteException;

/**
 * @author Zing
 * @version Nov 29, 2014 3:33:46 PM
 */
public interface ClientInfo_Purchase {

	public String getName(String ID) throws RemoteException;

	/**
	 * 更改客户的应付金额（公司付给客户的）
	 * @param clientID
	 * @param beforePrice
	 * @author Zing
	 * @version Dec 3, 2014 4:50:54 PM
	 * @throws RemoteException
	 */
	public void changePayable(String clientID, double beforePrice) throws RemoteException;

}
