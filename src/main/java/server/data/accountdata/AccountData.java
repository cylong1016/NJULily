package server.data.accountdata;

import java.util.ArrayList;

import po.AccountPO;
import server.common.ParseXML;
import server.data.CommonData;
import dataenum.FindTypeAccount;
import dataservice.accountdataservice.AccountDataService;

/**
 * @see dataservice.accountdataservice.AccountDataService
 * @author cylong
 * @version 2014年11月30日 上午10:25:22
 */
public class AccountData extends CommonData<AccountPO> implements AccountDataService {

	/**
	 * @see dataservice.DataService#init()
	 */
	@Override
	public void init() {
		parsexml = new ParseXML("AccountData");
		prefix = parsexml.getValue("prefix");
	}

	/**
	 * @see server.data.CommonData#getID()
	 */
	@Override
	public String getID() {
		return prefix + super.getID();
	}

	/**
	 * @see dataservice.accountdataservice.AccountDataService#find(java.lang.String, dataenum.FindTypeAccount)
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
				if (Double.toString(account.getMoney()).contains(keywords)) {
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
