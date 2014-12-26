package businesslogic.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import log.LogController;
import message.ResultMessage;
import vo.UserVO;
import blservice.userblservice.UserBLService;
import dataenum.UserIdentity;
import dataservice.userdataservice.LoginInfo;

/**
 * 主要用于捕获User类抛出的异常
 * @author cylong
 * @version 2014年12月14日 上午5:13:54
 */
public class UserController implements UserBLService {

	private User user;

	public UserController() {
		user = new User();
	}

	/**
	 * @see blservice.userblservice.UserBLService#show()
	 */
	@Override
	public ArrayList<UserVO> show() {
		try {
			return user.show();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.userblservice.UserBLService#getID()
	 */
	@Override
	public String getID() {
		try {
			return user.getID();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.userblservice.UserBLService#login(dataservice.userdataservice.LoginInfo)
	 */
	@Override
	public UserIdentity login(LoginInfo loginInfo) {
		try {
			UserIdentity iden = user.login(loginInfo);
			String message = "登录成功！";
			LogController.addLog(message);
			return iden;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.userblservice.UserBLService#returnUsername()
	 */
	@Override
	public String returnUsername() {
		return user.returnUsername();
	}

	/**
	 * @see blservice.userblservice.UserBLService#add(vo.UserVO)
	 */
	@Override
	public ResultMessage add(UserVO vo) {
		try {
			ResultMessage res = user.add(vo);
			if (res.equals(ResultMessage.SUCCESS)) {
				String message = "添加一位客户 " + vo.toString();
				LogController.addLog(message);
			}
			return res;
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.REMOTE_EXCEPTION;
		}
	}

	/**
	 * @see blservice.userblservice.UserBLService#delete(java.lang.String)
	 */
	@Override
	public ResultMessage delete(String ID) {
		try {
			ResultMessage res = user.delete(ID);
			if(res.equals(ResultMessage.SUCCESS)) {
				String message = "删除一位客户 [客户ID=" + ID + "]";
				LogController.addLog(message);
			}
			return res;
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.REMOTE_EXCEPTION;
		}
	}

	/**
	 * @see blservice.userblservice.UserBLService#update(vo.UserVO)
	 */
	@Override
	public ResultMessage update(UserVO vo) {
		try {
			ResultMessage res = user.update(vo);
			String message = "更新一位客户 " + vo.toString();
			LogController.addLog(message);
			return res;
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.REMOTE_EXCEPTION;
		}
	}

	/**
	 * @see blservice.userblservice.UserBLService#updateAdmin(java.lang.String, java.lang.String)
	 */
	@Override
	public ResultMessage updateAdmin(String oldPass, String newPass) {
		try {
			return user.updateAdmin(oldPass, newPass);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.REMOTE_EXCEPTION;
		}
	}

}
