package po;

import dataenum.Date;

/**
 * 经营情况表
 * 统计显示一段时间内的经营收支状况和利润。
 * 经营收入显示为折让后，并显示出折让了多少。
 * 显示信息：	
 * 1. 收入类：销售收入、商品类收入（商品报溢收入 成本调价收入 进货退货差价 代金券与实际收款差额收入）。
 * 	  收入类显示折让后总收入，并显示折让了多少。
 * 2. 支出类：销售成本、商品类支出（商品报损 商品赠出）。支出类显示总支出。
 * 3. 利润：折让后总收入-总支出。
 * @author Zing
 * @version 2014年11月4日下午7:26:02
 */
public class BussinessStatePO {
	/** 起始时间 */
	private Date begin;
	/** 结束时间 */
	private Date end;
	/** 销售收入*/
	private double saleIncome;
	/** 商品类收入（折让后的总收入）*/
	private double commodityIncome;
	/** 商品报溢收入*/
	private double overflowIncome;
	/** 成本调价收入*/
	private double costIncome;
	/** 进货退货差价*/
	private double purAndBackIncome;
	/** 代金券与实际收款差额收入*/
	private double voucherIncome;
	/** 折让*/
	private double allowance;
	/** 销售成本*/
	private double saleCost;
	/** 商品类支出（也就是总支出）*/
	private double commodityExpen;
	/** 商品报损*/
	private double lossExpen;
	/** 赠送支出*/
	private double giftExpen;
	/** 利润 */
	private double profit;
	
	public BussinessStatePO(Date begin, Date end){
		this.begin = begin;
		this.end = end;
	}

	public Date getBegin() {
		return begin;
	}

	public void setBegin(Date begin) {
		this.begin = begin;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public double getSaleIncome() {
		return saleIncome;
	}

	public void setSaleIncome(double saleIncome) {
		this.saleIncome = saleIncome;
	}

	public double getCommodityIncome() {
		return commodityIncome;
	}

	public void setCommodityIncome(double commodityIncome) {
		this.commodityIncome = commodityIncome;
	}

	public double getOverflowIncome() {
		return overflowIncome;
	}

	public void setOverflowIncome(double overflowIncome) {
		this.overflowIncome = overflowIncome;
	}

	public double getCostIncome() {
		return costIncome;
	}

	public void setCostIncome(double costIncome) {
		this.costIncome = costIncome;
	}

	public double getPurAndBackIncome() {
		return purAndBackIncome;
	}

	public void setPurAndBackIncome(double purAndBackIncome) {
		this.purAndBackIncome = purAndBackIncome;
	}

	public double getVoucherIncome() {
		return voucherIncome;
	}

	public void setVoucherIncome(double voucherIncome) {
		this.voucherIncome = voucherIncome;
	}

	public double getAllowance() {
		return allowance;
	}

	public void setAllowance(double allowance) {
		this.allowance = allowance;
	}

	public double getSaleCost() {
		return saleCost;
	}

	public void setSaleCost(double saleCost) {
		this.saleCost = saleCost;
	}

	public double getCommodityExpen() {
		return commodityExpen;
	}

	public void setCommodityExpen(double commodityExpen) {
		this.commodityExpen = commodityExpen;
	}

	public double getLossExpen() {
		return lossExpen;
	}

	public void setLossExpen(double lossExpen) {
		this.lossExpen = lossExpen;
	}

	public double getGiftExpen() {
		return giftExpen;
	}

	public void setGiftExpen(double giftExpen) {
		this.giftExpen = giftExpen;
	}

	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}
	
}
