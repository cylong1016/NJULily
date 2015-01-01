package dataservice.inventorydataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.InventoryBillPO;
import dataenum.BillType;
import dataservice.CommonDataService;

/**
 * 提供库存单据的提交服务（赠送单、报溢单、报损单、报警单）
 * 保存库存盘点的批号
 * @author cylong
 * @version Oct 26, 2014 3:33:20 PM
 */
public interface InventoryDataService extends CommonDataService<InventoryBillPO> {

	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "InventoryData";

	/**
	 * @deprecated 分成4个子方法
	 * @param type （赠送单、报溢单、报损单、报警单）
	 * @return 相应单据的ID
	 * @author cylong
	 * @version 2014年12月2日 下午5:53:27
	 */
	public String getID(BillType type) throws RemoteException;

	/**
	 * @return 新的报溢单的ID
	 * @author cylong
	 * @version 2014年12月9日 下午7:03:43
	 */
	public String getOverflowID() throws RemoteException;

	/**
	 * @return 新的报损单的ID
	 * @author cylong
	 * @version 2014年12月9日 下午7:03:55
	 */
	public String getLossID() throws RemoteException;

	/**
	 * @return 新的报警单的ID
	 * @author cylong
	 * @version 2014年12月9日 下午7:04:04
	 */
	public String getAlarmID() throws RemoteException;

	/**
	 * @return 新的赠送单的ID
	 * @author cylong
	 * @version 2014年12月9日 下午7:04:13
	 */
	public String getGiftID() throws RemoteException;

	/**
	 * @return 返回一个盘点的批号
	 * @author cylong
	 * @version Nov 8, 2014 6:25:36 PM
	 */
	public String returnLotNumber() throws RemoteException;

	/**
	 * @param type 单据类型
	 * @return 按照单据类型返回单据
	 * @author cylong
	 * @version 2014年12月2日 下午10:02:54
	 */
	public ArrayList<InventoryBillPO> show(BillType type) throws RemoteException;

}
