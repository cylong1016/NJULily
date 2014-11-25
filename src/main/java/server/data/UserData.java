package server.data;

import java.util.ArrayList;

import message.ResultMessage;
import po.UserPO;
import dataservice.UserDataService;

/**
 * @see dataservice.UserDataService
 * @author cylong
 * @version Nov 4, 2014 9:06:25 PM
 */
public class UserData implements UserDataService {

	/**
	 * @see dataservice.DataService#init()
	 */
	public void init() {
	}

	/**
	 * @see dataservice.DataService#getID()
	 */
	public String getID() {
		return null;
	}

	/**
	 * @see dataservice.UserDataService#insert(po.UserPO)
	 */
	public ResultMessage insert(UserPO po) {
		return null;
	}

	/**
	 * @see dataservice.UserDataService#find(java.lang.String)
	 */
	public UserPO find(String username) {
		return null;
	}

	/**
	 * @see dataservice.UserDataService#delete(java.lang.String)
	 */
	public ResultMessage delete(String ID) {
		return null;
	}

	/**
	 * @see dataservice.UserDataService#update(po.UserPO)
	 */
	public ResultMessage update(UserPO po) {
		return null;
	}

	/**
	 * @see dataservice.UserDataService#show()
	 */
	public ArrayList<UserPO> show() {
		return null;
	}

}
