package vo;

/**
 * 付款、收款单中的转账列表
 * @author Zing
 * @version 2014年10月31日下午5:52:30
 */
public class BillItemVO {

	/** 银行账户 */
	public AccountVO account;
	
	/** 转账金额 */
	public int money;
	
	/** 备注 */
	public String remark;
	
	public BillItemVO(AccountVO account, int money, String remark){
		this.account = account;
		this.money = money;
		this.remark = remark;
		
	}
}
