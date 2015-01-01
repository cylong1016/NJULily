package dataenum;

public enum FindTypeClient {
	// 如果是模糊查找，就传一个null过来
	ID("客户ID"),
	KIND("客户类别"),
	LEVEL("客户级别"),
	NAME("客户名称"),
	PHONE("客户电话"),
	ADDRESS("客户地址"),
	POST("客户邮编"),
	EMAIL("客户Email"),
	RECEIVABLELIMIT("应收额度"),
	RECEIVABLE("应收"),
	PAYABLE("应付"),
	SALESMAN("默认业务员");	
	
	public final String value;

	FindTypeClient(String value) {
		this.value = value;
	}

}
