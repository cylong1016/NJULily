package po;

import po.po_enum.UserIdentity;

/**
 * @author cylong
 * @version Oct 26, 2014 1:22:02 AM
 */
public class UserPO extends PersistentObject {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	/** 用户名 */
	private String name;
	/** 密码 */
	private String password;
	/** 用户身份 */
	private UserIdentity iden;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserIdentity getIden() {
		return this.iden;
	}

	public void setIden(UserIdentity iden) {
		this.iden = iden;
	}

	@Override
	protected String createId() {
		// TODO 生成用户的编号
		return null;
	}

}
