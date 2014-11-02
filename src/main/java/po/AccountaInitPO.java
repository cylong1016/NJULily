package po;

import java.util.ArrayList;



/**
 * 期初建账持久化对象
 * @author cylong
 * @version Oct 26, 2014  2:21:52 PM
 */
/**
 * 这个系统是可以支持建多套账的，每套帐在新建的时候都要经过期初建账这一环节，可以理解为一套帐的初始化操作。
 * 包括：
 * 添加商品信息（商品分类，某一商品的名称，类别，型号，进价/售价(默认为上年平均)，最近进价和最近售价留空），
 * 客户信息（客户分类，某一个客户的名称，联系方式等，应收应付(之前遗留)），
 * 银行账户信息（名称，余额）。
 * 期初的信息一旦建立完毕就会单独存储起来，同时将此信息作为系统的启动初始状态。
 * 之后的一切操作将会改变系统里的信息，但不会改变期初信息。期初信息随时可查。
 * @author Zing
 * @version 2014年11月2日下午3:54:10
 */
public class AccountaInitPO {
	private ArrayList<CommodityPO> commodities;
	
	private ArrayList<ClientPO> clients;
	
	private ArrayList<AccountPO> accounts;
	
	public AccountaInitPO(ArrayList<CommodityPO> commodities, ArrayList<ClientPO> clients, ArrayList<AccountPO> accounts){
		this.commodities = commodities;
		this.clients = clients;
		this.accounts = accounts;
	}

	public ArrayList<CommodityPO> getCommodities() {
		return commodities;
	}

	public void setCommodities(ArrayList<CommodityPO> commodities) {
		this.commodities = commodities;
	}

	public ArrayList<ClientPO> getClients() {
		return clients;
	}

	public void setClients(ArrayList<ClientPO> clients) {
		this.clients = clients;
	}

	public ArrayList<AccountPO> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<AccountPO> accounts) {
		this.accounts = accounts;
	}
	
}
