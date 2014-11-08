package vo;

/**
 * 商品条目
 * @author cylong
 * @version Oct 31, 2014 3:41:16 PM
 */
public class SaleCommodityItemVO extends ValueObject {

	/** 商品名称 */
	public String name;
	/** 商品型号 */
	public String type;
	/** 商品数量 */
	public int number;
	/** 商品 单价 */
	public double price;
	/** 总价 */
	public double total;
	/** 商品备注 */
	public String comment;

	public SaleCommodityItemVO(String id, String name, String type, int number, double price, double total, String comment) {
		super();
		this.name = name;
		this.type = type;
		this.number = number;
		this.price = price;
		this.total = total;
		this.comment = comment;
	}

}
