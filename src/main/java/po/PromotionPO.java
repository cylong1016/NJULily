package po;

import java.util.ArrayList;

import dataenum.ClientLevel;

public class PromotionPO extends PersistentObject{

	private static final long serialVersionUID = 1L;

	private String ID;
	/** */
	private ArrayList<CommodityItemPO> bargains;
	/** */
	private double total;
	/** */
	private ClientLevel level;
	/** */
	private ArrayList<CommodityItemPO> gifts;
	/** */
	private CommodityItemPO commodity;
	/** */
	private double allowance;
	/** */
	private int voucher;
		
	/**
	 * 销售策略1:制定一个特价包
	 * @param ID
	 * @param bargains 特价包里面包含的商品
	 * @param total 特价包总价（和里面的商品无关）
	 */
	public PromotionPO(String ID, ArrayList<CommodityItemPO> bargains, double total) {
		super(ID);
		this.bargains = bargains;
		this.total = total;
	}
	
	/**
	 * 策略2:根据客户等级选择赠送包
	 * @param ID
	 * @param level 客户等级
	 * @param gifts 赠送包商品
	 */
	public PromotionPO(String ID, ClientLevel level, ArrayList<CommodityItemPO> gifts) {
		super(ID);
		this.level = level;
		this.gifts = gifts;
	}
	
	/**
	 * 策略3:根据客户的等级制定折扣
	 * @param ID
	 * @param level
	 * @param allowance
	 */
	public PromotionPO(String ID, ClientLevel level, double allowance) {
		super(ID);
		this.level = level;
		this.allowance = allowance;
	}
	
	/**
	 * 策略4:根据购买的商品制定折扣
	 * @param ID
	 * @param commodity
	 * @param allowance
	 */
	public PromotionPO(String ID, CommodityItemPO commodity, double allowance) {
		super(ID);
		this.commodity = commodity;
		this.allowance = allowance;
	}
	
	/**
	 * 策略5:根据购买的商品总价制定折扣或者赠送代金券
	 * @param ID
	 * @param total
	 * @param allowance
	 * @param voucher
	 */
	public PromotionPO(String ID, double total, double allowance, int voucher) {
		super(ID);
		this.total = total;
		this.allowance = allowance;
		this.voucher = voucher;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public CommodityItemPO getCommodity() {
		return commodity;
	}

	public double getAllowance() {
		return allowance;
	}

	public int getVoucher() {
		return voucher;
	}

}
