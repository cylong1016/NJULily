package po;

/**
 * 账户持久化对象
 * @author cylong
 * @version Oct 26, 2014 2:14:41 PM
 */
/**
 * 账号的属性有：名称和金额。余额不可修改，此数据项取决于收款单和付款单。
 * @author Zing
 * @version 2014年10月31日下午9:28:20
 */
public class AccountPO extends PersistentObject {

	/** serialVersionUID */
	private static final long serialVersionUID = 4686479473110791245L;
	/** 账户名 */
	private String name;
	/** 账户余额 */
	private double money;

	public AccountPO(String ID, String name, double money) {
		super(ID);
		this.name = name;
		this.money = money;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public double getMoney() {
		return money;
	}

	/**
	 * 模糊查询时候使用
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.ID + "|" + this.name + "|" + this.money;
	}

	/**
	 * 名字相同的账户就是重复的账户
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountPO other = (AccountPO)obj;
		if (this.name == null) {
			if (other.name != null)
				return false;
		} else if (!this.name.equals(other.name))
			return false;
		return true;
	}

}
