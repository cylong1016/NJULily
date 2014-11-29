package vo;

import java.util.ArrayList;
import dataenum.ClientLevel;
import dataenum.PromotionType;

public class PromotionVO extends ValueObject{
	
	/** 促销策略编号*/
	public String ID;
	/** 促销起始时间*/
	public String beginDate;
	/** 促销结束时间*/
	public String endDate;
	/** 特价包 */
	public ArrayList<CommodityItemVO> bargains;
	/** 特价包的总价 */
	public double total;
	/** 客户等级 */
	public ClientLevel level;
	/** 赠品单 */
	public ArrayList<CommodityItemVO> gifts;
	/** 购买的商品 */
	public ArrayList<CommodityItemVO> commodities;
	/** 折扣 */
	public double allowance;
	/** 代金券 */
	public int voucher;
	/** 促销策略类型 */
	public PromotionType type;
	
		
	/**
	 * 销售策略1:制定一个特价包
	 * @param ID
	 * @param bargains 特价包里面包含的商品
	 * @param total 特价包总价（和里面的商品无关）
	 */
	public PromotionVO(String ID, String beginDate, String endDate, ArrayList<CommodityItemVO> bargains, double total) {
		this.ID = ID;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.bargains = bargains;
		this.total = total;
		this.type = PromotionType.BARGAINS;
	}
	
	/**
	 * 策略2:根据客户等级，制定赠送包/折扣/代金券
	 * @param ID
	 * @param level 客户等级
	 * @param gifts 赠送包商品
	 */
	public PromotionVO(String ID, String beginDate, String endDate, ClientLevel level, ArrayList<CommodityItemVO> gifts, double allowance, int voucher) {
		this.ID = ID;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.level = level;
		this.gifts = gifts;
		this.allowance = allowance;
		this.voucher = voucher;
		this.type = PromotionType.CLIENT;
	}
	
	/**
	 * 策略3:根据购买的商品，制定赠送包／折扣／代金券
	 * @param ID
	 * @param beginDate
	 * @param endDate
	 * @param commodities
	 * @param number
	 * @param gifts
	 * @param allowance
	 * @param voucher
	 */
	public PromotionVO(String ID, String beginDate, String endDate, ArrayList<CommodityItemVO> commodities, ArrayList<CommodityItemVO> gifts, double allowance, int voucher){
		this.ID = ID;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.commodities = commodities;
		this.gifts = gifts;
		this.voucher = voucher;
		this.type = PromotionType.COMMODITY;
	}
	
	/**
	 * 策略4:根据购买的商品总价，制定折扣／赠送赠品／代金券
	 * @param ID
	 * @param total
	 * @param allowance
	 * @param voucher
	 */
	public PromotionVO(String ID, String beginDate, String endDate, double total,  ArrayList<CommodityItemVO> gifts, double allowance, int voucher) {
		this.ID = ID;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.total = total;
		this.gifts = gifts;
		this.allowance = allowance;
		this.voucher = voucher;
		this.type = PromotionType.TOTAL;
	}

	
}
