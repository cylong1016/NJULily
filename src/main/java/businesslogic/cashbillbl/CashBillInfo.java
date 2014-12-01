package businesslogic.cashbillbl;

import java.util.ArrayList;

import po.CashBillPO;
import po.PurchasePO;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.Storage;
import dataservice.cashbilldataservice.CashBillDataService;
import vo.CashBillVO;
import vo.PurchaseVO;
import businesslogic.approvalbl.ValueObject_Approval;
import businesslogic.common.Info;
import businesslogic.recordbl.info.ValueObjectInfo_Record;

public class CashBillInfo extends Info<CashBillDataService> implements ValueObjectInfo_Record<CashBillVO>, ValueObject_Approval<CashBillVO>{
	
	private CashBill cashBill;
	
	public CashBillInfo() {
		cashBill = new CashBill();
	}
	
	public CashBillDataService getData() {
		return cashBill.getCashBillData();
	}
	
	public ArrayList<String> getID(String ID, String clientName, String salesman, Storage storage) {
		ArrayList<String> IDs = new ArrayList<String>();
		IDs = getID(ID, clientName, salesman, storage, BillType.CASH);
		return IDs;
	}

	public CashBillVO find(String ID) {
		return cashBill.POToVO(getData().find(ID));
	}

	public ArrayList<CashBillVO> findApproval() {
		ArrayList<CashBillPO> POs = getData().show();
		ArrayList<CashBillPO> approvalPO = new ArrayList<CashBillPO>();
		for (CashBillPO po : POs) {
			if (po.getState() == BillState.APPROVALING) {
				approvalPO.add(po);
			}
		}
		ArrayList<CashBillVO> VOs = new ArrayList<CashBillVO>();
		for (CashBillPO po : approvalPO) {
			CashBillVO vo = cashBill.POToVO(po);
			VOs.add(vo);
		}
		return VOs;
	}
}
