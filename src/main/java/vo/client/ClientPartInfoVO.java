package vo.client;

import vo.ValueObject;
import dataenum.ClientCategory;
import dataenum.ClientLevel;

public class ClientPartInfoVO extends ValueObject{
	
	/** 客户类别：进货商、销售商 */
	public ClientCategory category;
	/** 客户级别：1-5（VIP） */
	public ClientLevel level;
	/** 客户姓名 */
	public String name;
	/** 默认业务员 */
	public String salesman;
	/** 客户应收 */
	public double receivable;
	/** 客户应付 */
	public double payable;
	/** 客户应收额度 */
	public double receivableLimit;
	
	/**
	 * 在销售、销售退货、进货、进货退货界面显示Client的时候，就只用显示这些信息
	 */
	public ClientPartInfoVO(String ID, ClientCategory category, ClientLevel level, String name, String salesman, double receivable, double payable, double receivableLimit) {
		this.ID = ID;
		this.category = category;
		this.level = level;
		this.name = name;
		this.salesman = salesman;
		this.receivable = receivable;
		this.payable = payable;
		this.receivableLimit = receivableLimit;
	}
	
}
