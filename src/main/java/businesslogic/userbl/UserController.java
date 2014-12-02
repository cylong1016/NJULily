package businesslogic.userbl;

import java.util.ArrayList;

import dataenum.UserIdentity;
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
	public UserIdentity login(LoginInfo loaginInfo) {
		return user.login(loaginInfo);
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
		return user.add(vo);
	}

	/**
	 * @see blservice.userblservice.UserBLService#delete(java.lang.String)
	 */
	@Override
	public ResultMessage delete(String ID) {
		return user.delete(ID);
	}

	/**
	 * @see blservice.userblservice.UserBLService#update(vo.UserVO)
	 */
	@Override
	public ResultMessage update(UserVO vo) {
		return user.update(vo);
	}

}
