package businesslogic.accountbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import dataservice.accountdataservice.AccountDataService;
import po.AccountPO;
import vo.AccountVO;
import businesslogic.accountbillbl.info.AccountInfo_AccountBill;
import businesslogic.accountinitbl.info.AccountInfo_Init;
import businesslogic.cashbillbl.info.AccountInfo_CashBill;

/**
 * 共外部获得账户信息
 * @author cylong
 * @version 2014年12月1日 下午2:59:53
 */
public class AccountInfo implements AccountInfo_AccountBill, AccountInfo_Init, AccountInfo_CashBill {

	private Account account;
	private AccountDataService accountData;
	public AccountInfo() {
		account = new Account();
		accountData = account.getAccountData();
	}

	/**
	 * @throws RemoteException
	 * @see businesslogic.accountbillbl.info.AccountInfo_AccountBill#getAllAccounts()
	 */
	@Override
	public HashMap<String, String> getAllAccounts() throws RemoteException {
		ArrayList<AccountVO> accountsVO = account.show();
		HashMap<String, String> accounts = new HashMap<String, String>();
		for(int i = 0; i < accountsVO.size(); i++) {
			AccountVO vo = accountsVO.get(i);
			accounts.put(vo.ID, vo.name);
		}
		return accounts;
	}

	public ArrayList<AccountPO> getAccountPOs() throws RemoteException {
		return accountData.show();
	}

	/**
	 * @see businesslogic.accountinitbl.info.AccountInfo_Init#getAccountVOs(java.util.ArrayList)
	 */
	public ArrayList<AccountVO> getAccountVOs(ArrayList<AccountPO> POs) {
		return account.POstoVOs(POs);
	}

	/**
	 * 现金费用单通过审批后， 对应的账户的余额减少
	 * 付款单通过审批后，对应账户的余额减少
	 * 收款单通过审批后，对应账户的余额增加
	 * @throws RemoteException
	 */
	public void changeMoney(String accountName, double money) throws RemoteException {
		ArrayList<AccountPO> POs = accountData.show();
		for(AccountPO po : POs) {
			if (po.getName().equals(accountName)) {
				po.setMoney(po.getMoney() + money);
				accountData.update(po);
				return;
			}
		}
	}
}
