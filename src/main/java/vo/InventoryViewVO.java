package vo;

public class InventoryViewVO {
	/** 开始日期 */
	public String beginDate;
	/** 结束日期 */
	public String endDate;
	/** 出库数量（也就是销售数量） */
	public int saleNumber;
	/** 入库数量（也就是进货数量） */
	public int purNumber;
	/** 出库金额（也就是销售金额） */
	public double saleMoney;
	/** 入库金额（也就是进货金额） */
	public double purMoney;
	
	public InventoryViewVO(int saleNumber, int purNumber, double saleMoney, double purMoney) {
		this.saleNumber = saleNumber;
		this.purNumber = purNumber;
		this.saleMoney = saleMoney;
		this.purMoney = purMoney;
	}
	
}
