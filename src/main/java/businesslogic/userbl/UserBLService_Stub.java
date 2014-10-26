package businesslogic.userbl;

import dataservice.UserDataService;
import message.ResultMessage;
import vo.UserVO;
import businesslogicservice.UserBLService;

/**
 * @author cylong
 * @version Oct 26, 2014 4:58:58 PM
 */
public class UserBLService_Stub implements UserBLService {
	
	private UserDataService userDataService;
	/**
	 * @see businesslogicservice.UserBLService#login(vo.UserVO)
	 */
	public ResultMessage login(UserVO userVO) {
		return ResultMessage.LOGIN_SUCCESS;
	}

	/**
	 * @see businesslogicservice.UserBLService#addUser(vo.UserVO)
	 */
	public ResultMessage addUser(UserVO userVO) {
		return null;
	}

	/**
	 * @see businesslogicservice.UserBLService#deleteUser(java.lang.String)
	 */
	public ResultMessage deleteUser(String username) {
		return null;
	}

	/**
	 * @see businesslogicservice.UserBLService#updateUser(vo.UserVO)
	 */
	public ResultMessage updateUser(UserVO userVO) {
		return null;
	}

}
