package businesslogic.userbl;

import message.ResultMessage;
import vo.UserVO;
import businesslogicservice.UserBLService;

/**
 * @author cylong
 * @version Oct 26, 2014 4:58:58 PM
 */
public class UserBLService_Stub implements UserBLService {

	/**
	 * @see businesslogicservice.UserBLService#login(vo.UserVO)
	 */
	public ResultMessage login(UserVO userVO) {
		System.out.println("用户登陆成功");
		return ResultMessage.LOGIN_SUCCESS;
	}

	/**
	 * @see businesslogicservice.UserBLService#addUser(vo.UserVO)
	 */
	public ResultMessage addUser(UserVO userVO) {
		System.out.println("添加用户成功");
		return ResultMessage.SUCCESS;
	}

	/**
	 * @see businesslogicservice.UserBLService#deleteUser(java.lang.String)
	 */
	public ResultMessage deleteUser(String username) {
		System.out.println("删除用户成功");
		return ResultMessage.SUCCESS;
	}

	/**
	 * @see businesslogicservice.UserBLService#updateUser(vo.UserVO)
	 */
	public ResultMessage updateUser(UserVO userVO) {
		System.out.println("更新用户成功");
		return ResultMessage.SUCCESS;
	}

}
