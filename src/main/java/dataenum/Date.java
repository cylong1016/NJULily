package dataenum;
/**
 * 日期设置
 * @author soujing
 * @version 2014年10月27日下午4:49:53
 */
public enum Date {
	DATE_BEGIN("起始时间"),
	DATE_END("终止时间");
	
	public final String value;

	Date(String value) {
		this.value = value;
	}

}
