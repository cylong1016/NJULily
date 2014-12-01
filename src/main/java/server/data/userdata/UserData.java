package server.data.userdata;

import po.UserPO;
import server.common.ParseXML;
import server.data.CommonData;
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
}
