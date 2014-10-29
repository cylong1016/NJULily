package businesslogicservice;

import message.ResultMessage;

/**
 * 负责实现销售策略界面所需要的服务
 * @author cylong
 * @version Oct 26, 2014 3:18:38 PM
 */
public interface PromotionBLService {
	
	/**
	 * 得到销售策略
	 * @return
	 */
	public ResultMessage promote();
}
