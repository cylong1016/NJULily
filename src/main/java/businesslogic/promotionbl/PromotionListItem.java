package businesslogic.promotionbl;

import businesslogic.commoditybl.CommodityInfo;

public class PromotionListItem {
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
	
	private CommodityInfo_Promotion info;
	
	/**
	 * 策略1中的特价包内商品，不用计算总价
	 * @param ID
	 * @param number
	 */
	public PromotionListItem(String ID, int number) {
		this.ID = ID;
		info = new CommodityInfo();
		this.name = info.getName(ID);
		this.type = info.getType(ID);
		this.price = info.getPurPrice(ID);
		this.number = number;
	}
	
	/**
	 * 策略234中的商品、赠品，需要单价，需要进行总价的计算
	 * @param ID
	 * @param number
	 * @param price
	 */
	public PromotionListItem(String ID, int number, double price) {
		this.ID = ID;
		info = new CommodityInfo();
		this.name = info.getName(ID);
		this.type = info.getType(ID);
		this.price = price;
		this.number = number;
		this.total = number * price;
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

	public double getPrice() {
		return price;
	}

	public double getTotal() {
		return total;
	}

	public CommodityInfo_Promotion getInfo() {
		return info;
	}
	
	

}
