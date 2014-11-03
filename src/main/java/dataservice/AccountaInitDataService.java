package dataservice;

import java.rmi.RemoteException;

import message.ResultMessage;
import po.AccountaInitPO;

/**
 * 提供期初建账数据集体载入、保存、增加、查看服务
 * @author cylong
 * @version Oct 26, 2014 3:54:11 PM
 */
public interface AccountaInitDataService extends DataService {

	/**
	 * 向序列化数据中插入一个期初建账信息
	 * @param po
	 * @return 处理结果
	 */
	public ResultMessage insert(AccountaInitPO po) throws RemoteException;

	/**
	 * 期初建账po
	 * @param id
	 * @return
	 */
	public AccountaInitPO find(String id) throws RemoteException;
}
