package businesslogic.cashbillbl;

/**
 * 条目清单中包括：条目名，金额，备注。
 * @author Zing
 * @version Nov 27, 201411:09:11 PM
 */
public class CashBillItem {
	private String name;
	
	private double money;
	
	private String remark;
	
	public CashBillItem() {
	}
	
	public CashBillItem(String name, double money, String remark) {
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
