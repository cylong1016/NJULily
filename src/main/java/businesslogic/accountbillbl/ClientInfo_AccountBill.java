package businesslogic.accountbillbl;

import java.util.HashMap;

/**
 * @author cylong
 * @version Nov 16, 2014 5:08:25 PM
 */
public interface ClientInfo_AccountBill {

	/**
	 * @return 全部的客户ID和客户名 Key=>ID、value=>name
	 * @author cylong
	 * @version 2014年12月1日 上午1:24:33
	 */
	public HashMap<String, String> getAllClients();
}
