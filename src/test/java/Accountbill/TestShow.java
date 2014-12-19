package Accountbill;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import vo.AccountBillVO;
import businesslogic.accountbillbl.AccountBillShow;

public class TestShow {

	@Test
	public void test() throws RemoteException {
		AccountBillShow show = new AccountBillShow();
		ArrayList<AccountBillVO> vo = show.showExpense();
		if (vo.isEmpty()) {
			System.out.println("isEmpty");
		}
		else {
			System.out.println(vo.get(0).state);
		}
	}

}
