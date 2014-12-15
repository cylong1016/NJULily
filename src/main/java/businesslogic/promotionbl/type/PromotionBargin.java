package businesslogic.promotionbl.type;

import java.rmi.RemoteException;
import java.util.ArrayList;

import message.ResultMessage;
import po.CommodityItemPO;
import po.PromotionPO;
import vo.commodity.CommodityItemVO;
import vo.promotion.PromotionBargainVO;
import businesslogic.promotionbl.Promotion;
import businesslogic.promotionbl.PromotionListItem;
import businesslogic.promotionbl.PromotionTrans;
import dataenum.PromotionType;

public class PromotionBargin extends Promotion {	
	
	public PromotionBargin() {
		super();
	}

	/**
	 * 在界面上显示特价包的促销内容
	 * @throws RemoteException 
	 */
	public ArrayList<PromotionBargainVO> show() throws RemoteException {
		PromotionTrans transPOVO = new PromotionTrans();
		return  transPOVO.bargainsPOtoVO(promotionData.show(PromotionType.BARGAINS));
	}

	/**
	 * 添加促销包内商品
	 * @param vo
	 * @author Zing
	 * @version Dec 9, 2014 4:43:19 PM
	 * @throws RemoteException 
	 */
	public void addBargain(CommodityItemVO vo) throws RemoteException {
		PromotionListItem item = new PromotionListItem(vo.ID, vo.number);
		list.addBargain(item);
	}
	
	/**
	 * 设置特价包的总价
	 */
	public void setBargainTotalPrice(double price) {
		list.setTotal(price);
	}

	/**
	 * 提交（同时添加其余信息）
	 * 开始时间、结束时间、总价
	 * @throws RemoteException 
	 */
	public ResultMessage submit(String beginDate, String endDate) throws RemoteException {
		this.beginDate = beginDate;
		this.endDate = endDate;
		PromotionPO po = buildPromotion();
		return promotionData.insert(po);
	}
	
	/**
	 * 建PO表
	 * @return
	 * @author Zing
	 * @version Dec 9, 2014 4:43:27 PM
	 */
	private PromotionPO buildPromotion() {
		ArrayList<CommodityItemPO> bargains = list.getBargains();
		double bargainTotal = list.getTotal();
		PromotionPO po = new PromotionPO(ID, beginDate, endDate, bargains, list.getBeforeTotal(), bargainTotal, null, null, 0, null, 0, 0);
		return po;
	}

}
