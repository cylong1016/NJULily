package server.data.userdata;

import message.ResultMessage;
import po.UserPO;
import server.common.ParseXML;
import server.data.CommonData;
import dataservice.userdataservice.AdminInfo;
import dataservice.userdataservice.UserDataService;

/**
 * @see dataservice.userdataservice.UserDataService
 * @author cylong
 * @version Nov 4, 2014 9:06:25 PM
 */
public class UserData extends CommonData<UserPO> implements UserDataService {

	/**
	 * @see dataservice.DataService#init()
	 */
	@Override
	public void init() {
		parsexml = new ParseXML("UserData");
		prefix = parsexml.getValue("prefix");
	}

	/**
	 * @see server.data.CommonData#getID()
	 */
	@Override
	public String getID() {
		return prefix + super.getID();
	}

	/**
	 * 用户名存在则添加失败
	 * @see server.data.CommonData#insert(po.PersistentObject)
	 */
	@Override
	public ResultMessage insert(UserPO po) {
		for(UserPO temp : poList.getInList()) {
			if (temp.getUsername().equals(po.getUsername())) {
				return ResultMessage.FAILURE;
			}
		}
		super.insert(po);
		return ResultMessage.SUCCESS;
	}

	/**
	 * @see dataservice.userdataservice.UserDataService#checkAdmin(dataservice.userdataservice.AdminInfo)
	 */
	@Override
	public boolean checkAdmin(AdminInfo admin) {
		AdminInfo adminInfo = loadAdminInfo();	// 从文件中读取的AdminInfo
		if (adminInfo.equals(admin)) {
			return true;
		}
		return false;
	}

	/**
	 * 从文件中读取Admin信息
	 * @return
	 * @author cylong
	 * @version 2014年12月3日 上午10:29:21
	 */
	private AdminInfo loadAdminInfo() {
		ParseXML parse = new ParseXML("config/Admin.xml", "Admin");
		String username = parse.getValue("username");
		String password = parse.getValue("password");
		return new AdminInfo(username, password);
	}

	/**
	 * @see dataservice.userdataservice.UserDataService#updateAdmin(java.lang.String, java.lang.String)
	 */
	@Override
	public ResultMessage updateAdmin(String oldPass, String newPass) {
		ParseXML parse = new ParseXML("config/Admin.xml", "Admin");
		String password = parse.getValue("password");	// 从文件中读取的password
		if (oldPass.equals(password)) {
			parse.setValue("password", newPass);
			return ResultMessage.SUCCESS;
		}
		return ResultMessage.FAILURE;
	}

}
