package businesslogic.promotionbl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import vo.promotion.PromotionClientVO;
import vo.promotion.PromotionCommodityVO;
import vo.promotion.PromotionTotalVO;
import businesslogic.promotionbl.type.PromotionClient;
import businesslogic.promotionbl.type.PromotionCommodity;
import businesslogic.promotionbl.type.PromotionTotal;
import businesslogic.salebl.info.PromotionInfo_Sale;

public class PromotionInfo implements PromotionInfo_Sale{
	
	Promotion promotion;
	public PromotionInfo() {
		promotion = new Promotion();
	}
	
	public void findFitPromotionCommodity(String ID,ArrayList<String> commodityIDs) {
		PromotionCommodity commodityPromotion = new PromotionCommodity();
		ArrayList<PromotionCommodityVO> tempVOs = new ArrayList<PromotionCommodityVO>();
		for (PromotionCommodityVO vo : commodityPromotion.show()) {
			if (hasPromotion(ID, getID(vo.beginDate, vo.endDate))) {
				tempVOs.add(vo);
			}
		}
		for (int i = 0; i < tempVOs.size(); i++) {
			
		}
		
	}

	public void findFitPromotionClient(String ID, String clientID) {
		PromotionClient clientPromotion = new PromotionClient();
		ArrayList<PromotionClientVO> tempVOs = new ArrayList<PromotionClientVO>();
		for (PromotionClientVO vo : clientPromotion.show()) {
			if (hasPromotion(ID, getID(vo.beginDate, vo.endDate))) {
				tempVOs.add(vo);
			}
		}
		
	}

	public void findFitPromotionTotal(String ID, double beforePrice) {
		PromotionTotal totalPromotion = new PromotionTotal();
		ArrayList<PromotionTotalVO> tempVOs = new ArrayList<PromotionTotalVO>();
		for (PromotionTotalVO vo : totalPromotion.show()) {
			if (hasPromotion(ID, getID(vo.beginDate, vo.endDate))) {
				tempVOs.add(vo);
			}
		}
		
	}
	
	/**
	 * 在这个时候是否有促销策略可以使用
	 * @param ID
	 * @param IDs
	 * @return
	 * @author Zing
	 * @version Dec 9, 2014 6:11:07 PM
	 */
	private boolean hasPromotion(String ID, ArrayList<String> IDs) {
		for(String id : IDs) 
			if (id.contains(ID)) 
				return true;
		return false;
	}
	
	/**
	 * 得到所有的日期区间内的ID
	 * @return
	 * @author Zing
	 * @version Nov 30, 2014 1:50:47 PM
	 */
	private ArrayList<String> getID(String beginDate, String endDate) {
		ArrayList<String> IDs = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			Date begin = sdf.parse(beginDate);
			Date end = sdf.parse(endDate);
			double between = (end.getTime() - begin.getTime())/1000;
			double day = between/24/3600;
			for (int i = 0; i < day; i++) {
				Calendar cd = Calendar.getInstance();
				cd.setTime(sdf.parse(beginDate));
				cd.add(Calendar.DATE, i);
				String ID = sdf.format(cd.getTime());
				IDs.add(ID);
			}		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return IDs;
	}
}
