package businesslogic.commoditybl;

public interface CommoditySort_Commodity {

	/**
	 * 删除某个分类中的商品
	 * @param sortID
	 * @param iD
	 * @author Zing
	 * @version Dec 7, 2014 8:26:12 PM
	 */
	public void deleteCommodity(String sortID, String iD);

	/**
	 * 往某个分类里面添加商品
	 * @param sortID
	 * @param iD
	 * @author Zing
	 * @version Dec 7, 2014 8:30:40 PM
	 */
	public void addCommodity(String sortID, String iD);

}
