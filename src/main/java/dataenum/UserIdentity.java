package dataenum;

/**
 * 用户的身份：库存管理人员、进货销售人员、财务人员、总经理
 * @author cylong
 * @version Oct 26, 2014 1:25:15 AM
 */
public enum UserIdentity {
	GENERAL_MANAGER("总经理"),
	INVENTORY_MANAGER("库存管理人员"),
	FINANCE_MANAGER("财务人员"),
	PUR_SALE_MANAGER("进货销售人员"),
	SALE_MANAGER("销售经理"),
	ADMIN("管理员");
	
	public final String value;

	UserIdentity(String value) {
		this.value = value;
	}
}
