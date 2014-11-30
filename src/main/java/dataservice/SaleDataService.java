package dataservice;

import java.util.ArrayList;

import po.SalesPO;
import dataenum.BillType;

/**
 * 提供销售（销售退货）数据集体载入、保存、增加、删除、查找
 * @author cylong
 * @version Oct 26, 2014 3:52:59 PM
 */
public interface SaleDataService extends CommonDataService<SalesPO> {

	/**
	 * 按照是销售单还是销售退货单返回ID
	 * @param type
	 * @return 销售单或者销售退货单ID
	 * @author cylong
	 * @version 2014年11月28日 下午12:11:03
	 */
	public String getID(BillType type);

	/**
	 * @param type 销售单或者销售退货单
	 * @return 该类型单据的全部的ID
	 * @author cylong
	 * @version 2014年11月30日 上午11:50:06
	 */
	public ArrayList<String> getAllID(BillType type);
}
