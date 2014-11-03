package dataservice;

import java.rmi.RemoteException;

import message.ResultMessage;
import po.AccountPO;

/**
 * 提供账户数据集体载入、保存、增删改查服务
 * @author cylong
 * @version Oct 26, 2014 3:53:26 PM
 */
public interface AccountDataService extends DataService {

	/**
	 * 添加一条账户信息
	 * @param po
	 * @return 处理结果
	 */
	public ResultMessage insert(AccountPO po) throws RemoteException;

	/**
	 * 以账户名称查看账户信息
	 * @param name
	 * @return 账户持久化对象
	 */
	public AccountPO find(String name) throws RemoteException;

	/**
	 * 以账户名称删除账户
	 * @param name
	 * @return 处理结果
	 */
	public ResultMessage delete(String name) throws RemoteException;

	/**
	 * 更新账户
	 * @param po
	 * @return 处理结果
	 */
	public ResultMessage update(AccountPO po) throws RemoteException;

}
