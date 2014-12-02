package vo;

/**
 * 库存盘点的商品条目
 * 盘点的是当天的库存快照，包括当天的各种商品的名称，型号，库存数量，库存均价，批次，批号， 并且显示行号。
 * 要求可以导出Excel。
 * 盘点时，系统自动根据当前盘点时间生成一个截止点，这个点就是批次（日期）批号（序号），在这个截点之后做的交易是不计入盘点的。
 * 行号就是所有商品展示时的行号。
 * @author Zing
 * @version 2014年11月8日下午7:58:01
 */
public class CheckCommodityItemVO {
	/** 商品名 */
	public String name;
	/** 类型 */
	public String type;
	/** 库存数量 */
	public int number;
	/** 每个商品价格 */
	public double price;
	
	public CheckCommodityItemVO(String name, String type, int number, double price) {
		this.name = name;
		this.type = type;
		this.number = number;
		this.price = price;
	}
		
}
