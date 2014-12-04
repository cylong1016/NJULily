package blservice.accountbillblservice;

import java.util.ArrayList;
import java.util.HashMap;

import message.ResultMessage;
import vo.AccountBillItemVO;
import vo.AccountBillVO;
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
 * @author cylong
 * @version Nov 16, 2014 3:48:21 PM
 */
/**
 * 将addExpenses、addPay方法合为一个addAccountBill方法
 * @author cylong
 * @version 2014年12月1日 上午1:53:23
 */
public interface AccountBillBLService {

	/**
	 * 得到收款单或者付款单的ID，返回给界面显示
	 * 在创建收款单（付款单）的时候界面调用这个方法先显示单据的ID
	 * @return 可用的ID
	 */
	public String getID(BillType type);

	/**
	 * 根据ID精确查找账单
	 * @param ID 账单ID
	 * @return AccountBillVO
	 * @author cylong
	 * @version 2014年12月1日 下午5:05:51
	 */
	public AccountBillVO find(String ID);

	/**
	 * @return 全部的客户ID和客户名 Key=>ID、value=>name
	 * @author cylong
	 * @version Nov 16, 2014 3:58:24 PM
	 */
	public HashMap<String, String> getAllClients();

	/**
	 * @return 全部的账户ID和账户名 Key=>ID、value=>name
	 * @author cylong
	 * @version Nov 16, 2014 4:00:14 PM
	 */
	public HashMap<String, String> getAllAccounts();

	/**
	 * 添加转账列表的一条记录
	 * @param vo
	 * @author cylong
	 * @version 2014年12月1日 上午1:52:39
	 */
	public void addBillItem(AccountBillItemVO vo);

	/**
	 * 得到总额，界面显示
	 * @return 总额
	 */
	public double getSumMoney();

	/**
	 * 建立新的收款单（付款单），单据类型在前面的getID方法已经得到
	 * @param clientID 客户的ID【添加客户的时候有一个下拉列表选择存在的客户】
	 * @author cylong
	 * @version 2014年11月30日 下午10:32:37
	 */
	public void addAccountBill(String clientID, String clientName);

	/**
	 * 显示全部的收款单和付款单
	 * @return ArrayList<AccountBillVO>
	 * @author cylong
	 * @version 2014年12月1日 下午3:09:43
	 */
	public ArrayList<AccountBillVO> show();

	/**
	 * 返回全部的收款单或者付款单【传入单据类型】
	 * @param type 单据类型
	 * @return ArrayList<AccountBillVO>
	 * @author cylong
	 * @version 2014年12月1日 下午3:10:03
	 */
	public ArrayList<AccountBillVO> show(BillType type);

	/**
	 * 提交单据进行审批
	 * @return 是否成功
	 */
	public ResultMessage submit();

	/**
	 * 保存成草稿状态
	 * @return 处理结果
	 * @author cylong
	 * @version 2014年11月30日 下午10:36:23
	 */
	public ResultMessage save();
}
