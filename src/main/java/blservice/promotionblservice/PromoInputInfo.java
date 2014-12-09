package blservice.promotionblservice;

/**
 * 促销策略的其他信息
 * @author Zing
 * @version Nov 29, 2014 6:59:44 PM
 */
public class PromoInputInfo {
	/** 促销起始时间*/
	public String beginDate;
	/** 促销结束时间*/
	public String endDate;
	/** 折扣 */
	public double allowance;
	/** 代金券 */
	public int voucher;
	
	public PromoInputInfo(String beginDate, String endDate, double allowance, int voucher) {
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.allowance = allowance;
		this.voucher = voucher;
	}
	
}
