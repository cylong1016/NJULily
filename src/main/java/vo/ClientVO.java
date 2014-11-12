package vo;

import dataenum.ClientCategory;
import dataenum.ClientLevel;

/**
 * 客户值对象
 * @author cylong
 * @version Oct 26, 2014 2:25:31 PM
 */
public class ClientVO extends ValueObject {
	

	/** 客户类别：进货商、销售商 */
	public ClientCategory category;
	/** 客户级别：1-5（vip） */
	public ClientLevel level;
	/** 客户姓名 */
	public String name;
	/** 客户电话 */
	public String phone;
	/** 客户地址 */
	public String address;
	/** 客户邮编 */
	public String post;
	/** 客户电子邮箱 */
	public String email;
	/** 客户应收 */
	public double receivable;
	/** 客户应付 */
	public double payable;
	/** 客户应收额度 */
	public double receivableLimit;
	/** 默认业务员 */
	public String salesman;

	public ClientVO(ClientCategory category, ClientLevel level, String name, String phone, String address, 
			String post, String email, double receivable, double payable, double receivableLimit, String salesman) {
		this.category = category;
		this.level = level;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.post = post;
		this.email = email;
		this.receivable = receivable;
		this.payable = payable;
		this.receivableLimit = receivableLimit;
		this.salesman = salesman;
	}

}
