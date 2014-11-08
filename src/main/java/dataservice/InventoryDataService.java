package dataservice;

import message.ResultMessage;
import po.InventoryBillPO;

/**
 * 提供库存单据的提交服务（赠送单、报溢单、报损单、报警单）
 * 保存库存盘点的批号
 * @author cylong
 * @version Oct 26, 2014 3:33:20 PM
 */
public interface InventoryDataService extends DataService {

	/**
	 * 插入一个库存账单（赠送单、报溢单、报损单、报警单）
	 * @param po
	 * @return 处理结果
	 */
	public ResultMessage insert(InventoryBillPO po);

	/**
	 * 以ID查找库存账单（赠送单、报溢单、报损单、报警单）
	 * @param ID
	 * @return 库存账单（赠送单、报溢单、报损单、报警单）
	 */
	public InventoryBillPO find(String ID);

	/**
	 * 更新库存账单（赠送单、报溢单、报损单、报警单）
	 * @param po
	 * @return 处理结果
	 */
	public ResultMessage update(InventoryBillPO po);
	
	/**
	 * @return 返回一个盘点的批号
	 * @author cylong
	 * @version Nov 8, 2014  6:25:36 PM
	 */
	public String returnNumber();
}
