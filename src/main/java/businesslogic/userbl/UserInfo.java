package businesslogic.userbl;

import io.DefineList;
import po.UserPO;
import dataenum.UserIdentity;

/**
 * 给外部提供user信息
 * @author cylong
 * @version 2014年12月1日 下午2:39:13
 */
/**
 * 把类中的方法变成静态方法，因为每一个逻辑层都要调用
 * @author cylong
 * @version 2014年12月26日 下午8:01:50
 */
public class UserInfo {

	private UserPO current;	// 当前登录的用户

	private static UserInfo userInfo;

	private UserInfo() {
		// 读取当前登录的用户
		DefineList<UserPO> currentUserTemp = new DefineList<UserPO>(User.tempFileName);
		current = currentUserTemp.get(0);
	}

	public static UserInfo getInstance() {
		if (userInfo == null) {
			userInfo = new UserInfo();
		}
		return userInfo;
	}

	/**
	 * @return 当前登录的用户名
	 * @author cylong
	 * @version 2014年12月26日 下午8:03:10
	 */
	public String getUsername() {
		return current.getUsername();
	}

	/**
	 * @return 当前登录的用户身份
	 * @author cylong
	 * @version 2014年12月26日 下午8:03:19
	 */
	public UserIdentity getUserIden() {
		return current.getIden();
	}

}
