package server.data;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.AccountBillDataService;
import dataservice.AccountDataService;
import dataservice.AccountaInitDataService;
import dataservice.ApprovalDataService;
import dataservice.CashBillDataService;
import dataservice.ClientDataService;
import dataservice.CommodityDataService;
import dataservice.CommoditySortDataService;
import dataservice.InventoryDataService;
import dataservice.PromotionDataService;
import dataservice.PurchaseDataService;
import dataservice.RecordDataService;
import dataservice.SaleDataService;
import dataservice.UserDataService;
import dataservice.commondata.DataFactoryService;

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
	 * @see dataservice.commondata.DataFactoryService#getAccountaInitData()
	 */
	@Override
	public AccountaInitDataService getAccountaInitData() throws RemoteException {
		return null;
	}

	/**
	 * @see dataservice.commondata.DataFactoryService#getAccountData()
	 */
	@Override
	public AccountDataService getAccountData() throws RemoteException {
		return null;
	}

	/**
	 * @see dataservice.commondata.DataFactoryService#getApprovalData()
	 */
	@Override
	public ApprovalDataService getApprovalData() throws RemoteException {
		return null;
	}

	/**
	 * @see dataservice.commondata.DataFactoryService#getClientData()
	 */
	@Override
	public ClientDataService getClientData() throws RemoteException {
		return null;
	}

	/**
	 * @see dataservice.commondata.DataFactoryService#getCommodityData()
	 */
	@Override
	public CommodityDataService getCommodityData() throws RemoteException {
		return null;
	}

	/**
	 * @see dataservice.commondata.DataFactoryService#getCommoditySortData()
	 */
	@Override
	public CommoditySortDataService getCommoditySortData() throws RemoteException {
		return null;
	}

	/**
	 * @see dataservice.commondata.DataFactoryService#getAccountBillData()
	 */
	@Override
	public AccountBillDataService getAccountBillData() throws RemoteException {
		return null;
	}

	/**
	 * @see dataservice.commondata.DataFactoryService#getInventoryData()
	 */
	@Override
	public InventoryDataService getInventoryData() throws RemoteException {
		return null;
	}

	/**
	 * @see dataservice.commondata.DataFactoryService#getPromotionData()
	 */
	@Override
	public PromotionDataService getPromotionData() throws RemoteException {
		return null;
	}

	/**
	 * @see dataservice.commondata.DataFactoryService#getPurchaseData()
	 */
	@Override
	public PurchaseDataService getPurchaseData() throws RemoteException {
		return null;
	}

	/**
	 * @see dataservice.commondata.DataFactoryService#getRecordData()
	 */
	@Override
	public RecordDataService getRecordData() throws RemoteException {
		return null;
	}

	/**
	 * @see dataservice.commondata.DataFactoryService#getSaleData()
	 */
	@Override
	public SaleDataService getSaleData() throws RemoteException {
		return null;
	}

	/**
	 * @see dataservice.commondata.DataFactoryService#getUserData()
	 */
	@Override
	public UserDataService getUserData() throws RemoteException {
		return null;
	}

	/**
	 * @see dataservice.commondata.DataFactoryService#getCashBillData()
	 */
	@Override
	public CashBillDataService getCashBillData() throws RemoteException {
		return null;
	}

}
