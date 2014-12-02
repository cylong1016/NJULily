package po;

import java.io.Serializable;

/**
 * 收款、付款单中的转账列表
 * @author Zing
 * @version 2014年10月31日下午5:53:22
 */
/**
 * 修改原因：将accountPO改成accountName，因为只需要保存账户名称
 * @author cylong
 * @version Nov 16, 2014 3:41:28 PM
 */
public class AccountBillItemPO implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = -4954487055647124897L;
	/** 银行账户ID */
	private String accountID;
	/** 转账金额 */
	private double money;
	/** 备注 */
	private String remark;

	public AccountBillItemPO(String accountID, double money, String remark) {
		this.accountID = accountID;
		this.money = money;
		this.remark = remark;
	}

	public double getMoney() {
		return money;
	}

	public String getRemark() {
		return remark;
	}

	public String getAccountID() {
		return this.accountID;
	}


}
