package businesslogic.userbl;

import java.util.ArrayList;

import message.ResultMessage;
import vo.UserVO;
import blservice.userblservice.LoginInfo;

/**
 * @see blservice.userblservice.UserBLService
 * @author Zing
 * @version 2014年11月3日下午7:59:35
 */
public class UserController implements blservice.userblservice.UserBLService {

	private User user;

	public UserController() {
		this.user = new User();
	}

	/**
	 * @see blservice.userblservice.UserBLService#show()
	 */
	@Override
	public ArrayList<UserVO> show() {
		return user.show();
	}

	/**
	 * @see blservice.userblservice.UserBLService#getID()
	 */
	@Override
	public String getID() {
		return user.getID();
	}

	/**
	 * @see blservice.userblservice.UserBLService#login(blservice.userblservice.LoginInfo)
	 */
	@Override
	public ResultMessage login(LoginInfo loaginInfo) {
		return user.login(loaginInfo);
	}

	/**
	 * @see blservice.userblservice.UserBLService#returnUserID()
	 */
	@Override
	public String returnUserID() {
		return user.returnUserID();
	}

	/**
	 * @see blservice.userblservice.UserBLService#addUser(vo.UserVO)
	 */
	@Override
	public ResultMessage addUser(UserVO vo) {
		return user.addUser(vo);
	}

	/**
	 * @see blservice.userblservice.UserBLService#deleteUser(java.lang.String)
	 */
	@Override
	public ResultMessage deleteUser(String ID) {
		return user.deleteUser(ID);
	}

	/**
	 * @see blservice.userblservice.UserBLService#updateUser(vo.UserVO)
	 */
	@Override
	public ResultMessage updateUser(UserVO vo) {
		return user.updateUser(vo);
	}

}
