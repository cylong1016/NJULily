package vo.commodity;

import vo.ValueObject;
/**
 * 添加／更改商品的时候用的VO
 * @author Zing
 * @version Dec 7, 2014 7:58:41 PM
 */
public class CommodityAddVO extends ValueObject{
	/** 商品ID */
	public String ID;
	/** 商品名称 */
	public String name;
	/** 商品型号 */
	public String type;
	/** 商品分类ID */
	public String sortID;
	/** 商品库存数量 */
	public int inventoryNum;
	/** 商品进价 */
	public double purPrice;
	/** 商品售价 */
	public double salePrice;
	
	public CommodityAddVO(String ID, String name, String type, String sortID, int inventoryNum, double purPrice, double salePrice) {
		this.ID = ID;
		this.name = name;
		this.type = type;
		this.sortID = sortID;
		this.inventoryNum =inventoryNum;
		this.purPrice = purPrice;
		this.salePrice = salePrice;
	}
}
