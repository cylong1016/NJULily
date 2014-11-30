package po;

import java.util.ArrayList;

import dataenum.ClientLevel;
import dataenum.PromotionType;

public class PromotionPO extends PersistentObject {

	private static final long serialVersionUID = 1L;
	/** 促销策略编号 */
	private String ID;
	/** 促销起始时间 */
	private String beginDate;
	/** 促销结束时间 */
	private String endDate;
	/** 特价包 */
	private ArrayList<CommodityItemPO> bargains;
	/** 特价包的总价/总价 */
	private double total;
	/** 客户等级 */
	private ClientLevel level;
	/** 赠品单 */
	private ArrayList<CommodityItemPO> gifts;
	/** 购买的商品 */
	private ArrayList<CommodityItemPO> commodities;
	/** 折扣 */
	private double allowance;
	/** 代金券 */
	private int voucher;
	/** 促销策略类型 */
	private PromotionType type;

	/**
	 * 销售策略1:制定一个特价包
	 * @param ID
	 * @param bargains 特价包里面包含的商品
	 * @param total 特价包总价（和里面的商品无关）
	 */
	public PromotionPO(String ID, String beginDate, String endDate, ArrayList<CommodityItemPO> bargains, double total) {
		super(ID);
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
	public PromotionPO(String ID, String beginDate, String endDate, ClientLevel level, ArrayList<CommodityItemPO> gifts, double allowance, int voucher) {
		super(ID);
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
	 * @param commodity
	 * @param number
	 * @param gifts
	 * @param allowance
	 * @param voucher
	 */
	public PromotionPO(String ID, String beginDate, String endDate, ArrayList<CommodityItemPO> commodities, ArrayList<CommodityItemPO> gifts, double allowance, int voucher) {
		super(ID);
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
	public PromotionPO(String ID, String beginDate, String endDate, double total, ArrayList<CommodityItemPO> gifts, double allowance, int voucher) {
		super(ID);
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.total = total;
		this.gifts = gifts;
		this.allowance = allowance;
		this.voucher = voucher;
		this.type = PromotionType.TOTAL;
	}

	public String getID() {
		return ID;
	}

	public ArrayList<CommodityItemPO> getBargains() {
		return bargains;
	}

	public double getTotal() {
		return total;
	}

	public ClientLevel getLevel() {
		return level;
	}

	public ArrayList<CommodityItemPO> getGifts() {
		return gifts;
	}

	public double getAllowance() {
		return allowance;
	}

	public int getVoucher() {
		return voucher;
	}

	public PromotionType getType() {
		return type;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public ArrayList<CommodityItemPO> getCommodities() {
		return commodities;
	}

}
