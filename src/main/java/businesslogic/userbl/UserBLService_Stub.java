package businesslogic.userbl;

import java.util.ArrayList;

import dataenum.UserIdentity;
import message.ResultMessage;
import vo.UserVO;
import blservice.userblservice.UserBLService;

/**
 * @author cylong
 * @version Oct 26, 2014 4:58:58 PM
 */
public class UserBLService_Stub implements UserBLService {

	/**
	 * @see blservice.userblservice.UserBLService#login(vo.UserVO)
	 */
	public ResultMessage login(String username, String password, boolean isRemembered) {
		System.out.println("用户登陆成功");
		return ResultMessage.SUCCESS;
	}

	/**
	 * @see blservice.userblservice.UserBLService#addUser(vo.UserVO)
	 */
	public ResultMessage addUser(String username,  String password, UserIdentity position) {
		System.out.println("添加用户成功");
		return ResultMessage.SUCCESS;
	}

	/**
	 * @see blservice.userblservice.UserBLService#deleteUser(java.lang.String)
	 */
	public ResultMessage deleteUser(String username) {
		System.out.println("删除用户成功");
		return ResultMessage.SUCCESS;
	}

	/**
	 * @see blservice.userblservice.UserBLService#updateUser(vo.UserVO)
	 */
	public ResultMessage updateUser(String username, UserIdentity newPosition) {
		System.out.println("更新用户成功");
		return ResultMessage.SUCCESS;
	}

	public ResultMessage updateUser(String username, String password,
			UserIdentity newPosition, UserVO user) {
		// TODO Auto-generated method stub
		return null;
	}

	public String returnUserName(boolean isRemembered) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<UserVO> show() {
		// TODO Auto-generated method stub
		return null;
	}

}
