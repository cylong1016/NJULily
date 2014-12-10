package server.data;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import server.data.accountbilldata.AccountBillData;
import server.data.accountdata.AccountData;
import server.data.accountinitdata.AccountInitData;
import server.data.cashbilldata.CashBillData;
import server.data.clientdata.ClientData;
import server.data.commoditydata.CommodityData;
import server.data.commoditysortdata.CommoditySortData;
import server.data.inventorydata.InventoryData;
import server.data.promotiondata.PromotionData;
import server.data.purchasedata.PurchaseData;
import server.data.saledata.SaleData;
import server.data.userdata.UserData;
import dataservice.DataFactoryService;
import dataservice.accountbilldataservice.AccountBillDataService;
import dataservice.accountdataservice.AccountDataService;
import dataservice.accountinitdataservice.AccountaInitDataService;
import dataservice.cashbilldataservice.CashBillDataService;
import dataservice.clientdataservice.ClientDataService;
import dataservice.commoditydataservice.CommodityDataService;
import dataservice.commoditysortdataservice.CommoditySortDataService;
import dataservice.inventorydataservice.InventoryDataService;
import dataservice.promotiondataservice.PromotionDataService;
import dataservice.purchasedataservice.PurchaseDataService;
import dataservice.saledataservice.SaleDataService;
import dataservice.userdataservice.UserDataService;

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
	@Override
	public AccountaInitDataService getAccountaInitData() throws RemoteException {
		return new AccountInitData();
	}

	/**
	 * @see dataservice.DataFactoryService#getAccountData()
	 */
	@Override
	public AccountDataService getAccountData() throws RemoteException {
		return new AccountData();
	}

	/**
	 * @see dataservice.DataFactoryService#getClientData()
	 */
	@Override
	public ClientDataService getClientData() throws RemoteException {
		return new ClientData();
	}

	/**
	 * @see dataservice.DataFactoryService#getCommodityData()
	 */
	@Override
	public CommodityDataService getCommodityData() throws RemoteException {
		return new CommodityData();
	}

	/**
	 * @see dataservice.DataFactoryService#getCommoditySortData()
	 */
	@Override
	public CommoditySortDataService getCommoditySortData() throws RemoteException {
		return new CommoditySortData();
	}

	/**
	 * @see dataservice.DataFactoryService#getAccountBillData()
	 */
	@Override
	public AccountBillDataService getAccountBillData() throws RemoteException {
		return new AccountBillData();
	}

	/**
	 * @see dataservice.DataFactoryService#getInventoryData()
	 */
	@Override
	public InventoryDataService getInventoryData() throws RemoteException {
		return new InventoryData();
	}

	/**
	 * @see dataservice.DataFactoryService#getPromotionData()
	 */
	@Override
	public PromotionDataService getPromotionData() throws RemoteException {
		return new PromotionData();
	}

	/**
	 * @see dataservice.DataFactoryService#getPurchaseData()
	 */
	@Override
	public PurchaseDataService getPurchaseData() throws RemoteException {
		return new PurchaseData();
	}

	/**
	 * @see dataservice.DataFactoryService#getSaleData()
	 */
	@Override
	public SaleDataService getSaleData() throws RemoteException {
		return new SaleData();
	}

	/**
	 * @see dataservice.DataFactoryService#getUserData()
	 */
	@Override
	public UserDataService getUserData() throws RemoteException {
		return new UserData();
	}

	/**
	 * @see dataservice.DataFactoryService#getCashBillData()
	 */
	@Override
	public CashBillDataService getCashBillData() throws RemoteException {
		return new CashBillData();
	}

}
