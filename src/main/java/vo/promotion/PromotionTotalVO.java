package vo.promotion;

import java.util.ArrayList;

import vo.commodity.CommodityItemVO;

public class PromotionTotalVO extends PromotionVO {

	/** 促销起始时间 */
	public String beginDate;
	/** 促销结束时间 */
	public String endDate;
	/** 购买的商品总价 */
	public double total;
	/** 赠品单 */
	public ArrayList<CommodityItemVO> gifts;
	/** 折扣 */
	public double allowance;
	/** 代金券 */
	public int voucher;

	/**
	 * 策略4:根据购买的商品总价，制定折扣／赠送赠品／代金券
	 * @param ID
	 * @param total
	 * @param allowance
	 * @param voucher
	 */
	public PromotionTotalVO(String ID, String beginDate, String endDate, double total, ArrayList<CommodityItemVO> gifts, double allowance, int voucher) {
		this.ID = ID;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.total = total;
		this.gifts = gifts;
		this.allowance = allowance;
		this.voucher = voucher;
	}

	@Override
	public String toString() {
		return "[ID="+ ID +  ", 起始日期=" + beginDate + ", 结束日期="
				+ endDate + ", 可促销总价=" + total + ", 赠品=" + gifts.toString()
				+ ", 折让=" + allowance + ", 代金券=" + voucher + "]";
	}
	
	
}
