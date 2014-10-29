package businesslogicservice;

import message.ResultMessage;
import dataenum.UserIdentity;

/**
 * 负责实现用户管理界面所需要的服务
 * @author cylong
 * @version Oct 26, 2014 3:19:03 PM
 */
 /**
  * 
  * @author Zing
  * @version 2014年10月28日下午7:44:23
  */
public interface UserBLService {

	/**
	 * 验证用户登陆
	 * @param userVO
	 * @return 处理结果
	 */
	public ResultMessage login(String username, String password);
	/**
	 * 添加用户
	 * @param userVO
	 * @return 处理结果
	 */
	public ResultMessage addUser(String username,  String password, UserIdentity position);

	/**
	 * 根据用户名删除用户
	 * @param username
	 * @return 处理结果
	 */
	public ResultMessage deleteUser(String username);

	/**
	 * 更新用户信息
	 * @param userVO
	 * @return 处理结果
	 */
	public ResultMessage updateUser(String username, UserIdentity newPosition);
}
