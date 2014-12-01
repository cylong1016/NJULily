package businesslogic.inventorybl;

import java.util.ArrayList;

import po.InventoryBillPO;
import po.SalesPO;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.Storage;
import dataservice.InventoryDataService;
import vo.InventoryBillVO;
import vo.SalesVO;
import businesslogic.approvalbl.ValueObject_Approval;
import businesslogic.common.Info;
import businesslogic.promotionbl.InventoryInfo_Promotion;
import businesslogic.recordbl.info.InventoryInfo_Record;
import businesslogic.recordbl.info.ValueObjectInfo_Record;

public class InventoryInfo extends Info<InventoryDataService> implements InventoryInfo_Promotion, ValueObjectInfo_Record<InventoryBillVO>, InventoryInfo_Record, ValueObject_Approval<InventoryBillVO>{

	private Inventory inventory;
	
	public InventoryInfo() {
		inventory = new Inventory();
	}
	
	public InventoryDataService getData() {
		return inventory.getInventoryData();
	}
	
	public ArrayList<InventoryBillVO> getGifts() {
		return inventory.show(BillType.GIFT);
	}

	/**
	 * 返回的是所有的符合条件的库存账单的ID
	 */
	public ArrayList<String> getID(String ID, String clientName, String salesman, Storage storage) {
		ArrayList<String> IDs = new ArrayList<String>();
		IDs = getID(ID, clientName, salesman, storage, BillType.GIFT);
		IDs.addAll(getID(ID, clientName, salesman, storage, BillType.OVERFLOW));
		IDs.addAll(getID(ID, clientName, salesman, storage, BillType.LOSS));
		IDs.addAll(getID(ID, clientName, salesman, storage, BillType.ALARM));
		return IDs;
	}

	/**
	 * 根据单据ID，返回一个VO
	 */
	public InventoryBillVO find(String ID) {
		InventoryBillVO vo = inventory.poToVo(getData().find(ID));
		return vo;
	}

	/**
	 * 返回需要审批的VO
	 */
	public ArrayList<InventoryBillVO> findApproval() {
		ArrayList<InventoryBillPO> POs = getData().show();
		ArrayList<InventoryBillPO> approvalPO = new ArrayList<InventoryBillPO>();
		for (InventoryBillPO po : POs) {
			if (po.getState() == BillState.APPROVALING) {
				approvalPO.add(po);
			}
		}
		ArrayList<InventoryBillVO> VOs = new ArrayList<InventoryBillVO>();
		for (InventoryBillPO po : approvalPO) {
			InventoryBillVO vo = inventory.poToVo(po);
			VOs.add(vo);
		}
		return VOs;
	}
}
