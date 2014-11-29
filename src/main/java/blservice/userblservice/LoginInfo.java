package blservice.userblservice;

/**
 * 用户登录的信息
 * @author cylong
 * @version 2014年11月29日 下午6:37:47
 */
public class LoginInfo {

	/** 登陆ID */
	public String ID;
	/** 密码 */
	public String password;
	/** 是否记住密码 */
	public boolean isRemembered;

	public LoginInfo(String iD, String password, boolean isRemembered) {
		super();
		this.ID = iD;
		this.password = password;
		this.isRemembered = isRemembered;
	}

}
