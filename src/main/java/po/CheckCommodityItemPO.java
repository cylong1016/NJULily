package po;

/**
 * 库存盘点的商品条目
 * 盘点的是当天的库存快照，包括当天的各种商品的名称，型号，库存数量，库存均价，批次，批号， 并且显示行号。
 * 要求可以导出Excel。
 * 盘点时，系统自动根据当前盘点时间生成一个截止点，这个点就是批次（日期）批号（序号），在这个截点之后做的交易是不计入盘点的。
 * 行号就是所有商品展示时的行号。
 * @author Zing
 * @version Nov 28, 20141:33:37 PM
 */
public class CheckCommodityItemPO {
	/** 商品名 */
	private String name;
	/** 类型 */
	private String type;
	/** 库存数量 */
	private int number;
	/** 库存均价 */
	private double avePrice;
	
	public CheckCommodityItemPO(String name, String type, int number, double avePrice) {
		this.name = name;
		this.type = type;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public int getNumber() {
		return number;
	}

	public double getAvePrice() {
		return avePrice;
	}
}
