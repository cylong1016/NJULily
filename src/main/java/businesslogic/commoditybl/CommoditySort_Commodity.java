package businesslogic.commoditybl;

import java.rmi.RemoteException;

public interface CommoditySort_Commodity {

	/**
	 * 删除某个分类中的商品
	 * @param sortID
	 * @param iD
	 * @author Zing
	 * @version Dec 7, 2014 8:26:12 PM
	 * @throws RemoteException 
	 */
	public void deleteCommodity(String sortID, String iD) throws RemoteException;

	/**
	 * 往某个分类里面添加商品
	 * @param sortID
	 * @param iD
	 * @author Zing
	 * @version Dec 7, 2014 8:30:40 PM
	 * @throws RemoteException 
	 */
	public void addCommodity(String sortID, String iD) throws RemoteException;

	/**
	 * 判断该商品分类是否已经有子类
	 * @param sortID
	 * @return
	 * @author Zing
	 * @version Dec 8, 2014 4:29:25 PM
	 * @throws RemoteException 
	 */
	public boolean hasLeaf(String sortID) throws RemoteException;

}
