package businesslogic.accountainitbl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import businesslogic.accountainitbl.info.AccountInfo_Init;
import businesslogic.accountainitbl.info.ClientInfo_Init;
import businesslogic.accountainitbl.info.CommodityInfo_Init;
import businesslogic.accountainitbl.info.CommoditySortInfo_Init;
import businesslogic.accountbl.AccountInfo;
import businesslogic.clientbl.ClientInfo;
import businesslogic.commoditybl.CommodityInfo;
import businesslogic.commoditysortbl.CommoditySortInfo;
import po.AccountPO;
import po.ClientPO;
import po.CommodityPO;
import po.CommoditySortPO;

public class BuildInit {
	private String date;
	
	private String ID;
	
	private ArrayList<CommoditySortPO> commoditySorts;

	private ArrayList<CommodityPO> commodities;

	private ArrayList<ClientPO> clients;

	private ArrayList<AccountPO> accounts;
	
	public BuildInit(String ID) {
		this.ID = ID;
	}
	
	/**
	 * 得到当天日期
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 7:50:11 PM
	 */
	public String getDate(){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		date = sdf.format(calendar.getTime());
		return date;
	}
	
	/**
	 * 得到ID
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 7:55:00 PM
	 */
	public String getID() {
		return ID;
	}

	public ArrayList<CommoditySortPO> getCommoditySorts() {
		CommoditySortInfo_Init info = new CommoditySortInfo();
		commoditySorts = info.getSortPOs();
		return commoditySorts;
	}

	public ArrayList<CommodityPO> getCommodities() {
		CommodityInfo_Init info = new CommodityInfo();
		commodities = info.getCommodityPOs();
		return commodities;
	}

	public ArrayList<ClientPO> getClients() {
		ClientInfo_Init info = new ClientInfo();
		clients = info.getClientPOs();
		return clients;
	}

	public ArrayList<AccountPO> getAccounts() {
		AccountInfo_Init info = new AccountInfo();
		accounts = info.getAccountPOs();
		return accounts;
	}
	
	
	
}
