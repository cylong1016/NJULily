package businesslogic.accountbl;

import java.util.ArrayList;
import java.util.HashMap;

import po.AccountPO;
import vo.AccountVO;
import businesslogic.accountainitbl.info.AccountInfo_Init;
import businesslogic.accountbillbl.AccountInfo_AccountBill;
import businesslogic.cashbillbl.AccountInfo_CashBill;

/**
 * 共外部获得账户信息
 * @author cylong
 * @version 2014年12月1日 下午2:59:53
 */
public class AccountInfo implements AccountInfo_AccountBill, AccountInfo_Init, AccountInfo_CashBill{

	private Account account;

	public AccountInfo() {
		account = new Account();
	}

	/**
	 * @see businesslogic.accountbillbl.AccountInfo_AccountBill#getAllAccounts()
	 */
	@Override
	public HashMap<String, String> getAllAccounts() {
		ArrayList<AccountVO> accountsVO = account.show();
		HashMap<String, String> accounts = new HashMap<String, String>();
		for(int i = 0; i < accountsVO.size(); i++) {
			AccountVO vo = accountsVO.get(i);
			accounts.put(vo.ID, vo.name);
		}
		return accounts;
	}

	public ArrayList<AccountPO> getAccountPOs() {
		return account.getAccountData().show();
	}

	public ArrayList<AccountVO> getAccountVOs(ArrayList<AccountPO> POs) {
		return account.POstoVOs(POs);
	}

	/**
	 * 现金费用单通过审批后， 对应的账户的余额减少
	 */
	public void changeMoney(String accountName, double money) {
		ArrayList<AccountPO> POs = account.getAccountData().show();
		for (AccountPO po : POs) {
			if (po.getName().equals(accountName)) {
				po.setMoney(po.getMoney()-money);
				return;
			}
		}
	}
}
