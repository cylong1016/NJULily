package dataenum;


/**
 * 客户的类别，分为：进货商、销售商
 * @author cylong
 * @version Oct 26, 2014  12:01:18 AM
 */
public enum ClientCategory {
	PURCHASE_PERSON("进货商"),
	SALES_PERSON("销售商"),
	BOTH("进货商&销售商");
	
	public final String value;

	ClientCategory(String value) {
		this.value = value;
	}

}
