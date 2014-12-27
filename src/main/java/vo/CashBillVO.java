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
public class CashBillVO extends ValueObject {

	/** 操作员 */
	public String user;
	/** 银行账户 */
	public String account;
	/** 条目清单 */
	public ArrayList<CashItemVO> bills;
	/** 汇款总额 */
	public double total;
	/** 单据状态 */
	public BillState state;

	public CashBillVO(String ID, String user, String account, ArrayList<CashItemVO> bills, double total, BillState state) {
		this.ID = ID;
		this.user = user;
		this.account = account;
		this.bills = bills;
		this.total = total;
		this.state = state;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[单据ID=" + this.ID + ", " + "操作员=" + this.user + ", 账户=" + this.account + ", 条目清单="
				+ this.bills + ",\r\n总价=" + this.total + ", 状态=" + this.state.value + "]";
	}

}
