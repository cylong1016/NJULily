package businesslogic.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CommodityItemPO;
import po.PromotionPO;
import vo.promotion.PromotionBargainVO;
import vo.promotion.PromotionClientVO;
import vo.promotion.PromotionCommodityVO;
import vo.promotion.PromotionTotalVO;
import businesslogic.clientbl.ClientInfo;
import businesslogic.common.DateOperate;
import businesslogic.promotionbl.info.ClientInfo_Promotion;
import businesslogic.promotionbl.type.PromotionBargain;
import businesslogic.promotionbl.type.PromotionClient;
import businesslogic.promotionbl.type.PromotionTotal;
import businesslogic.salebl.info.PromotionInfo_Sale;
import dataenum.ClientLevel;

public class PromotionInfo implements PromotionInfo_Sale{
	
	Promotion promotion;
	PromotionPO po;
	
	public PromotionInfo() {
		promotion = new Promotion();
	}
	
	@Override
	public ArrayList<PromotionBargainVO> showBargains() throws RemoteException {
		PromotionBargain bargains = new PromotionBargain();
		return bargains.show();
	}

	/**
	 * 返回合适等级的促销策略
	 * @throws RemoteException 
	 */
	public ArrayList<PromotionClientVO> findFitPromotionClient(String ID, String clientID) throws RemoteException {
		PromotionClient clientPromotion = new PromotionClient();
		ArrayList<PromotionClientVO> clientVOs = new ArrayList<PromotionClientVO>();
		for (PromotionClientVO vo : clientPromotion.show()) {
			if (DateOperate.isIncluded(ID, vo.beginDate, vo.endDate)) {
				clientVOs.add(vo);
			}
		}
		ClientInfo_Promotion info = new ClientInfo();
		ClientLevel clientLevel= info.getLevel(clientID);
		for (int i = 0; i < clientVOs.size(); ) {
			if (clientVOs.get(i).level != clientLevel) {
				clientVOs.remove(i);
			}
			else {
				i++;
			}
		}
		return clientVOs;
	}

	/**
	 * 查看是否有符合总价的促销策略
	 * @throws RemoteException 
	 */
	public ArrayList<PromotionTotalVO> findFitPromotionTotal(String ID, double beforePrice) throws RemoteException {
		PromotionTotal totalPromotion = new PromotionTotal();
		ArrayList<PromotionTotalVO> totalVOs = new ArrayList<PromotionTotalVO>();
		for (PromotionTotalVO vo : totalPromotion.show()) {
			if (DateOperate.isIncluded(ID, vo.beginDate, vo.endDate)) {
				totalVOs.add(vo);
			}
		}
		for (int i = 0; i < totalVOs.size();) {
			if (totalVOs.get(i).total >= beforePrice) {
				totalVOs.remove(i);
			}
			else {
				i++;
			}
		}
		return totalVOs;
	}

	@Override
	public PromotionBargainVO findBargains(String ID) throws RemoteException {
		PromotionBargain promotionBargin = new PromotionBargain();
		PromotionPO po = promotionBargin.getPromotionData().find(ID);
		return PromotionTrans.bargainPOvoVO(po);
	}

	@Override
	public ArrayList<PromotionCommodityVO> findFitPromotionCommodity(String iD,
			ArrayList<String> commodityIDs, ArrayList<Integer> commodityNumber)
			throws RemoteException {
		return null;
	}
	
	public double getAllowance(String ID) throws RemoteException {
		this.po = promotion.getPromotionData().find(ID);
		return po.getAllowance();
	}

	@Override
	public double getVoucher(String ID) {
		return po.getVoucher();
	}
	
	public ArrayList<CommodityItemPO> getGifts(String ID) throws RemoteException {
		return po.getGifts();
	}

}
