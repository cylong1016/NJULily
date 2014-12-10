package businesslogic.salebl.info;

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
	public void changeCommodityInfo(String ID, int number, double price, BillType billType);

	/**
	 * 将商品设置成是否可以删除
	 * @param iD
	 * @author Zing
	 * @version Dec 10, 2014 9:39:56 AM
	 */
	public void setDelete(String iD, boolean canDelete);
}
