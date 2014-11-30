package businesslogic.userbl;

import java.util.ArrayList;

import message.ResultMessage;
import po.UserPO;
import server.data.UserData;
import server.io.DefineList;
import vo.UserVO;
import blservice.userblservice.LoginInfo;
import businesslogic.clientbl.UserInfo_Client;
import dataenum.UserIdentity;
import dataservice.UserDataService;

public class User implements UserInfo_Client {

	private UserDataService userData;
	private DefineList<UserPO> currentUser;
	private UserPO current;	// 当前登录的用户

	public User() {
		currentUser = new DefineList<UserPO>("data/loginInfo.ser");
//		try {
//			DataFactoryService factory = (DataFactoryService)Naming.lookup(RMI.URL);
//			this.userData = factory.getUserData();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		this.userData = new UserData();
	}

	/**
	 * 供界面层显示
	 * @return 新的ID
	 * @author cylong
	 * @version 2014年11月29日 下午6:54:10
	 */
	public String getID() {
		return userData.getID();
	}

	/**
	 * 验证用户登录
	 * @param loginInfo
	 * @return 登录结果
	 * @author cylong
	 * @version 2014年11月29日 下午9:24:17
	 */
	public ResultMessage login(LoginInfo loginInfo) {
		current = userData.find(loginInfo.ID);
		if (current == null) {
			return ResultMessage.FAILURE;
		} else if (!loginInfo.password.equals(current.getPassword())) {
			return ResultMessage.FAILURE;
		}
		if (loginInfo.isRemembered) {	// 保存当前登录的用户
			currentUser.clear();
			currentUser.add(current);
		} else {	// 删除记住的账号
			currentUser.clear();
		}
		return ResultMessage.SUCCESS;
	}

	/**
	 * 返回用户保存的用户名
	 * @return 用户保存的用户名，不存在就返回null
	 * @author cylong
	 * @version 2014年11月29日 下午9:25:38
	 */
	public String returnUserID() {
		if (currentUser.size() > 0) {
			return currentUser.get(0).getID();
		}
		return null;
	}

	/**
	 * 添加用户
	 * @param vo UserVO
	 * @return 添加结果
	 * @author cylong
	 * @version 2014年11月29日 下午9:29:55
	 */
	public ResultMessage addUser(UserVO vo) {
		UserPO po = voToPO(vo);
		return userData.insert(po);
	}

	/**
	 * 以ID删除用户
	 * @param ID
	 * @return 删除结果
	 * @author cylong
	 * @version 2014年11月29日 下午9:30:23
	 */
	public ResultMessage deleteUser(String ID) {
		return userData.delete(ID);
	}

	/**
	 * 更新用户信息
	 * 如果该用户没有权限更改的，ui上禁止更改
	 */
	public ResultMessage updateUser(UserVO vo) {
		UserPO po = voToPO(vo);
		return userData.update(po);
	}

	/**
	 * 返回全部的用户
	 * @return 全部的用户的ArrayList
	 * @author cylong
	 * @version 2014年11月29日 下午9:42:27
	 */
	public ArrayList<UserVO> show() {
		ArrayList<UserVO> usersVO = new ArrayList<UserVO>();
		ArrayList<UserPO> usersPO = userData.show();
		for(int i = 0; i < usersPO.size(); i++) {
			UserPO po = usersPO.get(i);
			UserVO vo = poToVO(po);
			usersVO.add(vo);
		}
		return usersVO;
	}

	/**
	 * @see businesslogic.clientbl.UserInfo_Client#getUserIden()
	 */
	@Override
	public UserIdentity getUserIden() {
		return current.getIden();
	}

	/**
	 * UserVO转化成UserPO
	 * @param vo UserVO
	 * @return UserPO
	 * @author cylong
	 * @version 2014年11月29日 下午9:37:24
	 */
	private UserPO voToPO(UserVO vo) {
		String ID = vo.ID;
		String username = vo.name;
		String password = vo.password;
		UserIdentity iden = vo.iden;
		UserPO po = new UserPO(ID, username, password, iden);
		return po;
	}

	/**
	 * UserPO转化成UserVO
	 * @param po UserPO
	 * @return UserVO
	 * @author cylong
	 * @version 2014年11月29日 下午9:41:20
	 */
	private UserVO poToVO(UserPO po) {
		String ID = po.getID();
		String username = po.getUsername();
		String password = po.getPassword();
		UserIdentity iden = po.getIden();
		UserVO vo = new UserVO(ID, username, password, iden);
		return vo;
	}
}
