package dataservice.userdataservice;

import message.ResultMessage;
import po.UserPO;
import dataservice.CommonDataService;

/**
 * 提供用户集体载入、保存、增删改查服务
 * @author cylong
 * @version Oct 26, 2014 3:51:54 PM
 */
public interface UserDataService extends CommonDataService<UserPO> {

	/**
	 * 验证管理员
	 * @param adminInfo
	 * @return 验证结果
	 * @author cylong
	 * @version 2014年12月3日 上午10:21:07
	 */
	public boolean checkAdmin(AdminInfo admin);

	/**
	 * 更改管理员密码
	 * @param oldPass 旧密码
	 * @param newPass 新密码
	 * @return
	 * @author cylong
	 * @version 2014年12月3日 上午10:23:06
	 */
	public ResultMessage updateAdmin(String oldPass, String newPass);
}
