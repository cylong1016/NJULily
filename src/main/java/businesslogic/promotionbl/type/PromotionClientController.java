package businesslogic.promotionbl.type;

import java.rmi.RemoteException;
import java.util.ArrayList;

import log.LogMsgController;
import vo.InventoryBillVO;
import vo.commodity.CommodityItemVO;
import vo.promotion.PromotionClientVO;
import dataenum.ClientLevel;
import blservice.promotionblservice.PromoInputInfo;
import blservice.promotionblservice.PromotionClientBLService;

/**
 * @see blservice.promotionblservice.PromotionClientBLService
 * @author cylong
 * @version 2014年12月14日 下午5:10:00
 */
public class PromotionClientController implements PromotionClientBLService {

	private PromotionClient promotionClient;

	public PromotionClientController() {
		promotionClient = new PromotionClient();
	}

	/**
	 * @see blservice.promotionblservice.PromotionClientBLService#show()
	 */
	@Override
	public ArrayList<PromotionClientVO> show() {
		try {
			return promotionClient.show();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.promotionblservice.PromotionClientBLService#showGifts()
	 */
	@Override
	public ArrayList<InventoryBillVO> showGifts() {
		try {
			return promotionClient.showGifts();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.promotionblservice.PromotionClientBLService#getID()
	 */
	@Override
	public String getID() {
		try {
			return promotionClient.getID();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.promotionblservice.PromotionClientBLService#addGifts(vo.commodity.CommodityItemVO)
	 */
	@Override
	public void addGifts(CommodityItemVO vo) {
		try {
			promotionClient.addGifts(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see blservice.promotionblservice.PromotionClientBLService#addGiftBill(vo.InventoryBillVO)
	 */
	@Override
	public void addGiftBill(InventoryBillVO giftBill) {
		try {
			promotionClient.addGiftBill(giftBill);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see blservice.promotionblservice.PromotionClientBLService#setClient(dataenum.ClientLevel)
	 */
	@Override
	public void setClient(ClientLevel level) {
		promotionClient.setClient(level);
	}

	/**
	 * @see blservice.promotionblservice.PromotionClientBLService#submit(blservice.promotionblservice.PromoInputInfo)
	 */
	@Override
	public PromotionClientVO submit(PromoInputInfo info) {
		try {
			PromotionClientVO vo = promotionClient.submit(info);
			if (vo == null) {
				return null;
			}
			LogMsgController.addLog("添加客户促销策略 " + vo.toString());
			return vo;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
}
