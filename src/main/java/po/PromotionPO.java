package po;

import java.util.ArrayList;

import dataenum.ClientLevel;
import dataenum.PromotionType;

public class PromotionPO extends PersistentObject {

	private static final long serialVersionUID = 1L;
	/** 促销起始时间 */
	private String beginDate;
	/** 促销结束时间 */
	private String endDate;
	/** 特价包 */
	private ArrayList<CommodityItemPO> bargains;
	private double beforeTotal;
	/** 特价包的总价/总价 */
	private double bargainTotal;
	/** 客户等级 */
	private ClientLevel level;
	/** 赠品单 */
	private ArrayList<CommodityItemPO> gifts;
	/** 购买的商品 */
	private ArrayList<CommodityItemPO> commodities;
	/** 购买的总价 */
	private double total;
	/** 折扣 */
	private double allowance;
	/** 代金券 */
	private int voucher;
	/** 促销策略类型 */
	private PromotionType type;
	
	public PromotionPO(String ID, String beginDate, String endDate, ArrayList<CommodityItemPO> bargains, double beforeTotal, double bargainTotal,
			ClientLevel level, ArrayList<CommodityItemPO> commodities, double total,ArrayList<CommodityItemPO> gifts, double allowance, int voucher, PromotionType type) {
		super(ID);
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.bargains = bargains;
		this.beforeTotal = beforeTotal;
		this.bargainTotal = bargainTotal;
		this.level = level;
		this.commodities = commodities;
		this.total = total;
		this.gifts = gifts;
		this.allowance = allowance;
		this.voucher = voucher;
		this.type = type;
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

	public double getBargainTotal() {
		return bargainTotal;
	}

	public double getBeforeTotal() {
		return beforeTotal;
	}
}
