package dataservice;

import message.ResultMessage;
import po.SalesPO;

/**
 * 提供销售（销售退货）数据集体载入、保存、增加、删除、查找
 * @author cylong
 * @version Oct 26, 2014 3:52:59 PM
 */
public interface SaleDataService extends DataService {

	/**
	 * 插入账单
	 * @param po
	 * @return 处理结果
	 */
	public ResultMessage insert(SalesPO po);

	/**
	 * 以ID查找账单
	 * @param ID
	 * @return 销售（销售退货）单
	 */
	public SalesPO find(String ID);

	/**
	 * 以ID删除账单
	 * @param ID
	 * @return 处理结果
	 */
	public ResultMessage delete(String ID);

	/**
	 * 更新账单
	 * @param po
	 * @return 处理结果
	 */
	public ResultMessage update(SalesPO po);
}
