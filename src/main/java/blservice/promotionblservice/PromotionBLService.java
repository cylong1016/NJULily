package blservice.promotionblservice;

import java.util.ArrayList;

import vo.CommodityVO;
import vo.PromotionVO;
import message.ResultMessage;

/**
 * 负责实现销售策略界面所需要的服务
 * @author cylong
 * @version Oct 26, 2014 3:18:38 PM
 */
public interface PromotionBLService {
	
	public ArrayList<PromotionVO> show();
	
	public void addCommodity(CommodityVO vo)
}
