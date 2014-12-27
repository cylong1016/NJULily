package businesslogic.inventorybl;

import java.rmi.RemoteException;

import log.LogMsgController;
import vo.InventoryBillVO;
import vo.InventoryCheckVO;
import vo.InventoryViewVO;
import blservice.inventoryblservice.InventoryBLService;

/**
 * @see blservice.inventoryblservice.InventoryBLService
 * @author cylong
 * @version 2014年12月14日 下午3:36:35
 */
public class InventoryController implements InventoryBLService {

	private Inventory inventory;

	/**
	 * @author cylong
	 * @version 2014年12月14日 下午3:42:07
	 */
	public InventoryController() {
		inventory = new Inventory();
	}

	/**
	 * @see blservice.inventoryblservice.InventoryBLService#viewInventory(java.lang.String, java.lang.String)
	 */
	@Override
	public InventoryViewVO viewInventory(String beginDate, String endDate) {
		try {
			LogMsgController.addLog("进行库存查看 [开始时间=" + beginDate + ", 结束时间=" + endDate + "]");
			return inventory.viewInventory(beginDate, endDate);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.inventoryblservice.InventoryBLService#checkRecord()
	 */
	@Override
	public InventoryCheckVO checkRecord() {
		try {
			LogMsgController.addLog("进行库存盘点");
			return inventory.checkRecord();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.inventoryblservice.InventoryBLService#getGiftID()
	 */
	@Override
	public String getGiftID() {
		try {
			return inventory.getGiftID();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.inventoryblservice.InventoryBLService#getOverFlowID()
	 */
	@Override
	public String getOverFlowID() {
		try {
			return inventory.getOverFlowID();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.inventoryblservice.InventoryBLService#getLossID()
	 */
	@Override
	public String getLossID() {
		try {
			return inventory.getLossID();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.inventoryblservice.InventoryBLService#getAlarmID()
	 */
	@Override
	public String getAlarmID() {
		try {
			return inventory.getAlarmID();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.inventoryblservice.InventoryBLService#addCommodity(java.lang.String, int)
	 */
	@Override
	public void addCommodity(String ID, int number) {
		try {
			inventory.addCommodity(ID, number);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see blservice.inventoryblservice.InventoryBLService#submit(java.lang.String)
	 */
	@Override
	public InventoryBillVO submit(String remark) {
		try {
			InventoryBillVO vo = inventory.submit(remark);
			if (vo != null) {
				LogMsgController.addLog("提交库存单据 " + vo.toString());
			}
			return vo;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.inventoryblservice.InventoryBLService#save(java.lang.String)
	 */
	@Override
	public InventoryBillVO save(String remark) {
		try {
			InventoryBillVO vo = inventory.submit(remark);
			if (vo != null) {
				LogMsgController.addLog("保存库存单据为草稿状态 " + vo.toString());
			}
			return inventory.save(remark);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

}
