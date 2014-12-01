package businesslogic.promotionbl;

import java.rmi.Naming;
import java.util.ArrayList;

import po.CommodityItemPO;
import po.PromotionPO;
import config.RMI;
import message.ResultMessage;
import vo.CommodityItemVO;
import vo.InventoryBillVO;
import vo.PromotionVO;
import blservice.promotionblservice.PromoInputInfo;
import businesslogic.inventorybl.Inventory;
import dataenum.PromotionType;
import dataservice.PromotionDataService;
import dataservice.commondata.DataFactoryService;

/**
 * 策略1:制定一个特价包
 * 策略2:根据客户等级，制定赠送包/折扣/代金券
 * 策略3:根据购买的商品，制定赠送包／折扣／代金券
 * 策略4:根据购买的商品总价，制定折扣／赠送赠品／代金券
 * @author Zing
 * @version Nov 30, 2014 12:53:47 AM
 */
public class Promotion {
	/** 策略条目*/
	private PromotionList list;
	/** 策略编号*/
	private String ID;
	/** 促销起始时间*/
	private String beginDate;
	/** 促销结束时间*/
	private String endDate;
	/** 策略类型*/
	private PromotionType type;
	
	public Promotion() {
		list = new PromotionList();
	}
	
	/**
	 * 得到销售策略的数据层
	 * @return
	 * @author Zing
	 * @version Nov 30, 2014 9:52:22 AM
	 */
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
	
	/**
	 * 查看不同类型的销售策略
	 * @param type
	 * @return
	 * @author Zing
	 * @version Nov 30, 2014 9:52:28 AM
	 */
	public ArrayList<PromotionVO> show(PromotionType type) {
		
		return null;
	}
	
	/**
	 * 查看已经有的赠送单，帮助总经理制定销售策略
	 * @return
	 * @author Zing
	 * @version Nov 30, 2014 9:52:32 AM
	 */
	public ArrayList<InventoryBillVO> showGifts() {
		InventoryInfo_Promotion info = new Inventory();
		return info.getGifts();
	}

	/**
	 * 制定销售策略前，UI调用方法得到ID
	 * @param type
	 * @return
	 * @author Zing
	 * @version Nov 30, 2014 9:52:35 AM
	 */
	public String getID(PromotionType type) {
		this.type = type;
		this.ID = getPromotionData().getID();
		return ID;
	}

	/**
	 * 添加特价包商品／购买商品
	 * @param vo
	 * @author Zing
	 * @version Nov 30, 2014 9:52:38 AM
	 */
	public void addBargain(CommodityItemVO vo) {
		PromotionListItem item = new PromotionListItem(vo.ID, vo.number);
		list.addBargain(item);
	}

	/**
	 * 添加赠送的商品
	 * @param vo
	 * @author Zing
	 * @version Nov 30, 2014 9:52:43 AM
	 */
	public void addGifts(CommodityItemVO vo) {
		PromotionListItem item = new PromotionListItem(vo.ID, vo.number, vo.price);
		list.addGift(item);
	}

	/**
	 * 提价单据
	 * @param info
	 * @return
	 * @author Zing
	 * @version Nov 30, 2014 9:52:46 AM
	 */
	public ResultMessage submit(PromoInputInfo info) {
		setInputInfo(info);
		PromotionPO po = buildPromotion();
		// TODO 插入数据层中
		return null;
	}

	/**
	 * 
	 * @param info
	 * @author Zing
	 * @version Nov 30, 2014 9:52:49 AM
	 */
	private void setInputInfo(PromoInputInfo info){
		this.beginDate = info.beginDate;
		this.endDate = info.endDate;
		list.setAllowance(info.allowance);
		list.setVoucher(info.voucher);
		list.setLevel(info.level);
		list.setTotal(info.total);
	}
	
	/**
	 * 
	 * @return
	 * @author Zing
	 * @version Nov 30, 2014 9:52:54 AM
	 */
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
		case BARGAINS:
			po = new PromotionPO(ID, beginDate, endDate, list.getBargains(), list.getTotal());
		default:
			break;
		}
		return po;
	}
}
