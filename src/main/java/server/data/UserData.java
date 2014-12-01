package server.data;

import po.UserPO;
import server.common.ParseXML;
import dataservice.UserDataService;

/**
 * @see dataservice.UserDataService
 * @author cylong
 * @version Nov 4, 2014 9:06:25 PM
 */
public class UserData extends CommonData<UserPO> implements UserDataService {

	/**
	 * @see dataservice.commondata.DataService#init()
	 */
	@Override
	public void init() {
		parsexml = new ParseXML("UserData");
	}
}
