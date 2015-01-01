package dataservice.userdataservice;

import java.io.Serializable;

import dataenum.UserIdentity;

/**
 * @author cylong
 * @version 2014年12月3日 上午10:09:34
 */
public class AdminInfo implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 519072109825061284L;
	/** 用户名 */
	public String username;
	/** 密码 */
	public String password;
	/** 身份（管理员） */
	public UserIdentity iden;

	public AdminInfo(String username, String password) {
		this.username = username;
		this.password = password;
		this.iden = UserIdentity.ADMIN;
	}

	/**
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
		AdminInfo other = (AdminInfo)obj;
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

}
