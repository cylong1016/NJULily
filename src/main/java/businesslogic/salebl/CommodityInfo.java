package businesslogic.salebl;

/**
 * 由Commodity实现，获得商品的信息
 * @author Zing
 */
public interface CommodityInfo {
	
	public String getType(String ID);
	
	public String getName(String ID);
}
