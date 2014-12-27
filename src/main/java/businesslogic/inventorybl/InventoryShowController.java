package businesslogic.inventorybl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import log.LogController;
import vo.InventoryBillVO;
import blservice.inventoryblservice.InventoryShowBLService;

/**
 * @see blservice.inventoryblservice.InventoryShowBLService
 * @author cylong
 * @version 2014年12月14日 下午3:45:47
 */
public class InventoryShowController implements InventoryShowBLService {

	private InventoryShow inventoryShow;

	/**
	 * @author cylong
	 * @version 2014年12月14日 下午3:48:42
	 */
	public InventoryShowController() {
		inventoryShow = new InventoryShow();
	}

	/**
	 * @see blservice.inventoryblservice.InventoryShowBLService#showGifts()
	 */
	@Override
	public ArrayList<InventoryBillVO> showGifts() {
		try {
			LogController.addLog("查看所有赠品单");
			return inventoryShow.showGifts();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.inventoryblservice.InventoryShowBLService#showOverFlow()
	 */
	@Override
	public ArrayList<InventoryBillVO> showOverFlow() {
		try {
			LogController.addLog("查看所有报溢单");
			return inventoryShow.showOverFlow();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.inventoryblservice.InventoryShowBLService#showLoss()
	 */
	@Override
	public ArrayList<InventoryBillVO> showLoss() {
		try {
			LogController.addLog("查看所有报损单");
			return inventoryShow.showLoss();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.inventoryblservice.InventoryShowBLService#showAlarm()
	 */
	@Override
	public ArrayList<InventoryBillVO> showAlarm() {
		try {
			LogController.addLog("查看所有报警单");
			return inventoryShow.showAlarm();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.inventoryblservice.InventoryShowBLService#showGiftsApproving()
	 */
	@Override
	public ArrayList<InventoryBillVO> showGiftsApproving() {
		try {
			LogController.addLog("查看所有等待审批的赠品单");
			return inventoryShow.showGiftsApproving();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.inventoryblservice.InventoryShowBLService#showOverFlowApproving()
	 */
	@Override
	public ArrayList<InventoryBillVO> showOverFlowApproving() {
		try {
			LogController.addLog("查看所有等待审批的报溢单");
			return inventoryShow.showOverFlowApproving();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.inventoryblservice.InventoryShowBLService#showLossApproving()
	 */
	@Override
	public ArrayList<InventoryBillVO> showLossApproving() {
		try {
			LogController.addLog("查看所有等待审批的报损单");
			return inventoryShow.showLossApproving();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.inventoryblservice.InventoryShowBLService#showAlarmApproving()
	 */
	@Override
	public ArrayList<InventoryBillVO> showAlarmApproving() {
		try {
			LogController.addLog("查看所有等待审批的报警单");
			return inventoryShow.showAlarmApproving();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.inventoryblservice.InventoryShowBLService#showGiftsPass()
	 */
	@Override
	public ArrayList<InventoryBillVO> showGiftsPass() {
		try {
			LogController.addLog("查看所有通过审批的赠品单");
			return inventoryShow.showGiftsPass();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.inventoryblservice.InventoryShowBLService#showOverFlowPass()
	 */
	@Override
	public ArrayList<InventoryBillVO> showOverFlowPass() {
		try {
			LogController.addLog("查看所有通过审批的报溢单");
			return inventoryShow.showOverFlowPass();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.inventoryblservice.InventoryShowBLService#showLossPass()
	 */
	@Override
	public ArrayList<InventoryBillVO> showLossPass() {
		try {
			LogController.addLog("查看所有通过审批的报损单");
			return inventoryShow.showLossPass();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.inventoryblservice.InventoryShowBLService#showAlarmPass()
	 */
	@Override
	public ArrayList<InventoryBillVO> showAlarmPass() {
		try {
			LogController.addLog("查看所有通过审批的报警单");
			return inventoryShow.showAlarmPass();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.inventoryblservice.InventoryShowBLService#showGiftsFailure()
	 */
	@Override
	public ArrayList<InventoryBillVO> showGiftsFailure() {
		try {
			LogController.addLog("查看所有审批失败的赠品单");
			return inventoryShow.showGiftsFailure();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.inventoryblservice.InventoryShowBLService#showOverFlowFailure()
	 */
	@Override
	public ArrayList<InventoryBillVO> showOverFlowFailure() {
		try {
			LogController.addLog("查看所有审批失败的报溢单");
			return inventoryShow.showOverFlowFailure();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.inventoryblservice.InventoryShowBLService#showLossFailure()
	 */
	@Override
	public ArrayList<InventoryBillVO> showLossFailure() {
		try {
			LogController.addLog("查看所有审批失败的报损单");
			return inventoryShow.showLossFailure();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.inventoryblservice.InventoryShowBLService#showAlarmFailure()
	 */
	@Override
	public ArrayList<InventoryBillVO> showAlarmFailure() {
		try {
			LogController.addLog("查看所有审批失败的报警单");
			return inventoryShow.showAlarmFailure();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.inventoryblservice.InventoryShowBLService#showGiftsDraft()
	 */
	@Override
	public ArrayList<InventoryBillVO> showGiftsDraft() {
		try {
			LogController.addLog("查看所有草稿状态的赠品单");
			return inventoryShow.showGiftsDraft();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.inventoryblservice.InventoryShowBLService#showOverFlowDraft()
	 */
	@Override
	public ArrayList<InventoryBillVO> showOverFlowDraft() {
		try {
			LogController.addLog("查看所有草稿状态的报溢单");
			return inventoryShow.showOverFlowDraft();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.inventoryblservice.InventoryShowBLService#showLossDraft()
	 */
	@Override
	public ArrayList<InventoryBillVO> showLossDraft() {
		try {
			LogController.addLog("查看所有草稿状态的报损单");
			return inventoryShow.showLossDraft();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.inventoryblservice.InventoryShowBLService#showAlarmDraft()
	 */
	@Override
	public ArrayList<InventoryBillVO> showAlarmDraft() {
		try {
			LogController.addLog("查看所有草稿状态的报警单");
			return inventoryShow.showAlarmDraft();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

}
