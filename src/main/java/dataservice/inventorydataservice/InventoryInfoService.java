package dataservice.inventorydataservice;

import po.InventoryBillPO;
import dataservice.TableInfoService;

/**
 * @see dataservice.TableInfoService
 * @author cylong
 * @version 2014年12月14日 上午7:30:35
 */
public interface InventoryInfoService extends TableInfoService<InventoryBillPO> {

	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "InventoryInfo";
}
