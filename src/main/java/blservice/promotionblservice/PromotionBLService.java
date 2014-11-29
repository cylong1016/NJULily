package blservice.promotionblservice;

import java.util.ArrayList;

import message.ResultMessage;
import dataenum.PromotionType;
import vo.CommodityVO;
import vo.PromotionVO;

/**
 * 负责实现销售策略界面所需要的服务
 * @author cylong
 * @version Oct 26, 2014 3:18:38 PM
 */
/**
 * 销售策略1:制定一个特价包
 * 策略2:根据客户等级，制定赠送包/折扣/代金券
 * 策略3:根据购买的商品，制定赠送包／折扣／代金券
 * 策略4:根据购买的商品总价，制定折扣／赠送赠品／代金券
 * @author Zing
 * @version Nov 29, 2014 6:52:24 PM
 */
public interface PromotionBLService {
	
	/**
	 * 
	 * @param type
	 * @return
	 * @author Zing
	 * @version Nov 29, 2014 7:00:30 PM
	 */
	public ArrayList<PromotionVO> show(PromotionType type);
	
	/**
	 * 
	 * @param type
	 * @return
	 * @author Zing
	 * @version Nov 29, 2014 7:00:34 PM
	 */
	public String getID(PromotionType type);
	
	/**
	 * 
	 * @param vo
	 * @author Zing
	 * @version Nov 29, 2014 7:00:37 PM
	 */
	public void addCommodity(CommodityVO vo);
		
	/**
	 * 
	 * @param vo
	 * @author Zing
	 * @version Nov 29, 2014 7:00:40 PM
	 */
	public void addGifts(CommodityVO vo);
	
	/**
	 * 
	 * @param info
	 * @return
	 * @author Zing
	 * @version Nov 29, 2014 7:00:42 PM
	 */
	public ResultMessage submit(PromoInputInfo info);
}
