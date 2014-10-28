package businesslogicservice;

import message.ResultMessage;


/**
 * 负责实现公司账户界面所需要的服务
 * @author cylong
 * @version Oct 26, 2014 3:15:56 PM
 */
/**
 * 
 * @author Zing
 * @version 2014年10月28日下午6:04:46
 */
public interface AccountBLService {
	/**
	 * 
	 * @param keyword
	 * @return
	 */
	public ResultMessage findAccount(String keyword);

	/**
	 * 
	 * @param name
	 * @param money
	 * @return
	 */
	public ResultMessage addAccount(String name, int money);
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public ResultMessage deleteAccount(String name);

	/**
	 * 
	 * @param name
	 * @return
	 */
	public ResultMessage updAccount(String name);
}
