package businesslogic.inventorybl.info;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.BillType;

public interface CommodityInfo_Inventory {
	
	/**
	 * 得到当前所有的商品ID
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 6:04:29 PM
	 */
	public ArrayList<String> getAllID() throws RemoteException;
	
	/**
	 * 根据ID得到商品的名字
	 * @param ID
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 6:04:46 PM
	 */
	public String getName(String ID) throws RemoteException;
	
	/**
	 * 根据ID得到商品的类型
	 * @param ID
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 6:04:49 PM
	 */
	public String getType(String ID) throws RemoteException;
	
	/**
	 * 根据ID得到商品的数量
	 * @param ID
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 6:04:52 PM
	 */
	public int getNumber(String ID) throws RemoteException;
	
	/**
	 * 根据ID得到商品的价格
	 * @param ID
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 6:04:54 PM
	 * @throws RemoteException 
	 */
	public double getAvePrice(String ID) throws RemoteException;
	
	/**
	 * 根据ID得到商品的价格
	 * @param ID
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 6:04:57 PM
	 * @throws RemoteException 
	 */
	public double getPurPrice(String ID) throws RemoteException;

	/**
	 * 库存单据通过审批后，更改商品数量
	 * @param id
	 * @param number
	 * @param billType
	 * @author Zing
	 * @version Dec 3, 2014 4:58:06 PM
	 */
	public void changeNumber(String id, int number, BillType billType) throws RemoteException;

}
