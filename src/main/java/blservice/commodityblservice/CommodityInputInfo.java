package blservice.commodityblservice;

public class CommodityInputInfo {
	
	/** 商品名称 */
	public String name;
	/** 商品型号 */
	public String type;
	/** 商品分类ID */
	public String sortID;
	/** 商品进价 */
	public double purPrice;
	/** 商品售价 */
	public double salePrice;
	/** 商品警戒数量 */
	public int alarmNumber;
	
	public CommodityInputInfo(String name, String type, String sortID, double purPrice, double salePrice, int alarmNumber) {
		this.name = name;
		this.type = type;
		this.purPrice = purPrice;
		this.salePrice = salePrice;
		this.sortID = sortID;
		this.alarmNumber = alarmNumber;
	}

}
