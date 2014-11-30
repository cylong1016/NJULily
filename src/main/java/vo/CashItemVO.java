package vo;

/**
 * 现金费用单中的条目清单
 * @author Zing
 * @version 2014年10月31日下午5:59:00
 */
public class CashItemVO {

	/** 条目名 */
	public String name;
	/** 金额 */
	public double money;
	/** 备注 */
	public String remark;
	
	public CashItemVO(String name, double money, String remark){
		this.name = name;
		this.money = money;
		this.remark = remark;
		
	}
}
