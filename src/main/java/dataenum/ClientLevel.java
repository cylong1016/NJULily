package dataenum;


/**
 * 客户级别：五级，一级普通用户，五级VIP客户
 * @author cylong
 * @version Oct 26, 2014  12:29:55 AM
 */
public enum ClientLevel {
	LEVEL_1("一星级"),
	LEVEL_2("二星级"),
	LEVEL_3("三星级"),
	LEVEL_4("四星级"),
	VIP("会员");
	
	public final String value;

	ClientLevel(String value) {
		this.value = value;
	}

}
