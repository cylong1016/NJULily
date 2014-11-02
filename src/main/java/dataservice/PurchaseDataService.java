package dataservice;

import message.ResultMessage;
import po.PurchasePO;

/**
 * 提供进货（进货退货）数据集体载入、保存、增加、删除、查找
 * @author cylong
 * @version Oct 26, 2014 3:34:35 PM
 */
public interface PurchaseDataService extends DataService {

	/**
	 * 插入一条进货（进货退货）单
	 * @param po
	 * @return 处理结果
	 */
	public ResultMessage insert(PurchasePO po);

	/**
	 * 以id查找一张单据
	 * @param id
	 * @return 进货（进货退货）单
	 */
	public PurchasePO find(String id);

	/**
	 * 以id删除一张单据
	 * @param id
	 * @return 处理结果
	 */
	public ResultMessage delete(String id);

	/**
	 * 更新单子
	 * @param po
	 * @return 处理结果
	 */
	public ResultMessage update(PurchasePO po);
}
