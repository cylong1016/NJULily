package vo.commodity;

/**
 * 可以更改的商品信息的VO
 * @author Zing
 * @version Dec 8, 2014 5:22:17 PM
 */
public class CommodityUpdateVO {

	/** 商品名称 */
	public String name;
	/** 商品型号 */
	public String type;
	/** 商品进价 */
	public double purPrice;
	/** 商品售价 */
	public double salePrice;

	public CommodityUpdateVO(String name, String type, double purPrice, double salePrice) {
		this.name = name;
		this.type = type;
		this.purPrice = purPrice;
		this.salePrice = salePrice;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[名称=" + this.name + ", 型号=" + this.type + ", 进价=" + this.purPrice + ", 售价=" + this.salePrice + "]";
	}

}
