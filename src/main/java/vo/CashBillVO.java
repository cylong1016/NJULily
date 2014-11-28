package vo;

import java.util.ArrayList;

import dataenum.BillState;
/**
 * 现金费用单
 * 管理报销等现金操作，单据中包含：单据编号（XJFYD-yyyyMMdd-xxxxx）,
 * 操作员（当前登录用户），银行账户，条目清单，总额。
 * 条目清单中包括：条目名，金额，备注。
 * @author Zing
 * @version 2014年10月31日下午5:56:51
 */
public class CashBillVO {
	
	/** 编号 */
	public String id;
	/** 操作员 */
	public UserVO user;
	/** 银行账户 */
	public AccountVO account;
	/**  条目清单*/
	public ArrayList<CashItemVO> bills;
	/** 汇款总额 */
	public int sumMoney;
	/** 单据状态 */
	public BillState state;
	
	public CashBillVO(String id, UserVO user, AccountVO account, ArrayList<CashItemVO> bills, int sumMoney, BillState state) {
		this.id = id;
		this.user = user;
		this.account = account;
		this.bills = bills;
		this.sumMoney = sumMoney;
		this.state = state;
	}

}
