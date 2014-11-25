package server.data;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.DataFactoryService;
import dataservice.DataService;

/**
 * 抽象工厂，返回数据层模块接口
 * @author cylong
 * @version Nov 2, 2014 5:09:28 PM
 */
public class DataFactory extends UnicastRemoteObject implements DataFactoryService {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/**
	 * @throws RemoteException
	 * @author cylong
	 * @version Nov 2, 2014 5:11:29 PM
	 */
	public DataFactory() throws RemoteException {
		super();
	}

	/**
	 * @see dataservice.DataFactoryService#getAccountaInitData()
	 */
	public DataService getAccountaInitData() throws RemoteException {
		return null;
	}

	/**
	 * @see dataservice.DataFactoryService#getAccountData()
	 */
	public DataService getAccountData() throws RemoteException {
		return null;
	}

	/**
	 * @see dataservice.DataFactoryService#getApprovalData()
	 */
	public DataService getApprovalData() throws RemoteException {
		return null;
	}

	/**
	 * @see dataservice.DataFactoryService#getClientData()
	 */
	public DataService getClientData() throws RemoteException {
		return new ClientData();
	}

	/**
	 * @see dataservice.DataFactoryService#getCommodityData()
	 */
	public DataService getCommodityData() throws RemoteException {
		return null;
	}

	/**
	 * @see dataservice.DataFactoryService#getFundData()
	 */
	public DataService getFundData() throws RemoteException {
		return null;
	}

	/**
	 * @see dataservice.DataFactoryService#getInventoryData()
	 */
	public DataService getInventoryData() throws RemoteException {
		return null;
	}

	/**
	 * @see dataservice.DataFactoryService#getPromotionData()
	 */
	public DataService getPromotionData() throws RemoteException {
		return null;
	}

	/**
	 * @see dataservice.DataFactoryService#getPurchaseData()
	 */
	public DataService getPurchaseData() throws RemoteException {
		return null;
	}

	/**
	 * @see dataservice.DataFactoryService#getRecordData()
	 */
	public DataService getRecordData() throws RemoteException {
		return null;
	}

	/**
	 * @see dataservice.DataFactoryService#getSaleData()
	 */
	public DataService getSaleData() throws RemoteException {
		return null;
	}

	/**
	 * @see dataservice.DataFactoryService#getUserData()
	 */
	public DataService getUserData() throws RemoteException {
		return new UserData();
	}

	/**
	 * @see dataservice.DataFactoryService#getCommoditySortData()
	 */
	public DataService getCommoditySortData() throws RemoteException {
		return null;
	}

	/**
	 * @see dataservice.DataFactoryService#getAccountBillData()
	 */
	public DataService getAccountBillData() throws RemoteException {
		return null;
	}

	/**
	 * @see dataservice.DataFactoryService#getCashBillData()
	 */
	public DataService getCashBillData() throws RemoteException {
		return null;
	}

}
