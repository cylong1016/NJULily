package businesslogicservice;

import java.util.HashMap;

import message.ResultMessage;
import dataenum.BillType;

/**
 * 负责实现资金管理界面所需要的服务
 * @author cylong
 * @version Oct 26, 2014 3:16:28 PM
 */
/**
 * 建立收款单、付款单
 * @author Zing
 * @version 2014年10月28日下午5:38:33
 */
/**
 * 修改了getID、addBillItem、getSumMoney、addExpenses、addPay方法
 * 添加了addClient方法
 * @author cylong
 * @version Nov 16, 2014 3:48:21 PM
 */
public interface AccountBillBLService {

	/**
	 * 得到收款单或者付款单的ID，返回给界面显示
	 * 在创建收款单（付款单）的时候界面调用这个方法先显示单据的ID
	 * @return 可用的ID
	 */
	public String getID(BillType type);
	
	/**
	 * @return 全部的客户ID和客户名 Key=>ID、value=>name
	 * @author cylong
	 * @version Nov 16, 2014  3:58:24 PM
	 */
	public HashMap<String, String> getAllClients();

	/**
	 * 添加客户【界面传过来客户ID和客户名，添加客户的时候有一个下拉列表选择存在的客户】
	 * @param clientID
	 * @author cylong
	 * @version Nov 16, 2014 3:14:54 PM
	 */
	public ResultMessage addClient(String clientID, String clientName);

	/**
	 * @return 全部的账户ID和账户名  Key=>ID、value=>name
	 * @author cylong
	 * @version Nov 16, 2014  4:00:14 PM
	 */
	public HashMap<String, String> getAllAccountName();
	/**
	 * 添加转账列表【界面有一个下拉列表选择账户名】
	 * @param accountName
	 * @param money
	 * @param remark
	 * @return 是否成功
	 */
	public ResultMessage addBillItem(String accountName, int money, String remark);

	/**
	 * 得到总额，界面显示
	 * @return 总额
	 */
	public double getSumMoney();

	/**
	 * 建立新的收款单
	 * @return 是否成功
	 */
	public ResultMessage addExpenses();

	/**
	 * 建立付款单
	 * @return 是否成功
	 */
	public ResultMessage addPay();

	/**
	 * 提交单据
	 * @return 是否成功
	 */
	public ResultMessage submit();
}
