package data;

import dataservice.DataFactoryService;
import dataservice.DataService;
import dataservice.UserDataService;

/**
 * @author cylong
 * @version Oct 26, 2014 8:15:56 PM
 */
public class DataFactory_Stub implements DataFactoryService {

	/**
	 * @see dataservice.DataFactoryService#getUserData()
	 */
	public DataService getUserData() {
		UserDataService userData = new UserDataService_Stub();
		return userData;
	}

	/**
	 * @see dataservice.DataFactoryService#getAccountaInitData()
	 */
	public DataService getAccountaInitData() {
		return null;
	}

	/**
	 * @see dataservice.DataFactoryService#getAccountData()
	 */
	public DataService getAccountData() {
		return null;
	}

	/**
	 * @see dataservice.DataFactoryService#getApprovalData()
	 */
	public DataService getApprovalData() {
		return null;
	}

	/**
	 * @see dataservice.DataFactoryService#getClientData()
	 */
	public DataService getClientData() {
		return null;
	}

	/**
	 * @see dataservice.DataFactoryService#getCommodityData()
	 */
	public DataService getCommodityData() {
		return null;
	}

	/**
	 * @see dataservice.DataFactoryService#getCommoditySortData()
	 */
	public DataService getCommoditySortData() {
		return null;
	}

	/**
	 * @see dataservice.DataFactoryService#getFundData()
	 */
	public DataService getFundData() {
		return null;
	}

	/**
	 * @see dataservice.DataFactoryService#getInventoryData()
	 */
	public DataService getInventoryData() {
		return null;
	}

	/**
	 * @see dataservice.DataFactoryService#getPromotionData()
	 */
	public DataService getPromotionData() {
		return null;
	}

	/**
	 * @see dataservice.DataFactoryService#getPurchaseData()
	 */
	public DataService getPurchaseData() {
		return null;
	}

	/**
	 * @see dataservice.DataFactoryService#getRecordData()
	 */
	public DataService getRecordData() {
		return null;
	}

	/**
	 * @see dataservice.DataFactoryService#getSaleData()
	 */
	public DataService getSaleData() {
		return null;
	}

}
