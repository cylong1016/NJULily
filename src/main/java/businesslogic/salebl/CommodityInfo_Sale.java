package businesslogic.salebl;

import dataenum.BillType;

/**
 * 由Commodity实现，获得商品的信息
 * @author Zing
 */
public interface CommodityInfo_Sale {
	
	/**
	 * 根据ID得到商品的类型
	 * @param ID
	 * @return
	 * @author Zing
	 * @version Dec 3, 2014 2:25:10 PM
	 */
	public String getType(String ID);
	
	/**
	 * 根据ID得到商品的名字
	 * @param ID
	 * @return
	 * @author Zing
	 * @version Dec 3, 2014 2:25:07 PM
	 */
	public String getName(String ID);

	/**
	 * 更改商品数量
	 * @param id
	 * @param number
	 * @author Zing
	 * @version Dec 3, 2014 2:24:59 PM
	 */
	public void changeNumber(String ID, int number, double price, BillType billType);
}
