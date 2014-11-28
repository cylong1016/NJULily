package dataservice;

import dataenum.BillType;
import message.ResultMessage;
import po.PurchasePO;

/**
 * 提供进货（进货退货）数据集体载入、保存、增加、删除、查找
 * @author cylong
 * @version Oct 26, 2014 3:34:35 PM
 */
public interface PurchaseDataService extends DataService {

	/**
	 * 按照是进货单还是进货退货单返回ID
	 * @param type
	 * @return 进货单或者进货退货单ID
	 * @author cylong
	 * @version 2014年11月28日 下午12:11:03
	 */
	public String getID(BillType type);

	/**
	 * 插入一条进货（进货退货）单
	 * @param po
	 * @return 处理结果
	 */
	public ResultMessage insert(PurchasePO po);

	/**
	 * 以ID查找一张单据
	 * @param ID
	 * @return 进货（进货退货）单
	 */
	public PurchasePO find(String ID);

	/**
	 * 以ID删除一张单据
	 * @param ID
	 * @return 处理结果
	 */
	public ResultMessage delete(String ID);

	/**
	 * 更新单子
	 * @param po
	 * @return 处理结果
	 */
	public ResultMessage update(PurchasePO po);
}
