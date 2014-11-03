package dataservice;

import java.rmi.RemoteException;

import message.ResultMessage;
import po.ClientPO;

/**
 * 提供客户数据集体载入、保存、增删改查服务
 * @author cylong
 * @version Oct 26, 2014 3:53:40 PM
 */
public interface ClientDataService extends DataService {

	/**
	 * 添加一条客户信息
	 * @param po
	 * @return 处理结果
	 */
	public ResultMessage insert(ClientPO po) throws RemoteException;

	/**
	 * 根据客户id查看客户
	 * @param id
	 * @return 客户持久化数据
	 */
	public ClientPO find(String id) throws RemoteException;

	/**
	 * 删除客户信息
	 * @param id
	 * @return 处理结果
	 */
	public ResultMessage delete(String id) throws RemoteException;

	/**
	 * 删除客户信息
	 * @param po
	 * @return 处理结果
	 */
	public ResultMessage update(ClientPO po) throws RemoteException;

}
