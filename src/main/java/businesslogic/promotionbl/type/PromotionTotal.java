package businesslogic.promotionbl.type;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CommodityItemPO;
import po.PromotionPO;
import vo.InventoryBillVO;
import vo.commodity.CommodityItemVO;
import vo.promotion.PromotionTotalVO;
import blservice.promotionblservice.PromoInputInfo;
import businesslogic.promotionbl.Promotion;
import businesslogic.promotionbl.PromotionListItem;
import businesslogic.promotionbl.PromotionTrans;
import dataenum.PromotionType;

/**
 * 计算总价的促销策略
 * @author Zing
 * @version Dec 9, 2014 5:35:05 PM
 */
public class PromotionTotal extends Promotion {

	public PromotionTotal() {
		super();
	}

	public ArrayList<PromotionTotalVO> show() throws RemoteException {
		return PromotionTrans.totalPOtoVO(promotionData.show(PromotionType.TOTAL));
	}

	/**
	 * 设置可以进行促销的总价
	 * @param total
	 * @author Zing
	 * @version Dec 9, 2014 7:10:39 PM
	 */
	public void setTotal(double total) {
		list.setTotal(total);
	}

	public void addGifts(CommodityItemVO vo) throws RemoteException {
		PromotionListItem item = new PromotionListItem(vo.ID, vo.number);
		list.addGift(item);
	}

	public void addGiftBill(InventoryBillVO giftBill) throws RemoteException {
		ArrayList<CommodityItemVO> commodityItems = giftBill.commodities;
		for(CommodityItemVO vo : commodityItems) {
			addGifts(vo);
		}
	}

	public PromotionTotalVO submit(PromoInputInfo info) throws RemoteException {
		setInputInfo(info);
		PromotionPO po = buildPromotion();
		promotionData.insert(po);
		return PromotionTrans.totalPOtoVO(po);
	}

	private PromotionPO buildPromotion() {
		double total = list.getTotal();
		ArrayList<CommodityItemPO> gifts = list.getGifts();
		double allowance = list.getAllowance();
		int voucher = list.getVoucher();
		PromotionPO po = new PromotionPO(ID, beginDate, endDate, null, 0, 0, null, null, total, gifts, allowance, voucher);
		return po;
	}

	private void setInputInfo(PromoInputInfo info) {
		beginDate = info.beginDate;
		endDate = info.endDate;
		list.setAllowance(info.allowance);
		list.setVoucher(info.voucher);
	}

}
