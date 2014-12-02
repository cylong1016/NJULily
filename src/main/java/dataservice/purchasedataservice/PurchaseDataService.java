package dataservice.purchasedataservice;

import po.PurchasePO;
import dataenum.BillType;
import dataservice.CommonDataService;
import dataservice.TableInfoService;

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
	 * @return PurchaseInfoService 的实例
	 * @author cylong
	 * @version 2014年12月2日 上午2:43:12
	 */
	public TableInfoService<PurchasePO> getInfo();

}
