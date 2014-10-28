package businesslogicservice;

import message.ResultMessage;

/**
 * 负责实现客户管理界面所需要的服务
 * @author cylong
 * @version Oct 26, 2014 3:09:50 PM
 */
/**
 * 
 * @author Zing
 * @version 2014年10月28日下午5:26:29
 */
public interface ClientBLService {
	public ResultMessage findClient(String keywords, long id);
	
	public ResultMessage addClient(String kind, String name, String level, 
			String phoneNum, String address, String post);
	
	public ResultMessage updClient(String kind, String name, String level, 
			String phoneNum, String address, String post);
	
	public ResultMessage deletClient(String name);
	
	
}
