package businesslogicservice;

import message.ResultMessage;

/**
 * 负责实现资金管理界面所需要的服务
 * @author cylong
 * @version Oct 26, 2014 3:16:28 PM
 */
/**
 * 
 * @author Zing
 * @version 2014年10月28日下午5:38:33
 */
public interface FuntBLService {
	
	/**
	 * 建立收款单
	 * @param client
	 * @param account
	 * @param money
	 * @param remark
	 * @return
	 */
	public ResultMessage addExpenses(Client client, Account account, int money, String remark);
	
	/**
	 * 建立付款单
	 * @param client
	 * @param account
	 * @param money
	 * @param remark
	 * @return
	 */
	public ResultMessage addPay(Client client, Account account, int money, String remark);
	
	/**
	 * 建立现金费用单
	 * @param account
	 * @param name
	 * @param money
	 * @param remark
	 * @return
	 */
	public ResultMessage addCash(Account account, String name, int money, String remark)

	/**
	 * 提交单据
	 * @return
	 */
	public ResultMessage submit();
}
