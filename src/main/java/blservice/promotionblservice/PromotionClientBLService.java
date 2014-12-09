package blservice.promotionblservice;

import java.util.ArrayList;

import dataenum.ClientLevel;
import message.ResultMessage;
import vo.InventoryBillVO;
import vo.commodity.CommodityItemVO;
import vo.promotion.PromotionClientVO;

public interface PromotionClientBLService {
	/**
	 * 显示已有的销售策略给ui
	 * @return 促销策略Arraylist
	 * @author Zing
	 * @version Nov 29, 2014 7:00:30 PM
	 */
	public ArrayList<PromotionClientVO> show();
	
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
	 * 添加设置成赠送品的商品
	 * @param vo
	 * @author Zing
	 * @version Dec 9, 2014 6:58:15 PM
	 */
	public void addGifts(CommodityItemVO vo);
	
	/**
	 * 设置促销的客户等级
	 * @param level
	 * @author Zing
	 * @version Dec 9, 2014 7:07:54 PM
	 */
	public void setClient(ClientLevel level);
	
	/**
	 * 提交策略
	 * @param info 其他信息
	 * @return 成功与否
	 * @author Zing
	 * @version Nov 29, 2014 7:00:42 PM
	 */
	public ResultMessage submit(PromoInputInfo info);
}
