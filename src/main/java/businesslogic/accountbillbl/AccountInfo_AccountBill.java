package businesslogic.accountbillbl;

import java.util.HashMap;

/**
 * @author cylong
 * @version Nov 16, 2014 5:09:45 PM
 */
public interface AccountInfo_AccountBill {

	/**
	 * @return 全部的账户ID和账户名 Key=>ID、value=>name
	 * @author cylong
	 * @version 2014年12月1日 上午1:23:52
	 */
	public HashMap<String, String> getAllAccounts();
	
}
