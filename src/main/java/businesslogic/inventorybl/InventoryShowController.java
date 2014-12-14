package businesslogic.inventorybl;

import java.rmi.RemoteException;
import java.util.ArrayList;

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
			return inventoryShow.showAlarmDraft();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

}
