package dataservice.userdataservice;

import dataenum.UserIdentity;

/**
 * @author cylong
 * @version 2014年12月3日 上午10:09:34
 */
public class AdminInfo {

	public String username;
	public String password;
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
