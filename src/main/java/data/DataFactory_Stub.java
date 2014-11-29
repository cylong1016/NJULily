package data;

import java.rmi.RemoteException;

import dataservice.AccountBillDataService;
import dataservice.AccountDataService;
import dataservice.AccountaInitDataService;
import dataservice.ApprovalDataService;
import dataservice.CashBillDataService;
import dataservice.ClientDataService;
import dataservice.CommodityDataService;
import dataservice.CommoditySortDataService;
import dataservice.DataFactoryService;
import dataservice.InventoryDataService;
import dataservice.PromotionDataService;
import dataservice.PurchaseDataService;
import dataservice.RecordDataService;
import dataservice.SaleDataService;
import dataservice.UserDataService;

/**
 * @author cylong
 * @version Oct 26, 2014 8:15:56 PM
 */
public class DataFactory_Stub implements DataFactoryService {

	/**
	 * @see dataservice.DataFactoryService#getUserData()
	 */
	public UserDataService getUserData() {
		UserDataService userData = new UserDataService_Stub();
		return userData;
	}

	/**
	 * @see dataservice.DataFactoryService#getAccountaInitData()
	 */
	public AccountaInitDataService getAccountaInitData() {
		return null;
	}

	/**
	 * @see dataservice.DataFactoryService#getAccountData()
	 */
	public AccountDataService getAccountData() {
		return null;
	}

	/**
	 * @see dataservice.DataFactoryService#getApprovalData()
	 */
	public ApprovalDataService getApprovalData() {
		return null;
	}

	/**
	 * @see dataservice.DataFactoryService#getClientData()
	 */
	public ClientDataService getClientData() {
		return null;
	}

	/**
	 * @see dataservice.DataFactoryService#getCommodityData()
	 */
	public CommodityDataService getCommodityData() {
		return null;
	}

	/**
	 * @see dataservice.DataFactoryService#getCommoditySortData()
	 */
	public CommoditySortDataService getCommoditySortData() {
		return null;
	}

	/**
	 * @see dataservice.DataFactoryService#getInventoryData()
	 */
	public InventoryDataService getInventoryData() {
		return null;
	}

	/**
	 * @see dataservice.DataFactoryService#getPromotionData()
	 */
	public PromotionDataService getPromotionData() {
		return null;
	}

	/**
	 * @see dataservice.DataFactoryService#getPurchaseData()
	 */
	public PurchaseDataService getPurchaseData() {
		return null;
	}

	/**
	 * @see dataservice.DataFactoryService#getRecordData()
	 */
	public RecordDataService getRecordData() {
		return null;
	}

	/**
	 * @see dataservice.DataFactoryService#getSaleData()
	 */
	public SaleDataService getSaleData() {
		return null;
	}

	public AccountBillDataService getAccountBillData() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public CashBillDataService getCashBillData() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
