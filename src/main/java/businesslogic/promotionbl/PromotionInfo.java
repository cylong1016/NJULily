package businesslogic.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.PromotionPO;
import dataenum.ClientLevel;
import vo.promotion.PromotionBargainVO;
import vo.promotion.PromotionClientVO;
import vo.promotion.PromotionCommodityVO;
import vo.promotion.PromotionTotalVO;
import businesslogic.clientbl.ClientInfo;
import businesslogic.common.DateOperate;
import businesslogic.promotionbl.info.ClientInfo_Promotion;
import businesslogic.promotionbl.type.PromotionBargin;
import businesslogic.promotionbl.type.PromotionClient;
import businesslogic.promotionbl.type.PromotionTotal;
import businesslogic.salebl.info.PromotionInfo_Sale;

public class PromotionInfo implements PromotionInfo_Sale{
	
	Promotion promotion;
	
	public PromotionInfo() {
		promotion = new Promotion();
	}
	
	@Override
	public ArrayList<PromotionBargainVO> showBargains() throws RemoteException {
		PromotionBargin bargains = new PromotionBargin();
		return bargains.show();
	}
	
//	public ArrayList<PromotionCommodityVO> findFitPromotionCommodity(String ID,ArrayList<String> commodityIDs, ArrayList<Integer> numbers) throws RemoteException {
//		PromotionCommodity commodityPromotion = new PromotionCommodity();
//		ArrayList<PromotionCommodityVO> tempVOs = new ArrayList<PromotionCommodityVO>();
//		// 得到符合时间的促销策略
//		for (PromotionCommodityVO vo : commodityPromotion.show()) {
//			if (hasPromotion(ID, getID(vo.beginDate, vo.endDate))) {
//				tempVOs.add(vo);
//			}
//		}
//		// 如果没有符合的时间段的，直接返回
//		if ((tempVOs!= null && tempVOs.isEmpty()) || tempVOs == null) {
//			return null;
//		}
//		// 封装对应的数据
//		ArrayList<PromotionGoodsVO> goods = new ArrayList<PromotionGoodsVO>();
//		for (int i = 0; i < commodityIDs.size(); i++) {
//			PromotionGoodsVO good = new PromotionGoodsVO(commodityIDs.get(i), null, numbers.get(i));
//			goods.add(good);
//		}
//		// 查看是否有符合促销策略的商品
//			boolean hasPromotion = false;
//			boolean hasGood = false;
//			// 对每个存在的策略进行循环
//			for (int j = 0; j < tempVOs.size(); j++) {
//				// 每个策略里面的商品进行循环
//				int sizeInPromotion = tempVOs.get(j).goods.size();
//				int i = 0;
//				for (int k = 0; i < sizeInPromotion;) {
//					if (goods.get(k).ID.equals(tempVOs.get(j).goods.get(i).ID)) {
//						k++; i++;
//					}
//					else {
//						k++;
//					}
//				}
//			}
//			for (int j = 0; j < tempVOs.size(); j++) {
//				for (int i = 0; i < goods.size(); i++) {
//					for (PromotionGoodsVO promotionGood : tempVOs.get(j).goods) {
//						if (promotionGood.ID.equals(goods.get(i).ID)) {
//							continue;
//						}
//						
//					}
//				}
//			}
//
//		return null;
//	}

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
		PromotionBargin promotionBargin = new PromotionBargin();
		PromotionPO po = promotionBargin.getPromotionData().find(ID);
		return PromotionTrans.bargainPOvoVO(po);
	}

	@Override
	public ArrayList<PromotionCommodityVO> findFitPromotionCommodity(String iD,
			ArrayList<String> commodityIDs, ArrayList<Integer> commodityNumber)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
