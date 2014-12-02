package server.data.inventorydata;

import po.InventoryBillPO;
import server.data.TableInfo;

/**
 * @see dataservice.inventorydataservice.InventoryInfoService
 * @author cylong
 * @version 2014年12月2日 上午3:26:45
 */
public class InventoryInfo extends TableInfo<InventoryBillPO> {

	private InventoryData inventoryData;

	/**
	 * @see server.data.TableInfo#initPOs()
	 */
	@Override
	protected void initPOs() {
		inventoryData = new InventoryData();
		pos = inventoryData.show();
	}

}
