package dataservice;

import java.rmi.RemoteException;

import message.ResultMessage;
import po.InventoryBillPO;

/**
 * 提供库存单据的提交服务（赠送单、报溢单、报损单、报警单）
 * @author cylong
 * @version Oct 26, 2014 3:33:20 PM
 */
public interface InventoryDataService extends DataService {

	/**
	 * 出入一个库存账单（赠送单、报溢单、报损单、报警单）
	 * @param po
	 * @return 处理结果
	 */
	public ResultMessage insert(InventoryBillPO po) throws RemoteException;

	/**
	 * 查找库存账单（赠送单、报溢单、报损单、报警单）
	 * @param id
	 * @return 库存账单（赠送单、报溢单、报损单、报警单）
	 */
	public InventoryBillPO find(String id) throws RemoteException;

	/**
	 * 删除库存账单（赠送单、报溢单、报损单、报警单）
	 * @param po
	 * @return 处理结果
	 */
	public ResultMessage delete(InventoryBillPO po) throws RemoteException;

	/**
	 * 更新库存账单（赠送单、报溢单、报损单、报警单）
	 * @param po
	 * @return 处理结果
	 */
	public ResultMessage update(InventoryBillPO po) throws RemoteException;
}
