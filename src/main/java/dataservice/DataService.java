package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author cylong
 * @version Oct 26, 2014 7:00:12 PM
 */
public interface DataService extends Remote {

	/**
	 * 初始化数据层接口的信息
	 * @author cylong
	 * @version Oct 26, 2014 7:02:43 PM
	 */
	public void init() throws RemoteException;
}
