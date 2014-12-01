package server.data;

import java.util.ArrayList;

import po.AccountPO;
import server.common.ParseXML;
import server.io.DefineList;
import dataenum.FindTypeAccount;
import dataservice.AccountDataService;

/**
 * @see dataservice.AccountDataService
 * @author cylong
 * @version 2014年11月30日 上午10:25:22
 */
public class AccountData extends CommonData<AccountPO> implements AccountDataService {

	/**
	 * @see dataservice.DataService#init()
	 */
	@Override
	public void init() {
		ParseXML parsexml = new ParseXML("AccountData");
		filePath = parsexml.getValue("path");
		initID = parsexml.getValue("initID");
		poList = new DefineList<AccountPO>(filePath);
	}

	/**
	 * @see dataservice.AccountDataService#find(java.lang.String, dataenum.FindTypeAccount)
	 */
	@Override
	public ArrayList<AccountPO> find(String keywords, FindTypeAccount type) {
		keywords = keywords.toLowerCase(); // 为了不区分大小写
		ArrayList<AccountPO> accounts = new ArrayList<AccountPO>();
		if (type == null) {	// 查找账户全部信息
			for(AccountPO account : poList.getInList()) {
				if (account.toString().toLowerCase().contains(keywords)) {
					accounts.add(account);
				}
			}
			return accounts;
		}
		switch(type) {
		case ID:
			for(AccountPO account : poList.getInList()) {
				if (account.getID().toLowerCase().contains(keywords)) {
					accounts.add(account);
				}
			}
			break;
		case MONEY:
			for(AccountPO account : poList.getInList()) {
				if (Double.toString(account.getMoney()).toLowerCase().contains(keywords)) {
					accounts.add(account);
				}
			}
			break;
		case NAME:
			for(AccountPO account : poList.getInList()) {
				if (account.getName().toLowerCase().contains(keywords)) {
					accounts.add(account);
				}
			}
			break;
		default:
			break;
		}

		return accounts;
	}
}
