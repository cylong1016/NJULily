package po;

/**
 * 商品条目
 * @author cylong
 * @version Oct 31, 2014 3:26:07 PM
 */
public class SaleCommodityItemPO {
	
	/** 商品编号*/
	private String ID;
	/** 商品名称 */
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
	private String comment;

	public SaleCommodityItemPO(String id, String name, String type, int number, double price, double total, String comment) {
		this.ID = id;
		this.name = name;
		this.type = type;
		this.number = number;
		this.price = price;
		this.comment = comment;
		this.total = price * number;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
