package businesslogic.userbl;

import vo.UserVO;
import blservice.userblservice.UserBLService;
import dataenum.UserIdentity;


/**
 * 用户逻辑驱动
 * @author cylong
 * @version Oct 26, 2014  8:57:16 PM
 */
public class UserBLService_Driver {
	public void drive (UserBLService userBLService) {
		UserVO vo = new UserVO("njulily", "njulily", null, UserIdentity.GENERAL_MANAGER);
		userBLService.login("njulily", "njulily", true);
		userBLService.addUser("njulily", "njulily", UserIdentity.GENERAL_MANAGER);
		userBLService.deleteUser("njulily");
		userBLService.updateUser("njulily", null, UserIdentity.FINANCE_MANAGER, vo);
	}
}
