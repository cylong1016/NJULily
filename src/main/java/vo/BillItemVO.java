package vo;

/**
 * 付款、收款单中的转账列表
 * @author Zing
 * @version 2014年10月31日下午5:52:30
 */
/**
 * 修改原因: @see po.BillItemPO
 * @author cylong
 * @version Nov 16, 2014 3:40:03 PM
 */
public class BillItemVO {

	/** 银行账户 */
	public String accountName;
	/** 转账金额 */
	public int money;
	/** 备注 */
	public String remark;

	public BillItemVO(String accountName, int money, String remark) {
		this.accountName = accountName;
		this.money = money;
		this.remark = remark;
	}
}
