package businesslogic.accountbl;

import java.util.ArrayList;
import java.util.HashMap;

import vo.AccountVO;
import businesslogic.accountbillbl.AccountInfo_AccountBill;

/**
 * 共外部获得账户信息
 * @author cylong
 * @version 2014年12月1日 下午2:59:53
 */
public class AccountInfo implements AccountInfo_AccountBill {

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
}
