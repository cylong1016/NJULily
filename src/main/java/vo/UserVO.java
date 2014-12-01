package vo;

import dataenum.UserIdentity;

/**
 * 用户值对象
 * @author cylong
 * @version Oct 26, 2014 1:59:25 PM
 */
/**
 * 添加name和phone属性
 * @author cylong
 * @version 2014年12月1日 下午11:07:07
 */
public class UserVO extends ValueObject {

	/** 用户名 */
	public String username;
	/** 真实姓名 */
	public String name;
	/** 用户密码 */
	public String password;
	/** 用户电话 */
	public String phone;
	/** 用户身份 */
	public UserIdentity iden;

	public UserVO(String ID, String username, String name, String password, String phone, UserIdentity iden) {
		super();
		this.ID = ID;
		this.username = username;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.iden = iden;
	}

}
