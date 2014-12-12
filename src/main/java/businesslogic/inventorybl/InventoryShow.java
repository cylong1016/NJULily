package businesslogic.inventorybl;

import java.util.ArrayList;

import po.InventoryBillPO;
import dataenum.BillState;
import dataenum.BillType;
import dataservice.inventorydataservice.InventoryDataService;
import vo.InventoryBillVO;
import blservice.inventoryblservice.InventoryShowBLService;

public class InventoryShow implements InventoryShowBLService{
	private Inventory inventory;
	private InventoryDataService inventoryData;
	
	public InventoryShow() {
		this.inventory = new Inventory();
		this.inventoryData = inventory.getInventoryData();
	}

	@Override
	public ArrayList<InventoryBillVO> showGifts() {
		return showChoose(BillType.GIFT);
	}

	@Override
	public ArrayList<InventoryBillVO> showOverFlow() {
		return showChoose(BillType.OVERFLOW);
	}

	@Override
	public ArrayList<InventoryBillVO> showLoss() {
		return showChoose(BillType.LOSS);
	}

	@Override
	public ArrayList<InventoryBillVO> showAlarm() {
		return showChoose(BillType.ALARM);
	}

	@Override
	public ArrayList<InventoryBillVO> showGiftsApproving() {
		return showChoose(BillType.GIFT, BillState.APPROVALING);
	}

	@Override
	public ArrayList<InventoryBillVO> showOverFlowApproving() {
		return showChoose(BillType.OVERFLOW, BillState.APPROVALING);
	}

	@Override
	public ArrayList<InventoryBillVO> showLossApproving() {
		return showChoose(BillType.LOSS, BillState.APPROVALING);
	}

	@Override
	public ArrayList<InventoryBillVO> showAlarmApproving() {
		return showChoose(BillType.ALARM, BillState.APPROVALING);
	}

	@Override
	public ArrayList<InventoryBillVO> showGiftsPass() {
		return showChoose(BillType.GIFT, BillState.SUCCESS);
	}

	@Override
	public ArrayList<InventoryBillVO> showOverFlowPass() {
		return showChoose(BillType.OVERFLOW, BillState.SUCCESS);
	}

	@Override
	public ArrayList<InventoryBillVO> showLossPass() {
		return showChoose(BillType.LOSS, BillState.SUCCESS);
	}

	@Override
	public ArrayList<InventoryBillVO> showAlarmPass() {
		return showChoose(BillType.ALARM, BillState.SUCCESS);
	}

	@Override
	public ArrayList<InventoryBillVO> showGiftsFailure() {
		return showChoose(BillType.GIFT, BillState.FAILURE);
	}

	@Override
	public ArrayList<InventoryBillVO> showOverFlowFailure() {
		return showChoose(BillType.OVERFLOW, BillState.FAILURE);
	}

	@Override
	public ArrayList<InventoryBillVO> showLossFailure() {
		return showChoose(BillType.LOSS, BillState.FAILURE);
	}

	@Override
	public ArrayList<InventoryBillVO> showAlarmFailure() {
		return showChoose(BillType.ALARM, BillState.FAILURE);
	}

	@Override
	public ArrayList<InventoryBillVO> showGiftsDraft() {
		// TODO 
		return showChoose(BillType.GIFT);
	}

	@Override
	public ArrayList<InventoryBillVO> showOverFlowDraft() {
		// TODO 
		return showChoose(BillType.OVERFLOW);
	}

	@Override
	public ArrayList<InventoryBillVO> showLossDraft() {
		// TODO
		return showChoose(BillType.LOSS);
	}

	@Override
	public ArrayList<InventoryBillVO> showAlarmDraft() {
		// TODO
		return showChoose(BillType.ALARM);
	}
	
	/**
	 * 显示单子
	 * @param type
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 6:11:48 PM
	 */
	private ArrayList<InventoryBillVO> show() {
		ArrayList<InventoryBillVO> VOs = new ArrayList<InventoryBillVO>();
		ArrayList<InventoryBillPO> POs = inventoryData.show();
		for(int i = 0; i < POs.size(); i++) {
			InventoryBillPO po = POs.get(i);
			InventoryBillVO vo = inventory.poToVo(po);
			VOs.add(vo);
		}
		return VOs;
	}
	
	private ArrayList<InventoryBillVO> showChoose(BillType type) {
		ArrayList<InventoryBillVO> VOs = new ArrayList<InventoryBillVO>();
 		for (InventoryBillVO vo : show()) {
			if (vo.billType == type) {
				VOs.add(vo);
			}
		}
 		return VOs;
	}
	
	private ArrayList<InventoryBillVO> showChoose(BillType type, BillState state) {
		ArrayList<InventoryBillVO> VOs = new ArrayList<InventoryBillVO>();
 		for (InventoryBillVO vo : show()) {
			if (vo.billType == type && vo.state == state) {
				VOs.add(vo);
			}
		}
 		return VOs;
	}
}
