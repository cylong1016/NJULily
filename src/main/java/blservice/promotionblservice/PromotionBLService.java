package blservice.promotionblservice;

import java.util.ArrayList;

import message.ResultMessage;
import dataenum.PromotionType;
import vo.InventoryBillVO;
import vo.PromotionVO;
import vo.commodity.CommodityItemVO;

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
	 * 显示已有的销售策略给ui
	 * @param type 策略类型
	 * @return 促销策略Arraylist
	 * @author Zing
	 * @version Nov 29, 2014 7:00:30 PM
	 */
	public ArrayList<PromotionVO> show(PromotionType type);
	
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
	public String getID(PromotionType type);
	
	/**
	 * 添加商品到特价包
	 * @param vo
	 * @author Zing
	 * @version Nov 29, 2014 7:00:37 PM
	 */
	public void addBargain(CommodityItemVO vo);
		
	/**
	 * 添加商品到赠送单中
	 * @param vo
	 * @author Zing
	 * @version Nov 29, 2014 7:00:40 PM
	 */
	public void addGifts(CommodityItemVO vo);
	
	/**
	 * 提交策略
	 * @param info 其他信息
	 * @return 成功与否
	 * @author Zing
	 * @version Nov 29, 2014 7:00:42 PM
	 */
	public ResultMessage submit(PromoInputInfo info);
	
}
