package businesslogic.clientbl;

import dataenum.UserIdentity;

/**
 * @author cylong
 * @version 2014年11月29日 下午5:11:08
 */
public interface UserInfo_Client {

	/**
	 * 得到当前登录的用户的身份，修改客户信息的时候需要权限
	 * @return 客户身份
	 * @author cylong
	 * @version 2014年11月29日 下午5:13:37
	 */
	public UserIdentity getUserIden();
}
