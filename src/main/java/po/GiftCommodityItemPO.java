package po;

public class GiftCommodityItemPO {
	
	private String ID;
	/** 商品名称 */
	private String name;
	/** 商品型号 */
	private String type;
	/** 商品赠送的数量 */
	private int number;
	/** 商品进价 */
	private double purPrice;
	
	public GiftCommodityItemPO(String ID, String name, String type, int number, double purPrice) {
		this.ID = ID;
		this.name = name;
		this.type = type;
		this.number = number;
		this.purPrice = purPrice;
	}

	public String getID() {
		return ID;
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

	public double getPurPrice() {
		return purPrice;
	}
	

}
