package ui.differui.manager.strategy.myui;

import java.util.ArrayList;

import dataenum.ClientLevel;
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
			//"编号","起始时间","结束时间","客户等级","应送赠品","折扣","代金券"
			
			if(vo.gifts.size() != 0){
				Object[] row = {vo.ID, vo.beginDate, vo.endDate, getLevel(vo.level)
						, vo.gifts.get(0).name +"("+vo.gifts.get(0).number + "件)", getAllowance(vo.allowance), vo.voucher + "元"};
				cellData[i] = row;
			}else{
				Object[] row = {vo.ID, vo.beginDate, vo.endDate, getLevel(vo.level)
						, "无", getAllowance(vo.allowance), vo.voucher + "元" };
				cellData[i] = row;
			}
			
			i++;
		}
		return cellData;
	}
	
	private String getLevel(ClientLevel level){
		if(level.equals(ClientLevel.LEVEL_1)){
			return "一星级";
		}else if(level.equals(ClientLevel.LEVEL_2)){
			return "二星级";
		}else if(level.equals(ClientLevel.LEVEL_3)){
			return "三星级";
		}else if(level.equals(ClientLevel.LEVEL_4)){
			return "四星级";
		}else{
			return "五星级(VIP)";
		}
	}
	
	private String getAllowance(double d){
		switch(String.valueOf(d)){ 
		case "0.5" : return "5折";
		case "0.98" : return "98折";
		case "0.95": return "95折";
		case "0.9" : return "9折";
		case "0.88" : return "88折";
		case "0.85" : return "85折";
		case "0.8" : return "8折";
		case "0.79" : return "79折";
		case "0.75" : return "75折";
		case "0.7" : return "7折";
		case "0.65" : return "65折";
		case "0.6" : return "6折";
		case "0.58" : return "58折";
		default:return "无折扣";
		}
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
			
			if(vo.gifts.size() != 0){
				Object[] row = {vo.ID, vo.beginDate, vo.endDate, vo.total + "元"
						, vo.gifts.get(0).name +"("+vo.gifts.get(0).number + "件)", getAllowance(vo.allowance), vo.voucher + "元"};
				cellData[i] = row;
			}else{
				Object[] row = {vo.ID, vo.beginDate, vo.endDate, vo.total + "元"
						, "无", getAllowance(vo.allowance), vo.voucher + "元" };
				cellData[i] = row;
			}
			
			i++;
		}
		return cellData;
	}
}
