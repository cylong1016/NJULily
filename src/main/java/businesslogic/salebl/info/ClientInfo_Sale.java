package businesslogic.salebl.info;

import java.rmi.RemoteException;

/**
 * 由Client实现，获得Client信息
 * @author Zing
 */
public interface ClientInfo_Sale {

	/**
	 * 得到客户对应的默认业务员
	 * @param ID
	 * @return
	 * @author Zing
	 * @version Dec 3, 2014 2:11:55 PM
	 * @throws RemoteException
	 */
	public String getSalesman(String ID) throws RemoteException;

	/**
	 * 得到客户的名字
	 * @param ID
	 * @return
	 * @author Zing
	 * @version Dec 3, 2014 2:12:10 PM
	 * @throws RemoteException
	 */
	public String getName(String ID) throws RemoteException;

	/**
	 * 更改客户的应收
	 * @param clientID
	 * @param afterPrice
	 * @author Zing
	 * @version Dec 3, 2014 2:11:32 PM
	 */
	public boolean changeReceivable(String clientID, double afterPrice) throws RemoteException;
}
