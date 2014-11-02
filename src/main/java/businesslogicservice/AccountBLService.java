package businesslogicservice;

import message.ResultMessage;


/**
 * 负责实现公司账户界面所需要的服务
 * @author cylong
 * @version Oct 26, 2014 3:15:56 PM
 */
/**
 * 账户管理（账户指的是此家公司的银行账户，仅限最高权限可以查看账户名称和余额。
 * 账号的属性有：名称和金额。余额不可修改，此数据项取决于收款单和付款单。
 * 账户的增删改查包括增加账户、删除账户、修改账户属性和查询账户。
 * 账号的查询可以通过输入关键字进行模糊查找。仅限最高权限可进行这些操作。）
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
