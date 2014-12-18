package businesslogic.cashbillbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CashBillPO;
import vo.CashBillVO;
import dataenum.BillState;
import dataservice.cashbilldataservice.CashBillDataService;

public class CashBillShow {

	private CashBill cashBill;
	private CashBillDataService cashBillData;

	public CashBillShow() {
		cashBill = new CashBill();
		cashBillData = cashBill.getCashBillData();
	}

	public ArrayList<CashBillVO> show() throws RemoteException {
		ArrayList<CashBillPO> POs = cashBillData.show();
		ArrayList<CashBillVO> VOs = cashBill.billsPOToBillsVO(POs);
		return VOs;
	}

	public ArrayList<CashBillVO> showApproving() throws RemoteException {
		return showChoose(BillState.APPROVALING);
	}

	public ArrayList<CashBillVO> showPass() throws RemoteException {
		return showChoose(BillState.SUCCESS);
	}

	public ArrayList<CashBillVO> showFailure() throws RemoteException {
		return showChoose(BillState.FAILURE);
	}

	public ArrayList<CashBillVO> showDraft() throws RemoteException {
		// TODO
		return showChoose(BillState.APPROVALING);
	}

	private ArrayList<CashBillVO> showChoose(BillState state) throws RemoteException {
		ArrayList<CashBillVO> VOs = new ArrayList<CashBillVO>();
		ArrayList<CashBillVO> show = show();
		for(CashBillVO vo : show) {
			if (vo.state == state) {
				VOs.add(vo);
			}
		}
		return VOs;
	}
}
