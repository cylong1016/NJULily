package vo;

public class GiftCommodityItemVO {
	public String ID;
	/** 商品名称 */
	public String name;
	/** 商品型号 */
	public String type;
	/** 商品赠送的数量 */
	public int number;
	/** 商品进价 */
	public double purPrice;
	
	public GiftCommodityItemVO(String ID, String name, String type, int number, double purPrice) {
		this.ID = ID;
		this.name = name;
		this.type = type;
		this.number = number;
		this.purPrice = purPrice;
	}
}
