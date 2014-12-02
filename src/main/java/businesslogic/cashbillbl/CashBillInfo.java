package businesslogic.cashbillbl;

import java.util.ArrayList;

import message.ResultMessage;
import po.CashBillPO;
import po.CashItemPO;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.Storage;
import dataservice.TableInfoService;
import dataservice.cashbilldataservice.CashBillDataService;
import vo.CashBillVO;
import vo.CashItemVO;
import businesslogic.approvalbl.info.CashBillInfo_Approval;
import businesslogic.approvalbl.info.ValueObject_Approval;
import businesslogic.common.Info;
import businesslogic.recordbl.info.ValueObjectInfo_Record;

public class CashBillInfo extends Info<CashBillPO> implements ValueObjectInfo_Record<CashBillVO>, ValueObject_Approval<CashBillVO>, CashBillInfo_Approval{
	
	private CashBill cashBill;
	
	public CashBillInfo() {
		cashBill = new CashBill();
	}
	
	public TableInfoService<CashBillPO> getData() {
		return cashBill.getCashBillData().getInfo();
	}
	
	private CashBillDataService getCashBillData() {
		return cashBill.getCashBillData();
	}
	
	public ArrayList<String> getID(String ID, String clientName, String salesman, Storage storage) {
		ArrayList<String> IDs = new ArrayList<String>();
		IDs = getID(ID, clientName, salesman, storage, BillType.CASH);
		return IDs;
	}

	public CashBillVO find(String ID) {
		return cashBill.POToVO(getCashBillData().find(ID));
	}

	public ArrayList<CashBillVO> findApproval() {
		ArrayList<CashBillPO> POs = getCashBillData().show();
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

	public ResultMessage update(CashBillVO vo) {
		String ID = vo.ID;
		String user = vo.user;
		String account = vo.account;
		double total = vo.total;
		ArrayList<CashItemPO> bills = itemsVOtoPO(vo.bills);
		CashBillPO po = new CashBillPO(ID, user, account, bills, total);
		return getCashBillData().update(po);
	}
	
	private ArrayList<CashItemPO> itemsVOtoPO(ArrayList<CashItemVO> VOs) {
		ArrayList<CashItemPO> POs = new ArrayList<CashItemPO>();
		for (CashItemVO vo : VOs) {
			String name = vo.name;
			double money = vo.money;
			String remark = vo.remark;
			CashItemPO po = new CashItemPO(name, money, remark);
			POs.add(po);
		}
		return POs;
	}
}
