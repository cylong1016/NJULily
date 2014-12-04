package dataenum;

/**
 * 账单的状态，有草稿状态、提交状态、审批后状态
 * @author cylong
 * @version Oct 26, 2014 9:55:00 PM
 */
public enum BillCondition {
	DRAFT("草稿状态"),
	SUBMITTED("提交状态"),
	APPROVED("审批后状态");

	public final String value;

	BillCondition(String value) {
		this.value = value;
	}
	
}
