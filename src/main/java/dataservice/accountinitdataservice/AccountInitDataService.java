package dataservice.accountinitdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import message.ResultMessage;
import po.AccountaInitPO;
import dataservice.DataService;

/**
 * 提供期初建账数据集体载入、保存、增加、查看服务
 * @author cylong
 * @version Oct 26, 2014 3:54:11 PM
 */
public interface AccountInitDataService extends DataService<AccountaInitPO> {

	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "AccountInitData";

	/**
	 * 向序列化数据中插入一个期初建账信息
	 * @param po
	 * @return 处理结果
	 * @author cylong
	 */
	public ResultMessage insert(AccountaInitPO po) throws RemoteException;

	/**
	 * 查看所有期初建账信息，装入ArrayList中
	 * @return 所有期初建账信息
	 * @author cylong
	 * @version Nov 3, 2014 8:42:08 PM
	 */
	public ArrayList<AccountaInitPO> show() throws RemoteException;
}
