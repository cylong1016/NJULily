package dataservice.purchasedataservice;

import java.rmi.RemoteException;

import po.PurchasePO;
import dataenum.BillType;
import dataservice.CommonDataService;

/**
 * 提供进货（进货退货）数据集体载入、保存、增加、删除、查找
 * @author cylong
 * @version Oct 26, 2014 3:34:35 PM
 */
public interface PurchaseDataService extends CommonDataService<PurchasePO> {

	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "PurchaseData";

	/**
	 * 按照是进货单还是进货退货单返回可用ID
	 * @deprecated 每次都要判断type影响效率，分成getPurchaseID和getPurchaseBackID两个方法
	 * @param type
	 * @return 进货单或者进货退货单可用ID
	 * @author cylong
	 * @version 2014年11月28日 下午12:11:03
	 */
	public String getID(BillType type) throws RemoteException;

	/**
	 * @return 新的进货单的ID
	 * @author cylong
	 * @version 2014年12月9日 下午6:44:29
	 */
	public String getPurchaseID() throws RemoteException;

	/**
	 * @return 新的进货退货单的ID
	 * @author cylong
	 * @version 2014年12月9日 下午6:44:31
	 */
	public String getPurchaseBackID() throws RemoteException;

}
