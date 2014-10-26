package po;

import po.po_enum.ClientCategory;
import po.po_enum.ClientLevel;
import po.po_enum.UserIdentity;

/**
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
	 * @param receivableLimit 客户应收额度
	 * @param iden 修改者的身份
	 * @return boolean 是否修改成功
	 * @author cylong
	 * @version Oct 26, 2014  1:50:53 AM
	 */
	public boolean setReceivableLimit(double receivableLimit, UserIdentity iden) {
		// 仅最高权限可以修改
		if(iden.equals(UserIdentity.GENERAL_MANAGER)) {
			this.receivableLimit = receivableLimit;
			return true;
		}
		return false;
	}

	public double getReceivable() {
		return this.receivable;
	}

	public double getPayable() {
		return this.payable;
	}

	@Override
	protected String createId() {
		return null;
		// TODO 生成客户的编号
	}

}
