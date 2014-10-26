package dataservice;


/**
 * 抽象工厂，返回数据层模块接口
 * @author cylong
 * @version Oct 26, 2014  3:26:01 PM
 */
public interface DataFactoryService {
	public DataService getAccountaInitData();
	public DataService getAccountData();
	public DataService getApprovalData();
	public DataService getClientData();
	public DataService getCommodityData();
	public DataService getCommodityManageData();
	public DataService getFundData();
	public DataService getInventoryData();
	public DataService getPromotionData();
	public DataService getPurchaseData();
	public DataService getRecordData();
	public DataService getSaleData();
	public DataService getUserData();
}
