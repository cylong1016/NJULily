package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 抽象工厂，返回数据层模块接口
 * @author cylong
 * @version Oct 26, 2014 3:26:01 PM
 */
public interface DataFactoryService extends Remote {

	public DataService getAccountaInitData() throws RemoteException;

	public DataService getAccountData() throws RemoteException;

	public DataService getApprovalData() throws RemoteException;

	public DataService getClientData() throws RemoteException;

	public DataService getCommodityData() throws RemoteException;

	public DataService getCommodityManageData() throws RemoteException;

	public DataService getFundData() throws RemoteException;

	public DataService getInventoryData() throws RemoteException;

	public DataService getPromotionData() throws RemoteException;

	public DataService getPurchaseData() throws RemoteException;

	public DataService getRecordData() throws RemoteException;

	public DataService getSaleData() throws RemoteException;

	public DataService getUserData() throws RemoteException;
}
