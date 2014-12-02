package businesslogic.inventorybl.info;

import java.util.ArrayList;

public interface CommodityInfo_Inventory {
	
	/**
	 * 得到当前所有的商品ID
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 6:04:29 PM
	 */
	public ArrayList<String> getAllID();
	
	/**
	 * 根据ID得到商品的名字
	 * @param ID
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 6:04:46 PM
	 */
	public String getName(String ID);
	
	/**
	 * 根据ID得到商品的类型
	 * @param ID
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 6:04:49 PM
	 */
	public String getType(String ID);
	
	/**
	 * 根据ID得到商品的数量
	 * @param ID
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 6:04:52 PM
	 */
	public int getNumber(String ID);
	
	/**
	 * 根据ID得到商品的价格
	 * @param ID
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 6:04:54 PM
	 */
	public double getAvePrice(String ID);
	
	/**
	 * 根据ID得到商品的价格
	 * @param ID
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 6:04:57 PM
	 */
	public double getPurPrice(String ID);

}
