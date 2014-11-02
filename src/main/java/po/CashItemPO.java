package po;

/**
 * 现金费用单中的条目清单
 * @author Zing
 * @version 2014年10月31日下午5:58:44
 */
public class CashItemPO {
	/** 条目名 */
	private String name;
	/** 金额 */
	private int money;
	/** 备注 */
	private String remark;
	
	public CashItemPO(String name, int money, String remark){
		this.setName(name);
		this.setMoney(money);
		this.setRemark(remark);
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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


}
