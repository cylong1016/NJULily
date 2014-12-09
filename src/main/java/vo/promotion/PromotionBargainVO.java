package vo.promotion;

import java.util.ArrayList;

import vo.commodity.CommodityItemVO;
import dataenum.PromotionType;

public class PromotionBargainVO extends PromotionVO{
	
	/** 促销策略编号*/
	public String ID;
	/** 促销起始时间*/
	public String beginDate;
	/** 促销结束时间*/
	public String endDate;
	/** 特价包 */
	public ArrayList<CommodityItemVO> bargains;
	/** 特价包的总价 */
	public double bargainTotal;
	/** 促销策略类型 */
	public PromotionType type;
		
	/**
	 * 销售策略1:制定一个特价包
	 * @param ID
	 * @param bargains 特价包里面包含的商品
	 * @param total 特价包总价（和里面的商品无关）
	 */
	public PromotionBargainVO(String ID, String beginDate, String endDate, ArrayList<CommodityItemVO> bargains, double bargainTotal) {
		this.ID = ID;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.bargains = bargains;
		this.bargainTotal = bargainTotal;
		this.type = PromotionType.BARGAINS;
	}
	
	/**
	 * 传入的数据
	 * @param beginDate
	 * @param endDate
	 * @param bargainTotal
	 */
	public PromotionBargainVO(String beginDate, String endDate, double bargainTotal) {
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.bargainTotal = bargainTotal;
	}
}
