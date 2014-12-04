package vo;

/**
 * 付款、收款单中的转账列表
 * @author Zing
 * @version 2014年10月31日下午5:52:30
 */
/**
 * 修改原因: @see po.AccountBillItemPO
 * @author cylong
 * @version Nov 16, 2014 3:40:03 PM
 */
public class AccountBillItemVO {

	/** 银行账户名 */
	public String accountName;
	/** 转账金额 */
	public double money;
	/** 备注 */
	public String remark;

	public AccountBillItemVO(String accountName, double money, String remark) {
		this.accountName = accountName;
		this.money = money;
		this.remark = remark;
	}
}
