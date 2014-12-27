package vo.promotion;

import java.util.ArrayList;

import vo.commodity.CommodityItemVO;
import dataenum.ClientLevel;

public class PromotionClientVO extends PromotionVO {

	/** 促销起始时间 */
	public String beginDate;
	/** 促销结束时间 */
	public String endDate;
	/** 客户等级 */
	public ClientLevel level;
	/** 赠品单 */
	public ArrayList<CommodityItemVO> gifts;
	/** 折扣 */
	public double allowance;
	/** 代金券 */
	public int voucher;

	/**
	 * 策略2:根据客户等级，制定赠送包/折扣/代金券
	 * @param ID
	 * @param level 客户等级
	 * @param gifts 赠送包商品
	 */
	public PromotionClientVO(String ID, String beginDate, String endDate, ClientLevel level, ArrayList<CommodityItemVO> gifts, double allowance, int voucher) {
		this.ID = ID;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.level = level;
		this.gifts = gifts;
		this.allowance = allowance;
		this.voucher = voucher;
	}

	@Override
	public String toString() {
		return "[促销策略ID="+ ID + ", 开始日期=" + beginDate + ", 结束日期="
				+ endDate + ", 客户等级=" + level.value + ", 赠品=" + gifts
				+ ",\r\n折让=" + allowance + ", 代金券=" + voucher + "]";
	}
	
	
}
