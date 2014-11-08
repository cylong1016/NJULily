package businesslogic.userbl;


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
public class UserBL implements businesslogicservice.UserBLService{
	private UserDataService userData;
	
	public UserBL(UserDataService userData) {
		this.userData = userData;
	}
	
	public ResultMessage login(String username, String password, boolean isRemembered) {
		if (!isRemembered) {
			//TODO 删除本地文件
		}
		else {
			returnUserName(isRemembered);
		}
		if (userData.find(username).getPassword().equals(password)) {
			return ResultMessage.SUCCESS;
		}
		else {
			return ResultMessage.FAILURE;
		}
	}
	
	public String returnUserName(boolean isRemembered){
		// TODO 从本地文件返回用户名
		if (isRemembered) {
			
		}
		return  null;
	}

	/**
	 * 添加用户
	 */
	public ResultMessage addUser(String username, String password,
			UserIdentity position) {
		// 获得随机ID
		String ID = userData.getID();
		// TODO 需要一个得到查看该ID是否存在的方法
		// 如果该ID未被创立过，则可以使用该ID，创建PO对象
		UserPO po = new UserPO(ID, username, password, position);
		userData.insert(po);
		return ResultMessage.SUCCESS;
	}

	public ResultMessage deleteUser(String username) {
		return userData.delete(username);
	}

	/**
	 * 更新用户信息
	 * 如果该用户没有权限更改的，ui上禁止更改
	 */
	public ResultMessage updateUser(String username, String password, UserIdentity newPosition, UserVO user){
		UserPO po = new UserPO(user.ID, username, password, newPosition);	
		return userData.update(po);
	}
	
}
