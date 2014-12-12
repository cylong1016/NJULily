package businesslogic.cashbillbl;

import java.util.ArrayList;

import blservice.cashbillblservice.CashBillShowBLService;
import po.CashBillPO;
import vo.CashBillVO;
import dataenum.BillState;
import dataservice.cashbilldataservice.CashBillDataService;

public class CashBillShow implements CashBillShowBLService{
	
	private CashBill cashBill;
	private CashBillDataService cashBillData;
	
	public CashBillShow() {
		cashBill = new CashBill();
		cashBillData = cashBill.getCashBillData();
	}

	@Override
	public ArrayList<CashBillVO> show() {
		ArrayList<CashBillVO> VOs = new ArrayList<CashBillVO>();
		for(CashBillPO po : cashBillData.show()) {
			CashBillVO vo = cashBill.POToVO(po);
			VOs.add(vo);
		}
		return VOs;
	}

	@Override
	public ArrayList<CashBillVO> showApproving() {
		return showChoose(BillState.APPROVALING);
	}

	@Override
	public ArrayList<CashBillVO> showPass() {
		return showChoose(BillState.SUCCESS);
	}

	@Override
	public ArrayList<CashBillVO> showFailure() {
		return showChoose(BillState.FAILURE);
	}

	@Override
	public ArrayList<CashBillVO> showDraft() {
		// TODO
		return showChoose(BillState.APPROVALING);
	}
	
	private ArrayList<CashBillVO> showChoose(BillState state) {
		ArrayList<CashBillVO> VOs = new ArrayList<CashBillVO>();
		for (CashBillVO vo : show()) {
			if (vo.state == state) {
				VOs.add(vo);
			}
		}
		return VOs;
	}
}
