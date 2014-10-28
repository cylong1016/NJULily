package businesslogicservice;

import message.ResultMessage;

/**
 * 负责实现销售界面所需要的服务
 * @author cylong
 * @version Oct 26, 2014 3:13:51 PM
 */
/**
 * 
 * @author Zing
 * @version 2014年10月28日下午5:31:15
 */
public interface SaleBLService {
	public ResultMessage addSale(Commodity commodity,  int num, int price,  String remark);
	
	public ResultMessage addSaleBack(Commodity commodity,  int num, int price,  String remark;
	
	public ResultMessage submit();


}
