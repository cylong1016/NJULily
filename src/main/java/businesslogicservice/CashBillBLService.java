package businesslogicservice;

import java.util.ArrayList;

import message.ResultMessage;
import vo.AccountVO;
import vo.CashItemVO;
import vo.UserVO;
import dataenum.BillType;

/**
 * 建立现金费用单
 * 制定现金费用单
 * （管理报销等现金操作，单据中包含：单据编号（XJFYD-yyyyMMdd-xxxxx）,
 * 操作员（当前登录用户），银行账户，条目清单，总额。
 * 条目清单中包括：条目名，金额，备注。
 * 填写完毕后点击“提交”即可将此单据入账。入账后将会减少该账户的余额。
 * @author Zing
 * @version 2014年10月31日下午6:00:29
 */
public interface CashBillBLService {
	
	/**
	 * 得到收款单的ID
	 * @return
	 */
	public ResultMessage getID(BillType type);
	
	/**
	 * 添加条目清单
	 * @param name
	 * @param money
	 * @param remark
	 * @return
	 */
	public ResultMessage addBillItem(String name, int money, String remark);
	
	/**
	 * 得到总额
	 * @param accounts
	 * @return
	 */
	public ResultMessage getSumMoney(ArrayList<CashItemVO> bills);
	
	/**
	 * 建立新的现金费用单
	 * @param id
	 * @param client
	 * @param user
	 * @param accounts
	 * @param sumMoney
	 * @return
	 */
	public ResultMessage addExpenses(String id, UserVO user, AccountVO account, ArrayList<CashItemVO> bills, int sumMoney);

	
	/**
	 * 提交单据
	 * @return
	 */
	public ResultMessage submit();
}
