package businesslogic.inventorybl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.InventoryBillPO;
import vo.InventoryBillVO;
import dataenum.BillState;
import dataenum.BillType;
import dataservice.inventorydataservice.InventoryDataService;

public class InventoryShow {

	private InventoryDataService inventoryData;

	public InventoryShow() {
		Inventory inventory = new Inventory();
		this.inventoryData = inventory.getInventoryData();
	}

	public ArrayList<InventoryBillVO> showGifts() throws RemoteException {
		return showChoose(BillType.GIFT);
	}

	public ArrayList<InventoryBillVO> showOverFlow() throws RemoteException {
		return showChoose(BillType.OVERFLOW);
	}

	public ArrayList<InventoryBillVO> showLoss() throws RemoteException {
		return showChoose(BillType.LOSS);
	}

	public ArrayList<InventoryBillVO> showAlarm() throws RemoteException {
		return showChoose(BillType.ALARM);
	}

	public ArrayList<InventoryBillVO> showGiftsApproving() throws RemoteException {
		return showChoose(BillType.GIFT, BillState.APPROVALING);
	}

	public ArrayList<InventoryBillVO> showOverFlowApproving() throws RemoteException {
		return showChoose(BillType.OVERFLOW, BillState.APPROVALING);
	}

	public ArrayList<InventoryBillVO> showLossApproving() throws RemoteException {
		return showChoose(BillType.LOSS, BillState.APPROVALING);
	}

	public ArrayList<InventoryBillVO> showAlarmApproving() throws RemoteException {
		return showChoose(BillType.ALARM, BillState.APPROVALING);
	}

	public ArrayList<InventoryBillVO> showGiftsPass() throws RemoteException {
		return showChoose(BillType.GIFT, BillState.SUCCESS);
	}

	public ArrayList<InventoryBillVO> showOverFlowPass() throws RemoteException {
		return showChoose(BillType.OVERFLOW, BillState.SUCCESS);
	}

	public ArrayList<InventoryBillVO> showLossPass() throws RemoteException {
		return showChoose(BillType.LOSS, BillState.SUCCESS);
	}

	public ArrayList<InventoryBillVO> showAlarmPass() throws RemoteException {
		return showChoose(BillType.ALARM, BillState.SUCCESS);
	}

	public ArrayList<InventoryBillVO> showGiftsFailure() throws RemoteException {
		return showChoose(BillType.GIFT, BillState.FAILURE);
	}

	public ArrayList<InventoryBillVO> showOverFlowFailure() throws RemoteException {
		return showChoose(BillType.OVERFLOW, BillState.FAILURE);
	}

	public ArrayList<InventoryBillVO> showLossFailure() throws RemoteException {
		return showChoose(BillType.LOSS, BillState.FAILURE);
	}

	public ArrayList<InventoryBillVO> showAlarmFailure() throws RemoteException {
		return showChoose(BillType.ALARM, BillState.FAILURE);
	}

	public ArrayList<InventoryBillVO> showGiftsDraft() throws RemoteException {
		return showChoose(BillType.GIFT, BillState.DRAFT);
	}

	public ArrayList<InventoryBillVO> showOverFlowDraft() throws RemoteException {
		return showChoose(BillType.OVERFLOW, BillState.DRAFT);
	}

	public ArrayList<InventoryBillVO> showLossDraft() throws RemoteException {
		return showChoose(BillType.LOSS, BillState.DRAFT);
	}

	public ArrayList<InventoryBillVO> showAlarmDraft() throws RemoteException {
		return showChoose(BillType.ALARM, BillState.DRAFT);
	}

	/**
	 * 显示单子
	 * @param type
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 6:11:48 PM
	 * @throws RemoteException
	 */
	private ArrayList<InventoryBillVO> show() throws RemoteException {
		ArrayList<InventoryBillVO> VOs = new ArrayList<InventoryBillVO>();
		ArrayList<InventoryBillPO> POs = inventoryData.show();
		for(int i = 0; i < POs.size(); i++) {
			InventoryBillPO po = POs.get(i);
			InventoryBillVO vo = InventoryTrans.poToVo(po);
			VOs.add(vo);
		}
		return VOs;
	}

	private ArrayList<InventoryBillVO> showChoose(BillType type) throws RemoteException {
		ArrayList<InventoryBillVO> VOs = new ArrayList<InventoryBillVO>();
		for(InventoryBillVO vo : show()) {
			if (vo.billType == type) {
				VOs.add(vo);
			}
		}
		return VOs;
	}

	private ArrayList<InventoryBillVO> showChoose(BillType type, BillState state) throws RemoteException {
		ArrayList<InventoryBillVO> VOs = new ArrayList<InventoryBillVO>();
		for(InventoryBillVO vo : show()) {
			if (vo.billType == type && vo.state == state) {
				VOs.add(vo);
			}
		}
		return VOs;
	}
}
