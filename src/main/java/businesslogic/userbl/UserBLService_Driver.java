package businesslogic.userbl;

import vo.UserVO;
import businesslogicservice.UserBLService;
import dataenum.UserIdentity;


/**
 * 用户逻辑驱动
 * @author cylong
 * @version Oct 26, 2014  8:57:16 PM
 */
public class UserBLService_Driver {
	public void drive (UserBLService userBLService) {
		userBLService.login(new UserVO("njulily", "njulily", UserIdentity.GENERAL_MANAGER));
	}
}
