package businesslogicservice;

import java.util.ArrayList;

import dataenum.BillType;
import vo.AccountVO;
import vo.BillItemVO;
import vo.ClientVO;
import vo.UserVO;
import message.ResultMessage;

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
public interface AccountBillBLService {
	
	/**
	 * 得到收款单的ID
	 * @return
	 */
	public ResultMessage getID(BillType type);
	
	/**
	 * 添加转账列表
	 * @param account
	 * @param money
	 * @param remark
	 * @return
	 */
	public ResultMessage addBillItem(AccountVO account, int money, String remark);
	
	/**
	 * 得到总额
	 * @param accounts
	 * @return
	 */
	public ResultMessage getSumMoney(ArrayList<BillItemVO> accounts);
	
	/**
	 * 建立新的收款单
	 * @param id
	 * @param client
	 * @param user
	 * @param accounts
	 * @param sumMoney
	 * @return
	 */
	public ResultMessage addExpenses(String id, ClientVO client, UserVO user, ArrayList<BillItemVO> bills, int sumMoney);
	
	/**
	 * 建立付款单
	 * @param client
	 * @param account
	 * @param money
	 * @param remark
	 * @return
	 */
	public ResultMessage addPay(String id, ClientVO client, UserVO user, ArrayList<BillItemVO> bills, int sumMoney);
	
	/**
	 * 提交单据
	 * @return
	 */
	public ResultMessage submit();
}
