package businesslogic.promotionbl.type;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import vo.InventoryBillVO;
import vo.commodity.CommodityItemVO;
import vo.promotion.PromotionCommodityVO;
import blservice.promotionblservice.PromoInputInfo;

/**
 * @see blservice.promotionblservice.PromotionCommodityBLService
 * @author cylong
 * @version 2014年12月14日 下午5:10:48
 */
public class PromotionCommodityController {

	private PromotionCommodity promotionCommodity;

	public PromotionCommodityController() {
		promotionCommodity = new PromotionCommodity();
	}

	/**
	 * @see blservice.promotionblservice.PromotionCommodityBLService#show()
	 */
	public ArrayList<PromotionCommodityVO> show() {
		try {
			return promotionCommodity.show();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.promotionblservice.PromotionCommodityBLService#showGifts()
	 */
	public ArrayList<InventoryBillVO> showGifts() {
		try {
			return promotionCommodity.showGifts();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.promotionblservice.PromotionCommodityBLService#getID()
	 */
	public String getID() {
		try {
			return promotionCommodity.getID();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.promotionblservice.PromotionCommodityBLService#addCommodity(vo.commodity.CommodityItemVO)
	 */
	public void addCommodity(String ID, int number) {
		try {
			promotionCommodity.addCommodity(ID, number);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see blservice.promotionblservice.PromotionCommodityBLService#addGifts(vo.commodity.CommodityItemVO)
	 */
	public void addGifts(CommodityItemVO vo) {
		try {
			promotionCommodity.addGifts(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see blservice.promotionblservice.PromotionCommodityBLService#addGiftBill(vo.InventoryBillVO)
	 */
	public void addGiftBill(InventoryBillVO giftBill) {
		try {
			promotionCommodity.addGiftBill(giftBill);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see blservice.promotionblservice.PromotionCommodityBLService#submit(blservice.promotionblservice.PromoInputInfo)
	 */
	public ResultMessage submit(PromoInputInfo info) {
		try {
			return promotionCommodity.submit(info);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.REMOTE_EXCEPTION;
		}
	}
}
