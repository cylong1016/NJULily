package po;

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
public class BillItemPO {

	/** 银行账户 */
	private String accountName;
	/** 转账金额 */
	private int money;
	/** 备注 */
	private String remark;

	public BillItemPO(String accountName, int money, String remark) {
		this.accountName = accountName;
		this.money = money;
		this.remark = remark;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

}
