package dataenum;


/**
 * 操作的结果信息，比如商品不存在，登陆密码错误
 * @author cylong
 * @version Oct 26, 2014  4:29:45 PM
 */
public enum ResultMessage {
	SUCCESS("成功"),
	FAILURE("失败"),
	REMOTE_EXCEPTION("远程调用异常"),
	COMMODITY_LACK(""); // TODO
	
	public final String value;

	ResultMessage(String value) {
		this.value = value;
	}
}
