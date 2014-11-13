package po;

import java.util.ArrayList;

/**
 * 现金费用单
 * 管理报销等现金操作，单据中包含：单据编号（XJFYD-yyyyMMdd-xxxxx）,
 * 操作员（当前登录用户），银行账户，条目清单，总额。
 * 条目清单中包括：条目名，金额，备注。
 * @author Zing
 * @version 2014年10月31日下午5:55:13
 */
public class CashBillPO extends PersistentObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 编号 */
	private String id;
	/** 操作员 */
	private UserPO user;
	/** 银行账户 */
	private AccountPO account;
	/**  条目清单*/
	private ArrayList<CashItemPO> bills;
	/** 汇款总额 */
	private int sumMoney;
	
	public CashBillPO(String id, UserPO user, AccountPO account, ArrayList<CashItemPO> bills, int sumMoney) {
		super(id);
		this.id = id;
		this.user = user;
		this.account = account;
		this.bills = bills;
		this.sumMoney = sumMoney;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UserPO getUser() {
		return user;
	}

	public void setUser(UserPO user) {
		this.user = user;
	}

	public AccountPO getAccount() {
		return account;
	}

	public void setAccount(AccountPO account) {
		this.account = account;
	}

	public ArrayList<CashItemPO> getBills() {
		return bills;
	}

	public void setBills(ArrayList<CashItemPO> bills) {
		this.bills = bills;
	}

	public int getSumMoney() {
		return sumMoney;
	}

	public void setSumMoney(int sumMoney) {
		this.sumMoney = sumMoney;
	}
	
	
	
}
