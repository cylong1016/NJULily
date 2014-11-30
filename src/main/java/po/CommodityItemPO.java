package po;

import java.io.Serializable;

/**
 * 一条商品记录
 * @author cylong
 * @version Oct 31, 2014 3:26:07 PM
 */
public class CommodityItemPO implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	/** 商品编号 */
	private String ID;
	/** 商品名 */
	private String name;
	/** 商品型号 */
	private String type;
	/** 商品数量 */
	private int number;
	/** 商品 单价 */
	private double price;
	/** 总价 */
	private double total;
	/** 商品备注 */
	private String remark;

	// TODO 需要有商品的名字
	public CommodityItemPO(String ID, String name, int number, double price, String remark) {
		this.ID = ID;
		this.name = name;
		this.number = number;
		this.price = price;
		this.remark = remark;
		this.total = price * number;
	}

	public CommodityItemPO(String ID, int number, double price) {
		this.ID = ID;
		this.number = number;
		this.price = price;
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

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

}
