package server.data.accountbilldata;

import po.AccountBillPO;
import server.data.TableInfo;

/**
 * @see dataservice.accountbilldataservice.AccountBillInfoService
 * @author cylong
 * @version 2014年12月2日 上午3:24:03
 */
public class AccountBillInfo extends TableInfo<AccountBillPO> {

	private AccountBillData accountBillData;

	/**
	 * @see server.data.TableInfo#initPOs()
	 */
	@Override
	protected void initPOs() {
		accountBillData = new AccountBillData();
		pos = accountBillData.show();
	}

	/**
	 * @see server.data.TableInfo#getClient(java.lang.String)
	 */
	@Override
	public String getClient(String billID) {
		return accountBillData.find(billID).getClientID();
	}

}
