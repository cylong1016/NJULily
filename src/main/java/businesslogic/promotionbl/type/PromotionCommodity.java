package businesslogic.promotionbl.type;

import java.util.ArrayList;

import po.CommodityItemPO;
import po.PromotionPO;
import dataenum.PromotionType;
import message.ResultMessage;
import vo.commodity.CommodityItemVO;
import vo.promotion.PromotionCommodityVO;
import blservice.promotionblservice.PromoInputInfo;
import blservice.promotionblservice.PromotionBargainBLService;
import blservice.promotionblservice.PromotionCommodityBLService;
import businesslogic.promotionbl.Promotion;
import businesslogic.promotionbl.PromotionListItem;
import businesslogic.promotionbl.PromotionTrans;

public class PromotionCommodity extends Promotion implements PromotionCommodityBLService{

	public PromotionCommodity() {
		super();
	}
	
	public ArrayList<PromotionCommodityVO> show() {
		PromotionTrans transPOVO = new PromotionTrans();
		return transPOVO.commodityPOtoVO(promotionData.show(PromotionType.COMMODITY));
	}

	public void addCommodity(CommodityItemVO vo) {
		PromotionListItem item = new PromotionListItem(vo.ID, vo.number);
		list.addBargain(item);
	}

	public void addGifts(CommodityItemVO vo) {
		PromotionListItem item = new PromotionListItem(vo.ID, vo.number);
		list.addGift(item);
	}

	public ResultMessage submit(PromoInputInfo info) {
		setInputInfo(info);
		PromotionPO po = buildPromotion();
		return promotionData.insert(po);
	}
	
	private PromotionPO buildPromotion() {
		ArrayList<CommodityItemPO> commodities = list.getBargains();
		ArrayList<CommodityItemPO> gifts = list.getGifts();
		double allowance = list.getAllowance();
		int voucher = list.getVoucher();
		PromotionPO po = new PromotionPO(ID, beginDate, endDate, null, 0, null, commodities, 0, gifts, allowance, voucher);
		return po;
	}

	private void setInputInfo(PromoInputInfo info) {
		beginDate = info.beginDate;
		endDate = info.endDate;
		list.setAllowance(info.allowance);
		list.setVoucher(info.voucher);
	}

}
