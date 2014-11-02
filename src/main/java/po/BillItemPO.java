package po;

/**
 * 收款、付款单中的转账列表
 * @author Zing
 * @version 2014年10月31日下午5:53:22
 */
public class BillItemPO {
	
	/** 银行账户 */
	private AccountPO account;
	/** 转账金额 */
	private int money;
	/** 备注 */
	private String remark;
	
	public BillItemPO(AccountPO account, int money, String remark){
		this.account = account;
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


	public AccountPO getAccount() {
		return account;
	}


	public void setAccount(AccountPO account) {
		this.account = account;
	}
	
	

}

