package dataenum;

/**
 * 需要审批的单据的状态
 * @author cylong
 * @version 2014年11月28日 下午8:44:19
 */
public enum BillState {
	APPROVALING("正在审批"),
	SUCCESS("审批成功"),
	FAILURE("审批失败"),
	DRAFT("草稿状态");

	public final String value;

	BillState(String value) {
		this.value = value;
	}

}
