package dataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import po.PersistentObject;

/**
 * 通用的数据层方法，增删改查
 * @author cylong
 * @version 2014年11月30日 上午10:52:18
 */
public interface CommonDataService<PO extends PersistentObject> extends DataService<PO> {

	/**
	 * 向序列化文件中添加一个po
	 * @param po
	 * @return 处理结果
	 */
	public ResultMessage insert(PO po) throws RemoteException;

	/**
	 * 根据ID删除
	 * @param ID
	 * @return 处理结果
	 */
	public ResultMessage delete(String ID) throws RemoteException;

	/**
	 * 更新po
	 * @param po
	 * @return 处理结果
	 */
	public ResultMessage update(PO po) throws RemoteException;

	/**
	 * 显示全部po
	 * @return 返回所有po的集合
	 * @author cylong
	 * @version Nov 8, 2014 9:35:06 PM
	 */
	public ArrayList<PO> show() throws RemoteException;

}
