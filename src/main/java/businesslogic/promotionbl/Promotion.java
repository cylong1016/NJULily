package businesslogic.promotionbl;

import java.rmi.Naming;
import java.util.ArrayList;

import po.CommodityItemPO;
import po.PromotionPO;
import config.RMI;
import message.ResultMessage;
import vo.CommodityItemVO;
import vo.PromotionVO;
import blservice.promotionblservice.PromoInputInfo;
import dataenum.PromotionType;
import dataservice.DataFactoryService;
import dataservice.PromotionDataService;

/**
 * 策略1:制定一个特价包
 * 策略2:根据客户等级，制定赠送包/折扣/代金券
 * 策略3:根据购买的商品，制定赠送包／折扣／代金券
 * 策略4:根据购买的商品总价，制定折扣／赠送赠品／代金券
 * @author Zing
 * @version Nov 30, 2014 12:53:47 AM
 */
public class Promotion {
	
	private PromotionList list;
	
	private String ID;
	/** 促销起始时间*/
	private String beginDate;
	/** 促销结束时间*/
	private String endDate;
	
	private PromotionType type;
	
	public Promotion() {
		list = new PromotionList();
	}
	
	public PromotionDataService getPromotionData(){
		try {
			DataFactoryService factory = (DataFactoryService)Naming.lookup(RMI.URL);
			PromotionDataService promotionData = factory.getPromotionData();
			return promotionData;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<PromotionVO> show(PromotionType type) {
		
		return null;
	}

	public String getID(PromotionType type) {
		this.type = type;
		this.ID = getPromotionData().getID();
		return ID;
	}

	public void addBargain(CommodityItemVO vo) {
		PromotionListItem item = new PromotionListItem(vo.ID, vo.number);
		list.addBargain(item);
	}

	public void addGifts(CommodityItemVO vo) {
		PromotionListItem item = new PromotionListItem(vo.ID, vo.number, vo.price);
		list.addGift(item);
	}

	public ResultMessage submit(PromoInputInfo info) {
		this.beginDate = info.beginDate;
		this.endDate = info.endDate;
		PromotionPO po = buildPromotion();
		
		return null;
	}
	
	public ResultMessage submit(double total) {
		return null;
	}
	
	private PromotionPO buildPromotion(){
		PromotionPO po = null;
		ArrayList<CommodityItemPO> gifts = list.getGifts();
		double allowance = list.getAllowance();
		int voucher = list.getVoucher();
		switch (type) {
		case CLIENT:
			po = new PromotionPO(ID, beginDate, endDate, list.getLevel(), gifts, allowance, voucher);
			break;
		case COMMODITY:
			po = new PromotionPO(ID, beginDate, endDate, list.getBargains(), gifts, allowance, voucher);
			break;
		case TOTAL:
			po = new PromotionPO(ID, beginDate, endDate, list.getTotal(), gifts, allowance, voucher);
			break;
		default:
			break;
		}
		return po;
	}
}
