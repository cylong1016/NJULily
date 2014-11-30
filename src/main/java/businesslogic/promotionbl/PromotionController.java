package businesslogic.promotionbl;

import java.util.ArrayList;
import message.ResultMessage;
import vo.CommodityItemVO;
import vo.InventoryBillVO;
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
	
	public ArrayList<InventoryBillVO> showGifts() {
		return promotion.showGifts();
	}

	public String getID(PromotionType type) {
		return promotion.getID(type);
	}

	public void addBargain(CommodityItemVO vo) {
		promotion.addBargain(vo);
		
	}

	public void addGifts(CommodityItemVO vo) {
		promotion.addGifts(vo);
		
	}

	public ResultMessage submit(PromoInputInfo info) {
		return promotion.submit(info);
	}

}
