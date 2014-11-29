package blservice.promotionblservice;


import vo.CommodityItemVO;
import dataenum.ClientLevel;

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
	/** 特价包的总价 */
	public double total;
	/** 客户等级 */
	public ClientLevel level;
	/** 购买的商品 */
	public CommodityItemVO commodity;
	/** 商品数量 */
	public int number;
	/** 折扣 */
	public double allowance;
	/** 代金券 */
	public int voucher;
	
	public PromoInputInfo(String beginDate, String endDate, double total) {
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.total = total;
	}
	
	public PromoInputInfo(String beginDate, String endDate, ClientLevel level, double allowance, int voucher) {
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.level = level;
		this.allowance = allowance;
		this.voucher = voucher;
	}
	
	public PromoInputInfo(String beginDate, String endDate, CommodityItemVO commodity, int number, double allowance, int voucher) {
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.commodity = commodity;
		this.number = number;
		this.allowance = allowance;
		this.voucher = voucher;
	}
	
}
