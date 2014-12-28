package vo;

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
 * @version 2014年11月2日下午3:50:31
 */
public class BusinessStateVO {
	/** 起始时间 */
	public String begin;
	/** 结束时间 */
	public String end;
	/** 销售收入*/
	public double saleIncome;
	/**（折让后的总收入）*/
	public double totalIncome;
	/** 商品报溢收入*/
	public double overflowIncome;
	/** 成本调价收入*/
	public double costIncome;
	/** 代金券与实际收款差额收入*/
	public double voucherIncome;
	/** 折让*/
	public double allowance;
	/** 销售成本*/
	public double saleCost;
	/** （也就是总支出）*/
	public double totalExpen;
	/** 商品报损*/
	public double lossExpen;
	/** 赠送支出*/
	public double giftExpen;
	/** 利润 */
	public double profit;
	
	public BusinessStateVO(double saleIncome, double totalIncome, double overflowIncome, double costIncome, double voucherIncome, double allowance, 
			double saleCost, double totalExpen ,double lossExpen, double giftExpen, double profit){
		this.saleIncome = saleIncome;
		this.totalIncome = totalIncome;
		this.overflowIncome = overflowIncome;
		this.costIncome = costIncome;
		this.voucherIncome = voucherIncome;
		this.allowance = allowance;
		this.saleCost = saleCost;
		this.totalExpen =totalExpen;
		this.lossExpen = lossExpen;
		this.giftExpen = giftExpen;
		this.profit = profit;

	}
}
