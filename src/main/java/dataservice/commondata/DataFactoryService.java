package dataservice.commondata;

import java.rmi.Remote;
import java.rmi.RemoteException;

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

/**
 * 抽象工厂，返回数据层模块接口
 * @author cylong
 * @version Oct 26, 2014 3:26:01 PM
 */
public interface DataFactoryService extends Remote {

	public AccountaInitDataService getAccountaInitData() throws RemoteException;

	public AccountDataService getAccountData() throws RemoteException;

	public ApprovalDataService getApprovalData() throws RemoteException;

	public ClientDataService getClientData() throws RemoteException;

	public CommodityDataService getCommodityData() throws RemoteException;

	public CommoditySortDataService getCommoditySortData() throws RemoteException;

	public AccountBillDataService getAccountBillData() throws RemoteException;

	public InventoryDataService getInventoryData() throws RemoteException;

	public PromotionDataService getPromotionData() throws RemoteException;

	public PurchaseDataService getPurchaseData() throws RemoteException;

	public RecordDataService getRecordData() throws RemoteException;

	public SaleDataService getSaleData() throws RemoteException;

	public UserDataService getUserData() throws RemoteException;
	
	public CashBillDataService getCashBillData() throws RemoteException;
}
