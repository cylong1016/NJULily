package businesslogicservice;

import vo.AccountVO;
import vo.ClientVO;
import vo.CommodityVO;
import message.ResultMessage;

/**
 * 负责实现建账界面所需要的服务
 * @author cylong
 * @version Oct 26, 2014 3:16:58 PM
 */
/**
 * 
 * @author Zing
 * @version 2014年10月28日下午5:36:24
 */
public interface AccountainitBLService {
	
	/**
	 *  建立初期账目
	 * @param commodity
	 * @param client
	 * @param account
	 * @return
	 */
	public ResultMessage addInit(CommodityVO commodity, ClientVO client, AccountVO account);
	
	/**
	 * 返回上年的平均进价和售价
	 * @param time
	 * @param purPrice
	 * @param salePrice
	 * @return
	 */
	public ResultMessage getEverage(int time, double purPrice, double salePrice);


}
