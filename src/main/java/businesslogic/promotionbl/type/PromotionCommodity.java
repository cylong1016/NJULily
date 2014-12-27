package businesslogic.promotionbl.type;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CommodityItemPO;
import po.PromotionPO;
import vo.InventoryBillVO;
import vo.commodity.CommodityItemVO;
import vo.promotion.PromotionCommodityVO;
import blservice.promotionblservice.PromoInputInfo;
import businesslogic.promotionbl.Promotion;
import businesslogic.promotionbl.PromotionListItem;
import businesslogic.promotionbl.PromotionTrans;
import dataenum.PromotionType;
import dataenum.ResultMessage;

public class PromotionCommodity extends Promotion {

	public PromotionCommodity() {
		super();
	}
	
	public ArrayList<PromotionCommodityVO> show() throws RemoteException {
		return PromotionTrans.commodityPOtoVO(promotionData.show(PromotionType.COMMODITY));
	}

	public void addCommodity(String ID, int number) throws RemoteException {
		PromotionListItem item = new PromotionListItem(ID, number);
		list.addBargain(item);
	}

	public void addGifts(CommodityItemVO vo) throws RemoteException {
		PromotionListItem item = new PromotionListItem(vo.ID, vo.number);
		list.addGift(item);
	}

	public void addGiftBill(InventoryBillVO giftBill) throws RemoteException {
		ArrayList<CommodityItemVO> commodityItems = giftBill.commodities;
		for (CommodityItemVO vo : commodityItems) {
			addGifts(vo);
		}		
	}
	
	public ResultMessage submit(PromoInputInfo info) throws RemoteException {
		setInputInfo(info);
		PromotionPO po = buildPromotion();
		return promotionData.insert(po);
	}
	
	private PromotionPO buildPromotion() {
		ArrayList<CommodityItemPO> commodities = list.getBargains();
		ArrayList<CommodityItemPO> gifts = list.getGifts();
		double allowance = list.getAllowance();
		int voucher = list.getVoucher();
		PromotionPO po = new PromotionPO(ID, beginDate, endDate, null, 0, 0, null, commodities, 0, gifts, allowance, voucher);
		return po;
	}

	private void setInputInfo(PromoInputInfo info) {
		beginDate = info.beginDate;
		endDate = info.endDate;
		list.setAllowance(info.allowance);
		list.setVoucher(info.voucher);
	}

}
