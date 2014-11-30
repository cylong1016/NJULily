package dataservice;

import java.util.ArrayList;

import po.PurchasePO;
import dataenum.BillType;

/**
 * 提供进货（进货退货）数据集体载入、保存、增加、删除、查找
 * @author cylong
 * @version Oct 26, 2014 3:34:35 PM
 */
public interface PurchaseDataService extends CommonDataService<PurchasePO> {

	/**
	 * 按照是进货单还是进货退货单返回可用ID
	 * @param type
	 * @return 进货单或者进货退货单可用ID
	 * @author cylong
	 * @version 2014年11月28日 下午12:11:03
	 */
	public String getID(BillType type);

	/**
	 * @param type 进货单或者进货退货单
	 * @return 该类型单据的全部的ID
	 * @author cylong
	 * @version 2014年11月30日 上午11:50:06
	 */
	public ArrayList<String> getAllID(BillType type);

}
