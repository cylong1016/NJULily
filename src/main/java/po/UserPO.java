package po;

import dataenum.UserIdentity;

/**
 * 用户持久化对象
 * @author cylong
 * @version Oct 26, 2014 1:22:02 AM
 */
public class UserPO extends PersistentObject {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	/** 用户名 */
	private String username;
	/** 密码 */
	private String password;
	/** 用户身份 */
	private UserIdentity iden;

	public UserPO(String id, String username, String password, UserIdentity iden) {
		super(id);
		this.username = username;
		this.password = password;
		this.iden = iden;
	}

	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}


	public UserIdentity getIden() {
		return this.iden;
	}

	public void setIden(UserIdentity iden) {
		this.iden = iden;
	}

}
