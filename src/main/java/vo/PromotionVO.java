package vo;

import java.util.ArrayList;
import dataenum.ClientLevel;

public class PromotionVO extends ValueObject{
	
	public String ID;
	/** */
	public ArrayList<CommodityItemVO> bargains;
	/** */
	public double total;
	/** */
	public ClientLevel level;
	/** */
	public ArrayList<CommodityItemVO> gifts;
	/** */
	public CommodityItemVO commodity;
	/** */
	public double allowance;
	/** */
	public int voucher;
		
	/**
	 * 销售策略1:制定一个特价包
	 * @param ID
	 * @param bargains 特价包里面包含的商品
	 * @param total 特价包总价（和里面的商品无关）
	 */
	public PromotionVO(String ID, ArrayList<CommodityItemVO> bargains, double total) {
		this.ID = ID;
		this.bargains = bargains;
		this.total = total;
	}
	
	/**
	 * 策略2:根据客户等级选择赠送包
	 * @param ID
	 * @param level 客户等级
	 * @param gifts 赠送包商品
	 */
	public PromotionVO(String ID, ClientLevel level, ArrayList<CommodityItemVO> gifts) {
		this.ID = ID;
		this.level = level;
		this.gifts = gifts;
	}
	
	/**
	 * 策略3:根据客户的等级制定折扣
	 * @param ID
	 * @param level
	 * @param allowance
	 */
	public PromotionVO(String ID, ClientLevel level, double allowance) {
		this.ID = ID;
		this.level = level;
		this.allowance = allowance;
	}
	
	/**
	 * 策略4:根据购买的商品制定折扣
	 * @param ID
	 * @param commodity
	 * @param allowance
	 */
	public PromotionVO(String ID, CommodityItemVO commodity, double allowance) {
		this.ID = ID;
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
	public PromotionVO(String ID, double total, double allowance, int voucher) {
		this.ID = ID;
		this.total = total;
		this.allowance = allowance;
		this.voucher = voucher;
	}

	
}
