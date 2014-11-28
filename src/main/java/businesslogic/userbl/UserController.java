package businesslogic.userbl;


import java.util.ArrayList;

import po.UserPO;
import vo.UserVO;
import message.ResultMessage;
import dataenum.UserIdentity;
import dataservice.UserDataService;

/**
 * 用户逻辑层
 * @author Zing
 * @version 2014年11月3日下午7:59:35
 */
public class UserController implements blservice.userblservice.UserBLService{

	private User user;
	
	public UserController() {
		this.user = new User();
	}
	
	public ArrayList<UserVO> show() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage login(String username, String password,
			boolean isRemembered) {
		// TODO Auto-generated method stub
		return null;
	}

	public String returnUserName(boolean isRemembered) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addUser(String username, String password,
			UserIdentity position) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage deleteUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage updateUser(String username, String password,
			UserIdentity newPosition, UserVO user) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
