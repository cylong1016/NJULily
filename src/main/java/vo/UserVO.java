package vo;

import dataenum.UserIdentity;

/**
 * 用户值对象
 * @author cylong
 * @version Oct 26, 2014 1:59:25 PM
 */
public class UserVO {

	/** 用户姓名 */
	public String name;
	/** 用户密码 */
	public String password;
	/** 用户身份 */
	public UserIdentity iden;

	public UserVO(String name, String password, UserIdentity iden) {
		super();
		this.name = name;
		this.password = password;
		this.iden = iden;
	}

}
