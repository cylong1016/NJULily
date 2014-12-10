package businesslogic.purchasebl;

import dataenum.BillType;

public interface CommodityInfo_Purchase {
	
	/**
	 * 
	 * @param ID
	 * @return
	 * @author Zing
	 * @version Dec 10, 2014 9:45:06 AM
	 */
	public String getType(String ID);
	
	/**
	 * 
	 * @param ID
	 * @return
	 * @author Zing
	 * @version Dec 10, 2014 9:45:03 AM
	 */
	public String getName(String ID);

	/**
	 * 
	 * @param id
	 * @param number
	 * @param price
	 * @param type
	 * @author Zing
	 * @version Dec 10, 2014 9:45:01 AM
	 */
	public void changeCommodityInfo(String id, int number, double price, BillType type);

	/**
	 * 是否可以删除
	 * 只要创建了进货单，就不可以被删除
	 * @param iD
	 * @param b
	 * @author Zing
	 * @version Dec 10, 2014 9:44:35 AM
	 */
	public void setDelete(String ID, boolean b);	
}
