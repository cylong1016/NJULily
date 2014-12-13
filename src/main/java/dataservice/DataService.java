package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.PersistentObject;

/**
 * @author cylong
 * @version Oct 26, 2014 7:00:12 PM
 */
public interface DataService<PO extends PersistentObject> extends Remote {

	/**
	 * 初始化数据层接口的信息
	 * @author cylong
	 * @version Oct 26, 2014 7:02:43 PM
	 */
	public void init() throws RemoteException;

	/**
	 * 在逻辑层想要创建一个PO的时候返回给其一个可用的ID
	 * @return 新的ID
	 * @author cylong
	 * @version Nov 3, 2014 9:15:35 PM
	 */
	public String getID() throws RemoteException;

	/**
	 * 以ID查找PO
	 * @param ID po的ID
	 * @return PO extends PersistentObject
	 * @author cylong
	 * @version 2014年12月1日 下午4:09:43
	 */
	public PO find(String ID) throws RemoteException;

	/**
	 * @return 远程服务的名字
	 * @throws RemoteException
	 * @author cylong
	 * @version 2014年12月14日 上午4:39:10
	 */
	public String getServiceName() throws RemoteException;
}
