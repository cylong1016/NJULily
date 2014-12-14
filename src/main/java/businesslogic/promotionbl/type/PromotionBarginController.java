package businesslogic.promotionbl.type;

import java.rmi.RemoteException;
import java.util.ArrayList;

import message.ResultMessage;
import vo.InventoryBillVO;
import vo.commodity.CommodityItemVO;
import vo.promotion.PromotionBargainVO;
import blservice.promotionblservice.PromotionBargainBLService;

/**
 * @see blservice.promotionblservice.PromotionBargainBLService
 * @author cylong
 * @version 2014年12月14日 下午5:08:50
 */
public class PromotionBarginController implements PromotionBargainBLService {

	private PromotionBargin promotionBargin;

	public PromotionBarginController() {
		promotionBargin = new PromotionBargin();
	}

	/**
	 * @see blservice.promotionblservice.PromotionBargainBLService#show()
	 */
	@Override
	public ArrayList<PromotionBargainVO> show() {
		try {
			return promotionBargin.show();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.promotionblservice.PromotionBargainBLService#showGifts()
	 */
	@Override
	public ArrayList<InventoryBillVO> showGifts() {
		try {
			return promotionBargin.showGifts();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.promotionblservice.PromotionBargainBLService#getID()
	 */
	@Override
	public String getID() {
		try {
			return promotionBargin.getID();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.promotionblservice.PromotionBargainBLService#addBargain(vo.commodity.CommodityItemVO)
	 */
	@Override
	public void addBargain(CommodityItemVO vo) {
		try {
			promotionBargin.addBargain(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see blservice.promotionblservice.PromotionBargainBLService#setBargainTotalPrice(double)
	 */
	@Override
	public void setBargainTotalPrice(double price) {
		promotionBargin.setBargainTotalPrice(price);
	}

	/**
	 * @see blservice.promotionblservice.PromotionBargainBLService#submit(java.lang.String, java.lang.String)
	 */
	@Override
	public ResultMessage submit(String beginDate, String endDate) {
		try {
			return promotionBargin.submit(beginDate, endDate);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.REMOTE_EXCEPTION;
		}
	}
}
