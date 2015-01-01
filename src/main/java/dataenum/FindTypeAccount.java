package dataenum;

/**
 * 查找账户时候的查找类型
 * @author Zing
 * @version Nov 13, 20148:39:56 PM
 */
public enum FindTypeAccount {
	ID("账户ID"),
	NAME("账户名称"),
	MONEY("账户金额");
	
	public final String value;

	FindTypeAccount(String value) {
		this.value = value;
	}

}
