package dataservice;

import java.rmi.RemoteException;

import message.ResultMessage;
import po.CommodityPO;

/**
 * 提供商品集体载入、保存、增删改查服务
 * @author cylong
 * @version Oct 26, 2014 3:52:31 PM
 */
public interface CommodityDataServer extends DataService {

	/**
	 * 插入一条商品信息
	 * @param po
	 * @return 处理结果
	 */
	public ResultMessage insert(CommodityPO po) throws RemoteException;

	/**
	 * 根据商品id查看商品
	 * @param id
	 * @return 商品持久化数据
	 */
	public CommodityPO find(String id) throws RemoteException;

	/**
	 * 删除商品数据
	 * @param id
	 * @return 处理结果
	 */
	public ResultMessage delete(String id) throws RemoteException;

	/**
	 * 更新商品数据
	 * @param po
	 * @return 处理结果
	 */
	public ResultMessage update(CommodityPO po) throws RemoteException;
}
