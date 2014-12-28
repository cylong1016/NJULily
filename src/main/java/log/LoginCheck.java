package log;

import java.rmi.Naming;
import java.rmi.RemoteException;

import config.RMIConfig;
import dataenum.UserIdentity;
import dataservice.userdataservice.LoginInfo;
import dataservice.userdataservice.UserDataService;

/**
 * 验证用户登录
 * @author cylong
 * @version 2014年12月28日 上午12:30:37
 */
public class LoginCheck {

	private UserDataService userData;

	/**
	 * @author cylong
	 * @version 2014年12月28日 上午12:33:13
	 */
	public LoginCheck() throws Exception {
		userData = (UserDataService)Naming.lookup(RMIConfig.PREFIX + UserDataService.NAME);
	}

	public boolean login(LoginInfo loginInfo) throws RemoteException {
		UserIdentity iden = userData.login(loginInfo);
		if (iden == null) {
			return false;
		}
		// 总经理或者财务人员
		if (iden.equals(UserIdentity.GENERAL_MANAGER) || iden.equals(UserIdentity.FINANCE_MANAGER)) {
			return true;
		}
		return false;
	}

}
