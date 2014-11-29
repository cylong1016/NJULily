package businesslogic.promotionbl;

import java.util.ArrayList;

import message.ResultMessage;
import vo.CommodityVO;
import vo.PromotionVO;
import dataenum.PromotionType;
import blservice.promotionblservice.PromoInputInfo;
import blservice.promotionblservice.PromotionBLService;

public class PromotionController implements PromotionBLService{
	
	Promotion promotion;
	
	public PromotionController() {
		promotion = new Promotion();
	}

	public ArrayList<PromotionVO> show(PromotionType type) {
		return promotion.show(type);
	}

	public String getID(PromotionType type) {
		return promotion.getID(type);
	}

	public void addBargain(CommodityVO vo) {
		promotion.addBargain(vo);
		
	}

	public void addGifts(CommodityVO vo) {
		promotion.addGifts(vo);
		
	}

	public ResultMessage submit(PromoInputInfo info) {
		return promotion.submit(info);
	}

}
