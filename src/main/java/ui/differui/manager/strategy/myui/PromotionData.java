package ui.differui.manager.strategy.myui;

import java.util.ArrayList;

import vo.promotion.PromotionClientVO;
import vo.promotion.PromotionTotalVO;
import blservice.promotionblservice.PromotionClientBLService;
import blservice.promotionblservice.PromotionTotalBLService;
import businesslogic.promotionbl.type.PromotionClientController;
import businesslogic.promotionbl.type.PromotionTotalController;

public class PromotionData {
	
	static final int CELL = 7;
	
	/**
	 * 将客户的促销单放进表格中
	 * @return
	 * @author Zing
	 * @version Dec 11, 2014 1:29:48 AM
	 */
	public Object[][] getClientPromotion() {
		PromotionClientBLService promotionBL = new PromotionClientController();
		ArrayList<PromotionClientVO> clientProVO = promotionBL.show();
		int i = 0;
		Object[][] cellData = new Object[clientProVO.size()][CELL];
		for (PromotionClientVO vo : clientProVO) {
			Object[] row = {vo.ID, vo.beginDate, vo.endDate, vo.level, vo.gifts, vo.allowance,vo.voucher};
			cellData[i] = row;
			i++;
		}
		return cellData;
	}
	
	/**
	 * 将商品的促销单放进表格中
	 * @deprecated 这个不做了~
	 * @return
	 * @author Zing
	 * @version Dec 11, 2014 1:30:11 AM
	 */
	public Object[][] getCommodityPromotion() {
//		PromotionCommodityBLService promotionBL = new PromotionCommodityController();
//		ArrayList<PromotionCommodityVO> commodityVOs = promotionBL.show();
//		Object[][] cellData = new Object[commodityVOs.size()][CELL];
//		int i = 0;
//		for (PromotionCommodityVO vo : commodityVOs) {
//			Object[] row = {vo.ID, vo.beginDate, vo.endDate, vo.commodities, vo.gifts, vo.allowance,vo.voucher};
//			cellData[i] = row;
//			i++;
//		}
//		return cellData;
		return null;
	}
	
	/**
	 * 将总价的促销单放进表格中
	 * @return
	 * @author Zing
	 * @version Dec 11, 2014 1:30:40 AM
	 */
	public Object[][] getTotalPromotion() {
		PromotionTotalBLService promotionBL = new PromotionTotalController();
		ArrayList<PromotionTotalVO> totalVOs = promotionBL.show();
		Object[][] cellData = new Object[totalVOs.size()][CELL];
		int i = 0;
		for (PromotionTotalVO vo : totalVOs) {
			Object[] row = {vo.ID, vo.beginDate, vo.endDate, vo.total, vo.gifts, vo.allowance,vo.voucher};
			cellData[i] = row;
			i++;
		}
		return cellData;
	}
}
