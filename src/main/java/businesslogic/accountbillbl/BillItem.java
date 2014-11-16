package businesslogic.accountbillbl;

/**
 * 转账列表的Item
 * @author cylong
 * @version Nov 16, 2014 4:14:11 PM
 */
public class BillItem {

	/** 银行账户 */
	public String accountName;
	/** 转账金额 */
	public int money;
	/** 备注 */
	public String remark;

	public BillItem(String accountName, int money, String remark) {
		super();
		this.accountName = accountName;
		this.money = money;
		this.remark = remark;
	}

}
