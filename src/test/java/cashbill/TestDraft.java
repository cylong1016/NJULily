package cashbill;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import dataenum.BillState;
import po.CashBillPO;
import vo.CashBillVO;
import businesslogic.cashbillbl.CashBill;
import businesslogic.cashbillbl.CashBillShow;

public class TestDraft {

	@Test
	public void test() throws RemoteException {
		CashBillShow show = new CashBillShow();
		ArrayList<CashBillVO> vos = show.showApproving();
		for (CashBillVO vo : vos) {
			System.out.println(vo.ID + " " + vo.state.value);
		}
		CashBill cb = new CashBill();
		CashBillPO po = cb.getCashBillData().find("XJFYD-20150101-00003");
		System.out.println(po.getState().value);
		po.setState(BillState.DRAFT);
		cb.getCashBillData().update(po);
		System.out.println(po.getState().value);
	}

}
