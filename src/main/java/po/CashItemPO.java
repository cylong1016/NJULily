package po;

import java.io.Serializable;

/**
 * 现金费用单中的条目清单
 * @author Zing
 * @version 2014年10月31日下午5:58:44
 */
public class CashItemPO implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	/** 条目名 */
	private String name;
	/** 金额 */
	private double money;
	/** 备注 */
	private String remark;

	public CashItemPO(String name, double money, String remark) {
		this.name = name;
		this.money = money;
		this.remark = remark;
	}

	public String getName() {
		return name;
	}

	public double getMoney() {
		return money;
	}

	public String getRemark() {
		return remark;
	}

}
