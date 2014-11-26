package server.data;

import java.util.ArrayList;

import message.ResultMessage;
import po.UserPO;
import server.common.ParseXML;
import server.io.DefineList;
import dataservice.UserDataService;

/**
 * @see dataservice.UserDataService
 * @author cylong
 * @version Nov 4, 2014 9:06:25 PM
 */
public class UserData implements UserDataService {

	private DefineList<UserPO> userList;
	private String filePath;
	private String initID;

	public UserData() {
		init();
		userList = new DefineList<>(filePath);
	}

	/**
	 * @see dataservice.DataService#init()
	 */
	public void init() {
		ParseXML parsexml = new ParseXML("UserData");
		filePath = parsexml.getPath();
		initID = parsexml.getInitID();
	}

	/**
	 * @see dataservice.DataService#getID()
	 */
	public String getID() {
		if (userList.isEmpty()) {
			return initID;
		}
		String currentID = userList.get(userList.size() - 1).getID();
		long id = Long.parseLong(currentID);
		currentID = String.valueOf(id + 1);
		return currentID;
	}

	/**
	 * @see dataservice.UserDataService#insert(po.UserPO)
	 */
	public ResultMessage insert(UserPO po) {
		if(userList.contains(po)) {
			return ResultMessage.FAILURE;
		}
		userList.add(po);
		return ResultMessage.SUCCESS;
	}

	/**
	 * @see dataservice.UserDataService#find(java.lang.String)
	 */
	public UserPO find(String ID) {
		for(int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getID().equals(ID)) {
				return userList.get(i);
			}
		}
		return null;
	}

	/**
	 * @see dataservice.UserDataService#delete(java.lang.String)
	 */
	public ResultMessage delete(String ID) {
		for(int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getID().equals(ID)) {
				userList.remove(i);
				return ResultMessage.SUCCESS;
			}
		}
		return ResultMessage.FAILURE;
	}

	/**
	 * @see dataservice.UserDataService#update(po.UserPO)
	 */
	public ResultMessage update(UserPO po) {
		int index = userList.indexOf(po);
		if(index == -1) {
			return ResultMessage.FAILURE;
		}
		userList.set(index, po);
		return ResultMessage.SUCCESS;
	}

	/**
	 * @see dataservice.UserDataService#show()
	 */
	public ArrayList<UserPO> show() {
		return userList.getInList();
	}

}
