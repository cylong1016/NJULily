package businesslogic.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import message.ResultMessage;
import vo.UserVO;
import blservice.userblservice.LoginInfo;
import blservice.userblservice.UserBLService;
import dataenum.UserIdentity;

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
	 * @see blservice.userblservice.UserBLService#login(blservice.userblservice.LoginInfo)
	 */
	@Override
	public UserIdentity login(LoginInfo loginInfo) {
		try {
			return user.login(loginInfo);
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
			return user.add(vo);
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
			return user.delete(ID);
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
			return user.update(vo);
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
