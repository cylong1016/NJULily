package data;

import java.util.ArrayList;

import message.ResultMessage;
import po.UserPO;
import dataenum.UserIdentity;
import dataservice.UserDataService;


/**
 * 
 * @author cylong
 * @version Oct 26, 2014  8:17:16 PM
 */
public class UserDataService_Stub implements UserDataService {

	/**
	 * @see dataservice.DataService#init()
	 */
	public void init() {
		System.out.println("初始化成功");
	}

	/**
	 * @see dataservice.UserDataService#insert(po.UserPO)
	 */
	public ResultMessage insert(UserPO po) {
		System.out.println("插入成功");
		return null;
	}

	/**
	 * @see dataservice.UserDataService#find(java.lang.String)
	 */
	public UserPO find(String username) {
		System.out.println("查看成功");
		UserPO user = new UserPO("001", "njulily", "njulily", UserIdentity.GENERAL_MANAGER);
		return user;
	}

	/**
	 * @see dataservice.UserDataService#delete(java.lang.String)
	 */
	public ResultMessage delete(String username) {
		System.out.println("删除成功");
		return null;
	}

	/**
	 * @see dataservice.UserDataService#update(po.UserPO)
	 */
	public ResultMessage update(UserPO po) {
		System.out.println("更新成功");
		return null;
	}

	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see dataservice.UserDataService#show()
	 */
	public ArrayList<UserPO> show() {
		return null;
	}

}
