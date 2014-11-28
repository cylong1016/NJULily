package po;

/**
 * 一条商品记录
 * @author cylong
 * @version Oct 31, 2014 3:26:07 PM
 */
public class CommodityItemPO {

	/** 商品编号 */
	private String ID;
	/** 商品数量 */
	private int number;
	/** 商品 单价 */
	private double price;
	/** 总价 */
	private double total;
	/** 商品备注 */
	private String remark;

	public CommodityItemPO(String id, int number, double price, double total, String remark) {
		this.ID = id;
		this.number = number;
		this.price = price;
		this.remark = remark;
		this.total = price * number;
	}

	public String getID() {
		return ID;
	}

	public int getNumber() {
		return number;
	}

	public double getPrice() {
		return price;
	}

	public double getTotal() {
		return total;
	}

	public String getRemark() {
		return remark;
	}

}
