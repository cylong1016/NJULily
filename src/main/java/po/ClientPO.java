package po;

import dataenum.ClientCategory;
import dataenum.ClientLevel;
import dataenum.UserIdentity;

/**
 * 客户持久化对象
 * @author cylong
 * @version Oct 25, 2014 10:21:07 PM
 */
public class ClientPO extends PersistentObject {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	/** 客户类别：进货商、销售商 */
	private ClientCategory category;
	/** 客户级别：1-5（vip） */
	private ClientLevel level;
	/** 客户姓名 */
	private String name;
	/** 客户电话 */
	private String phone;
	/** 客户地址 */
	private String address;
	/** 客户邮编 */
	private String post;
	/** 客户电子邮箱 */
	private String email;
	/** 客户应收 */
	private double receivable;
	/** 客户应付 */
	private double payable;
	/** 客户应收额度 */
	private double receivableLimit;
	/** 默认业务员 */
	private String salesman;

	/**
	 * @param ID 客户ID
	 * @param category 客户类别：进货商、销售商
	 * @param level 客户级别：1-5（vip）
	 * @param name 客户姓名
	 * @param phone 客户电话
	 * @param address 客户地址
	 * @param post 客户邮编
	 * @param email 客户电子邮箱
	 * @param receivableLimit 客户应收额度
	 * @param operator 默认业务员
	 * @author cylong
	 * @version Oct 26, 2014 12:55:54 PM
	 */
	public ClientPO(String ID, ClientCategory category, ClientLevel level, String name, String phone, String address, String post, String email, double receivableLimit, String salesman) {
		super(ID);
		this.category = category;
		this.level = level;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.post = post;
		this.email = email;
		this.receivableLimit = receivableLimit;
		this.salesman = salesman;
	}

	/**
	 * 名字相同的客户就是重复的客户
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientPO other = (ClientPO)obj;
		if (this.name == null) {
			if (other.name != null)
				return false;
		} else if (!this.name.equals(other.name))
			return false;
		return true;
	}

	/**
	 * 模糊查询时候使用
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ID + "|" + category.value + "|" + level.value + "|" + name + "|" + phone + "|" + address + "|" + post + "|" + email
				+ "|" + receivable + "|" + payable + "|" + receivableLimit + "|" + salesman;
	}

	public ClientCategory getCategory() {
		return this.category;
	}

	public void setCategory(ClientCategory category) {
		this.category = category;
	}

	public ClientLevel getLevel() {
		return this.level;
	}

	public void setLevel(ClientLevel level) {
		this.level = level;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPost() {
		return this.post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getReceivableLimit() {
		return this.receivableLimit;
	}

	/**
	 * 修改客户应收额度，仅最高权限可以修改
	 * @param receivableLimit 客户应收额度
	 * @param iden 修改者的身份
	 * @return boolean 是否修改成功
	 * @author cylong
	 * @version Oct 26, 2014 1:50:53 AM
	 */
	public boolean setReceivableLimit(double receivableLimit, UserIdentity iden) {
		// 仅总经理可以修改
		if (iden.equals(UserIdentity.GENERAL_MANAGER)) {
			this.receivableLimit = receivableLimit;
			return true;
		}
		return false;
	}

	public double getReceivable() {
		return this.receivable;
	}

	public void setReceivable(double receivable) {
		this.receivable = receivable;
	}

	public double getPayable() {
		return this.payable;
	}

	public void setPayable(double payable) {
		this.payable = payable;
	}

	public String getSalesman() {
		return this.salesman;
	}

	public void setSalesman(String salesman) {
		this.salesman = salesman;
	}

}
