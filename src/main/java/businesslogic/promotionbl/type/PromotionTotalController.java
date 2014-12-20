package businesslogic.promotionbl.type;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.InventoryBillVO;
import vo.commodity.CommodityItemVO;
import vo.promotion.PromotionTotalVO;
import blservice.promotionblservice.PromoInputInfo;
import blservice.promotionblservice.PromotionTotalBLService;

/**
 * @see blservice.promotionblservice.PromotionTotalBLService
 * @author cylong
 * @version 2014年12月14日 下午5:11:24
 */
public class PromotionTotalController implements PromotionTotalBLService {

	private PromotionTotal promotionTotal;

	/**
	 * @author cylong
	 * @version 2014年12月14日 下午5:13:26
	 */
	public PromotionTotalController() {
		promotionTotal = new PromotionTotal();
	}

	/**
	 * @see blservice.promotionblservice.PromotionTotalBLService#show()
	 */
	@Override
	public ArrayList<PromotionTotalVO> show() {
		try {
			return promotionTotal.show();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.promotionblservice.PromotionTotalBLService#showGifts()
	 */
	@Override
	public ArrayList<InventoryBillVO> showGifts() {
		try {
			return promotionTotal.showGifts();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.promotionblservice.PromotionTotalBLService#getID()
	 */
	@Override
	public String getID() {
		try {
			return promotionTotal.getID();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.promotionblservice.PromotionTotalBLService#setTotal(double)
	 */
	@Override
	public void setTotal(double total) {
		promotionTotal.setTotal(total);
	}

	/**
	 * @see blservice.promotionblservice.PromotionTotalBLService#addGifts(vo.commodity.CommodityItemVO)
	 */
	@Override
	public void addGifts(CommodityItemVO vo) {
		try {
			promotionTotal.addGifts(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see blservice.promotionblservice.PromotionTotalBLService#addGiftBill(vo.InventoryBillVO)
	 */
	@Override
	public void addGiftBill(InventoryBillVO giftBill) {
		try {
			promotionTotal.addGiftBill(giftBill);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see blservice.promotionblservice.PromotionTotalBLService#submit(blservice.promotionblservice.PromoInputInfo)
	 */
	@Override
	public PromotionTotalVO submit(PromoInputInfo info) {
		try {
			return promotionTotal.submit(info);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
}
