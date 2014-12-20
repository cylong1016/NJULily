package blservice.promotionblservice;

import java.util.ArrayList;

import vo.InventoryBillVO;
import vo.commodity.CommodityItemVO;
import vo.promotion.PromotionBargainVO;

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
public interface PromotionBargainBLService {
	
	/**
	 * 显示已有的销售策略给ui
	 * @return 促销策略Arraylist
	 * @author Zing
	 * @version Nov 29, 2014 7:00:30 PM
	 */
	public ArrayList<PromotionBargainVO> show();
	
	/**
	 * 查看已经有的赠送单，帮助总经理制定策略
	 * @return 赠送单
	 * @author Zing
	 * @version Nov 30, 2014 9:39:47 AM
	 */
	public ArrayList<InventoryBillVO> showGifts();
	
	/**
	 * 在添加一个销售策略时调用，得到ID
	 * @param type 销售策略的ID
	 * @return 策略类型
	 * @author Zing
	 * @version Nov 29, 2014 7:00:34 PM
	 */
	public String getID();
	
	/**
	 * 添加促销包内商品
	 * @param vo
	 * @author Zing
	 * @version Dec 9, 2014 4:43:19 PM
	 */
	public void addBargain(CommodityItemVO vo);
	
	/**
	 * 设置特价包的总价
	 * @param price
	 * @author Zing
	 * @version Dec 9, 2014 7:04:04 PM
	 */
	public void setBargainTotalPrice(double price);
	
	
	/**
	 * 提交策略
	 * @param info 其他信息
	 * @return 成功与否
	 * @author Zing
	 * @version Nov 29, 2014 7:00:42 PM
	 */
	public PromotionBargainVO submit(String beginDate, String endDate);
	
}
