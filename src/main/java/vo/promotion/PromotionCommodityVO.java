package vo.promotion;

import java.util.ArrayList;

import vo.commodity.CommodityItemVO;

public class PromotionCommodityVO extends PromotionVO{
	
	/** 促销策略编号*/
	public String ID;
	/** 促销起始时间*/
	public String beginDate;
	/** 促销结束时间*/
	public String endDate;
	/** 购买的商品 */
	public ArrayList<PromotionGoodsVO> goods;
	/** 赠品单 */
	public ArrayList<CommodityItemVO> gifts;
	/** 折扣 */
	public double allowance;
	/** 代金券 */
	public int voucher;

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
	public PromotionCommodityVO(String ID, String beginDate, String endDate, ArrayList<PromotionGoodsVO> goods, ArrayList<CommodityItemVO> gifts, double allowance, int voucher){
		this.ID = ID;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.goods = goods;
		this.gifts = gifts;
		this.voucher = voucher;
	}
}
