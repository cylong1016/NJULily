package businesslogic.promotionbl.type;

import java.util.ArrayList;

import po.CommodityItemPO;
import po.PromotionPO;
import message.ResultMessage;
import vo.InventoryBillVO;
import vo.commodity.CommodityItemVO;
import vo.promotion.PromotionClientVO;
import dataenum.ClientLevel;
import dataenum.PromotionType;
import blservice.promotionblservice.PromoInputInfo;
import blservice.promotionblservice.PromotionBargainBLService;
import blservice.promotionblservice.PromotionClientBLService;
import businesslogic.promotionbl.Promotion;
import businesslogic.promotionbl.PromotionListItem;
import businesslogic.promotionbl.PromotionTrans;

public class PromotionClient extends Promotion implements PromotionClientBLService{
	
	public PromotionClient() {
		super();
	}
	public ArrayList<PromotionClientVO> show() {
		PromotionTrans transPOVO = new PromotionTrans();
		return transPOVO.clientPOtoVO(promotionData.show(PromotionType.CLIENT));
	}

	/**
	 * 逐个添加gift
	 * @param vo
	 * @author Zing
	 * @version Dec 9, 2014 5:07:30 PM
	 */
	public void addGifts(CommodityItemVO vo) {
		PromotionListItem item = new PromotionListItem(vo.ID, vo.number);
		list.addGift(item);
	}

	/**
	 * 设置促销的客户等级
	 * @param level
	 * @author Zing
	 * @version Dec 9, 2014 7:07:54 PM
	 */
	public void setClient(ClientLevel level){
		list.setLevel(level);
	}
	
	
	public void addGiftBill(InventoryBillVO giftBill) {
		// TODO Auto-generated method stub
		
	}
	
	public ResultMessage submit(PromoInputInfo info) {
		setInputInfo(info);
		PromotionPO po = buildPromotion();
		return promotionData.insert(po);
	}
	
	private void setInputInfo(PromoInputInfo info) {
		beginDate = info.beginDate;
		endDate = info.endDate;
		list.setAllowance(info.allowance);
		list.setVoucher(info.voucher);
	}
	
	private PromotionPO buildPromotion() {
		ClientLevel level = list.getLevel();
		ArrayList<CommodityItemPO> gifts = list.getGifts();
		double allowance = list.getAllowance();
		int voucher = list.getVoucher();
		PromotionPO po = new PromotionPO(ID, beginDate, endDate, null, 0, level, null, 0, gifts, allowance, voucher);
		return po;
	}
}
