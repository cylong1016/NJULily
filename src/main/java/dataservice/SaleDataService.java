package dataservice;

import java.util.ArrayList;

import message.ResultMessage;
import po.SalesPO;
import dataenum.BillType;

/**
 * 提供销售（销售退货）数据集体载入、保存、增加、删除、查找
 * @author cylong
 * @version Oct 26, 2014 3:52:59 PM
 */
public interface SaleDataService extends DataService {

	/**
	 * 按照是销售单还是销售退货单返回ID
	 * @param type
	 * @return 销售单或者销售退货单ID
	 * @author cylong
	 * @version 2014年11月28日 下午12:11:03
	 */
	public String getID(BillType type);

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

	/**
	 * @return 全部的销售（销售退货）单
	 * @author cylong
	 * @version 2014年11月28日 上午11:48:41
	 */
	public ArrayList<SalesPO> getAllSaleBills();
}
