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

	private static UserPO current;	// 当前登录的用户

	/**
	 * @return 当前登录的用户名
	 * @author cylong
	 * @version 2014年12月26日 下午8:03:10
	 */
	public static String getUsername() {
		// 读取当前登录的用户
		DefineList<UserPO> currentUserTemp = new DefineList<UserPO>("data/loginInfoTemp.ser");
		current = currentUserTemp.get(0);
		return current.getUsername();
	}

	/**
	 * @return 当前登录的用户身份
	 * @author cylong
	 * @version 2014年12月26日 下午8:03:19
	 */
	public static UserIdentity getUserIden() {
		// 读取当前登录的用户
		DefineList<UserPO> currentUserTemp = new DefineList<UserPO>("data/loginInfoTemp.ser");
		current = currentUserTemp.get(0);
		return current.getIden();
	}

}
