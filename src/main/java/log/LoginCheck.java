package log;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
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
	public LoginCheck() {
		try {
			userData = (UserDataService)Naming.lookup(RMIConfig.PREFIX + UserDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	public boolean login(LoginInfo loginInfo) {
		try {
			UserIdentity iden = userData.login(loginInfo);
			if (iden == null) {
				return false;
			}
			// 总经理或者财务人员
			if (iden.equals(UserIdentity.GENERAL_MANAGER) || iden.equals(UserIdentity.FINANCE_MANAGER)) {
				return true;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

}
