package dataservice;

import message.ResultMessage;
import po.AccountBillPO;

/**
 * 收款单、付款单、现金单的集体载入、保存、查看修改操作
 * @author cylong
 * @version Oct 26, 2014 3:51:07 PM
 */
public interface AccountBillDataService extends DataService {

	/**
	 * 插入收款单（付款单）
	 * @param po
	 * @return 处理信息
	 */
	public ResultMessage insert(AccountBillPO po);

	/**
	 * 更新收款单（付款单）
	 * @param po
	 * @return 处理信息
	 */
	public ResultMessage update(AccountBillPO po);

	/**
	 * 以ID查找对象
	 * @param ID
	 * @return 收款单（付款单）持久化对象
	 */
	public AccountBillPO find(String ID);

	/**
	 * 以ID删除对象
	 * @param ID
	 * @return 处理信息
	 */
	public ResultMessage delete(String ID);
}
