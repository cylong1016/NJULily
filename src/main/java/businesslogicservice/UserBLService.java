package businesslogicservice;

import java.util.ArrayList;

import vo.UserVO;
import dataenum.UserIdentity;
import message.ResultMessage;


/**
 * 负责实现用户管理界面所需要的服务
 * @author cylong
 * @version Oct 26, 2014 3:19:03 PM
 */
 /**
  * 登陆的时候使用ID和密码，ID类似于QQ号
  * 属性：ID、用户名、密码、职位
  * 管理员可以修改：用户名、密码、职位
  * 用户可以修改：用户名、密码
  * @author Zing
  * @version 2014年10月28日下午7:44:23
  */
public interface UserBLService {
	
	public ArrayList<UserVO> show();

	/**
	 * 验证用户登陆
	 * @param userVO
	 * @return 处理结果
	 */
	public ResultMessage login(String username, String password, boolean isRemembered) ;
	
	/**
	 * 判断是不是保存用户
	 * @param isRemembered
	 * @return
	 */
	public String returnUserName(boolean isRemembered);
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
	 * @param username
	 * @param password
	 * @param newPosition
	 * @return
	 */
	public ResultMessage updateUser(String username, String password, UserIdentity newPosition, UserVO user);
	
}
