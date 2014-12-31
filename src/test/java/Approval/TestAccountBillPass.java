package Approval;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import vo.AccountBillVO;
import businesslogic.accountbillbl.AccountBillShow;

public class TestAccountBillPass {

	@Test
	public void test() throws RemoteException {
//		AccountBillInfo info = new AccountBillInfo();
//		ClientBLService bl = new ClientController();
//		ArrayList<ClientVO> clientVOs = bl.show();
//		for (ClientVO cvo : clientVOs) {
//			System.out.println(cvo.ID + "  " + cvo.name);
//		}
		AccountBillShow show = new AccountBillShow();
		ArrayList<AccountBillVO> vos = show.showPay();
		for (AccountBillVO vo : vos) {
			System.out.println(vo.type.value);
		}
	}

}
