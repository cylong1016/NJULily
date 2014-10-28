package businesslogicservice;

import message.ResultMessage;

/**
 * 负责实现进货界面所需要的服务
 * @author cylong
 * @version Oct 26, 2014 3:11:13 PM
 */
/**
 * 
 * @author Zing
 * @version 2014年10月28日下午5:28:55
 */
public interface PurchaseBLService {
	public ResultMessage addPur(Commodity commodity,  int num, int price,  String remark);
	
	public ResultMessage addPurBack(Commodity commodity,  int num, int price,  String remark);
	
	public ResultMessage submit();


}
