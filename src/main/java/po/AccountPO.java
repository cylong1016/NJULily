package po;


/**
 * 账户持久化对象
 * @author cylong
 * @version Oct 26, 2014  2:14:41 PM
 */
/**
 * 账号的属性有：名称和金额。余额不可修改，此数据项取决于收款单和付款单。
 * @author Zing
 * @version 2014年10月31日下午9:28:20
 */
public class AccountPO {
	/** 账户名*/
	private String name;
	/** 账户余额 */
	private int money;
	
	public AccountPO(String name, int money){
		this.name = name;
		this.money = money;
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
	
	
}
