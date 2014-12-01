package vo;


/**
 * 商品值对象
 * @author cylong
 * @version Oct 26, 2014  2:26:31 PM
 */
public class CommodityVO {
	
	public String ID;
	/** 商品名称 */
	public String name;
	/** 商品型号 */
	public String type;
	/** 商品库存数量 */
	public int inventoryNum;
	/** 商品进价 */
	public double purPrice;
	/** 商品售价 */
	public double salePrice;
	/** 商品最近进价 */
	public double recentPurPrice;
	/** 商品最近售价 */
	public double recentSalePrice;
	/** 商品警戒数量 */
	public int alarmNumber;
	
	public CommodityVO(String ID, String name, String type, int inventoryNum, double purPrice, double salePrice, double recentPurpPrice, double recentSalePrice, int alarmNumber){
		super();
		this.ID = ID;
		this.name = name;
		this.type = type;
		this.inventoryNum =inventoryNum;
		this.purPrice = purPrice;
		this.salePrice = salePrice;
		this.recentPurPrice = recentPurpPrice;
		this.recentSalePrice = recentSalePrice;
		this.alarmNumber = alarmNumber;
	}
	
}
