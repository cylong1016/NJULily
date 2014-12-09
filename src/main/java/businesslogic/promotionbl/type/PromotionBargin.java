package businesslogic.promotionbl.type;

import java.util.ArrayList;

import po.CommodityItemPO;
import po.PromotionPO;
import dataenum.PromotionType;
import message.ResultMessage;
import vo.commodity.CommodityItemVO;
import vo.promotion.PromotionBargainVO;
import blservice.promotionblservice.PromotionBargainBLService;
import businesslogic.promotionbl.Promotion;
import businesslogic.promotionbl.PromotionListItem;
import businesslogic.promotionbl.PromotionTrans;

public class PromotionBargin extends Promotion implements PromotionBargainBLService {	
	
	public PromotionBargin() {
		super();
	}

	/**
	 * 在界面上显示特价包的促销内容
	 */
	public ArrayList<PromotionBargainVO> show() {
		PromotionTrans transPOVO = new PromotionTrans();
		return  transPOVO.bargainsPOtoVO(promotionData.show(PromotionType.BARGAINS));
	}

	/**
	 * 添加促销包内商品
	 * @param vo
	 * @author Zing
	 * @version Dec 9, 2014 4:43:19 PM
	 */
	public void addBargain(CommodityItemVO vo) {
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
	 */
	public ResultMessage submit(String beginDate, String endDate) {
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
		PromotionPO po = new PromotionPO(ID, beginDate, endDate, bargains, bargainTotal, null, null, 0, null, 0, 0);
		return po;
	}

}
