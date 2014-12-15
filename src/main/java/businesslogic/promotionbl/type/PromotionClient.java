package businesslogic.promotionbl.type;

import java.rmi.RemoteException;
import java.util.ArrayList;

import message.ResultMessage;
import po.CommodityItemPO;
import po.PromotionPO;
import vo.InventoryBillVO;
import vo.commodity.CommodityItemVO;
import vo.promotion.PromotionClientVO;
import blservice.promotionblservice.PromoInputInfo;
import businesslogic.promotionbl.Promotion;
import businesslogic.promotionbl.PromotionListItem;
import businesslogic.promotionbl.PromotionTrans;
import dataenum.ClientLevel;
import dataenum.PromotionType;

public class PromotionClient extends Promotion {
	
	public PromotionClient() {
		super();
	}
	public ArrayList<PromotionClientVO> show() throws RemoteException {
		PromotionTrans transPOVO = new PromotionTrans();
		return transPOVO.clientPOtoVO(promotionData.show(PromotionType.CLIENT));
	}

	/**
	 * 逐个添加gift
	 * @param vo
	 * @author Zing
	 * @version Dec 9, 2014 5:07:30 PM
	 * @throws RemoteException 
	 */
	public void addGifts(CommodityItemVO vo) throws RemoteException {
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
		PromotionPO po = new PromotionPO(ID, beginDate, endDate, null, 0, 0,level, null, 0, gifts, allowance, voucher);
		return po;
	}
}
