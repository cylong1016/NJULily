package businesslogic.userbl;

import io.DefineList;
import po.UserPO;
import businesslogic.accountbillbl.info.UserInfo_AccountBill;
import businesslogic.clientbl.UserInfo_Client;
import dataenum.UserIdentity;

/**
 * 给外部提供user信息
 * @author cylong
 * @version 2014年12月1日 下午2:39:13
 */
public class UserInfo implements UserInfo_Client, UserInfo_AccountBill {

	private UserPO current;	// 当前登录的用户

	public UserInfo() {
		// 读取当前登录的用户
		DefineList<UserPO> currentUserTemp = new DefineList<UserPO>("data/loginInfoTemp.ser");
		current = currentUserTemp.get(0);
	}

	/**
	 * @see businesslogic.accountbillbl.info.UserInfo_AccountBill#getUserName()
	 */
	@Override
	public String getUserName() {
		return current.getUsername();
	}

	/**
	 * @see businesslogic.clientbl.UserInfo_Client#getUserIden()
	 */
	@Override
	public UserIdentity getUserIden() {
		return current.getIden();
	}
}
