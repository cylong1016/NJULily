package dataservice.inventorydataservice;

import java.util.ArrayList;

import po.InventoryBillPO;
import dataenum.BillType;
import dataservice.CommonDataService;
import dataservice.TableInfoService;

/**
 * 提供库存单据的提交服务（赠送单、报溢单、报损单、报警单）
 * 保存库存盘点的批号
 * @author cylong
 * @version Oct 26, 2014 3:33:20 PM
 */
public interface InventoryDataService extends CommonDataService<InventoryBillPO> {

	/**
	 * @deprecated 分成4个子方法
	 * @param type （赠送单、报溢单、报损单、报警单）
	 * @return 相应单据的ID
	 * @author cylong
	 * @version 2014年12月2日 下午5:53:27
	 */
	public String getID(BillType type);

	/**
	 * @return 新的报溢单的ID
	 * @author cylong
	 * @version 2014年12月9日 下午7:03:43
	 */
	public String getOverflowID();

	/**
	 * @return 新的报损单的ID
	 * @author cylong
	 * @version 2014年12月9日 下午7:03:55
	 */
	public String getLossID();

	/**
	 * @return 新的报警单的ID
	 * @author cylong
	 * @version 2014年12月9日 下午7:04:04
	 */
	public String getAlarmID();

	/**
	 * @return 新的赠送单的ID
	 * @author cylong
	 * @version 2014年12月9日 下午7:04:13
	 */
	public String getGiftID();

	/**
	 * @return 返回一个盘点的批号
	 * @author cylong
	 * @version Nov 8, 2014 6:25:36 PM
	 */
	public String returnNumber();

	/**
	 * @return InventoryInfoService 的实例
	 * @author cylong
	 * @version 2014年12月2日 上午2:45:01
	 */
	public TableInfoService<InventoryBillPO> getInfo();

	/**
	 * @param type 单据类型
	 * @return 按照单据类型返回单据
	 * @author cylong
	 * @version 2014年12月2日 下午10:02:54
	 */
	public ArrayList<InventoryBillPO> show(BillType type);
}
