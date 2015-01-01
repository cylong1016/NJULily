package dataservice.userdataservice;

import java.rmi.RemoteException;

import po.UserPO;
import dataenum.ResultMessage;
import dataenum.UserIdentity;
import dataservice.CommonDataService;

/**
 * 提供用户集体载入、保存、增删改查服务
 * @author cylong
 * @version Oct 26, 2014 3:51:54 PM
 */
public interface UserDataService extends CommonDataService<UserPO> {

	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "UserData";

	/**
	 * 验证用户登录
	 * @param loaginInfo
	 * @return 返回登录用户的身份 null为登录失败
	 * @author cylong
	 * @version 2014年12月15日 下午6:51:57
	 * @throws RemoteException
	 */
	public UserIdentity login(LoginInfo loginInfo) throws RemoteException;

	/**
	 * 更改管理员密码
	 * @param oldPass 旧密码
	 * @param newPass 新密码
	 * @return
	 * @author cylong
	 * @version 2014年12月3日 上午10:23:06
	 */
	public ResultMessage updateAdmin(String oldPass, String newPass) throws RemoteException;

}
