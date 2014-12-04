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
	
	/**
	 * 更改客户的应付
	 * @param clientID
	 * @param money
	 * @author Zing
	 * @version Dec 4, 2014 5:31:00 PM
	 */
	public void changePayable(String clientID, double money);
	
	/**
	 * 更改客户的应收
	 * @param clientID
	 * @param money
	 * @author Zing
	 * @version Dec 4, 2014 5:31:10 PM
	 */
	public void changeReceivable(String clientID, double money);
}
