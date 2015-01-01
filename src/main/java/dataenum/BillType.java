package dataenum;

public enum BillType {
	EXPENSE("收款单", "SKD"),
	PAY("付款单", "FKD"),
	CASH("现金费用单", "XJFYD"),
	SALE("销售单", "XSD"),
	SALEBACK("销售退货单", "XSTHD"),
	PURCHASE("进货单", "JHD"),
	PURCHASEBACK("进货退货单", "JHTHD"),
	OVERFLOW("报溢单", "BYD"),
	LOSS("报损单", "BSD"),
	ALARM("报警单", "BJD"),
	GIFT("赠送单", "ZSD");

	public final String value;
	public final String prefix;

	BillType(String value, String prefix) {
		this.value = value;
		this.prefix = prefix;
	}

}
