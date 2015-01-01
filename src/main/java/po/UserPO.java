package po;

import dataenum.UserIdentity;

/**
 * 用户持久化对象
 * @author cylong
 * @version Oct 26, 2014 1:22:02 AM
 */
/**
 * @author Zing
 * @version 2014年11月2日下午5:53:29
 */
/**
 * 添加name和phone属性
 * @author cylong
 * @version 2014年12月1日 下午11:04:40
 */
public class UserPO extends PersistentObject {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	/** 用户名 */
	private String username;
	/** 真是姓名 */
	private String name;
	/** 密码 */
	private String password;
	/** 用户电话 */
	private String phone;
	/** 用户身份 */
	private UserIdentity iden;

	public UserPO(String ID, String username, String name, String password, String phone, UserIdentity iden) {
		super(ID);
		this.username = username;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.iden = iden;
	}

	/**
	 * 验证用户登录时候使用
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserPO other = (UserPO)obj;
		if (this.password == null) {
			if (other.password != null)
				return false;
		} else if (!this.password.equals(other.password))
			return false;
		if (this.username == null) {
			if (other.username != null)
				return false;
		} else if (!this.username.equals(other.username))
			return false;
		return true;
	}

	public String getUsername() {
		return this.username;
	}

	public String getPhone() {
		return this.phone;
	}

	public String getName() {
		return this.name;
	}

	public String getPassword() {
		return this.password;
	}

	public UserIdentity getIden() {
		return this.iden;
	}

}
