package blservice.promotionblservice;

import java.util.ArrayList;

import vo.InventoryBillVO;
import vo.commodity.CommodityItemVO;
import vo.promotion.PromotionTotalVO;

public interface PromotionTotalBLService {
	
	/**
	 * 显示已有的销售策略给ui
	 * @return 促销策略Arraylist
	 * @author Zing
	 * @version Nov 29, 2014 7:00:30 PM
	 */
	public ArrayList<PromotionTotalVO> show();
	
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
	 * 设置可以进行促销的总价
	 * @param total
	 * @author Zing
	 * @version Dec 9, 2014 7:10:39 PM
	 */
	public void setTotal(double total);
	
	/**
	 * 添加设置成赠送品的商品
	 * @param vo
	 * @author Zing
	 * @version Dec 9, 2014 6:58:15 PM
	 */
	public void addGifts(CommodityItemVO vo);
	
	/**
	 * 添加已存在的赠送单作为赠品
	 * @param giftBill
	 * @author Zing
	 * @version Dec 10, 2014 11:39:44 PM
	 */
	public void addGiftBill(InventoryBillVO giftBill);
	
	/**
	 * 提交策略
	 * @param info 其他信息
	 * @return 成功与否
	 * @author Zing
	 * @version Nov 29, 2014 7:00:42 PM
	 */
	public PromotionTotalVO submit(PromoInputInfo info);
}
