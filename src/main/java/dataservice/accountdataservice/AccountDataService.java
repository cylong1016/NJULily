package dataservice.accountdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.AccountPO;
import dataenum.FindTypeAccount;
import dataservice.CommonDataService;

/**
 * 提供账户数据集体载入、保存、增删改查服务
 * @author cylong
 * @version Oct 26, 2014 3:53:26 PM
 */
public interface AccountDataService extends CommonDataService<AccountPO> {

	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "AccountData";

	/**
	 * 以keywords查看账户信息，type是以什么方式查找，null代表模糊查找
	 * @param keywords
	 * @return 账户持久化对象
	 */
	public ArrayList<AccountPO> find(String keywords, FindTypeAccount type) throws RemoteException;

}
