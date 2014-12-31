package Accountbill;


import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import vo.AccountVO;
import blservice.accountblservice.AccountBLService;
import businesslogic.accountbl.AccountController;
import businesslogic.accountbl.AccountInfo;

public class TestPass {

	@Test
	public void test() throws RemoteException {
		AccountInfo info = new AccountInfo();
		info.changeMoney("账户A", 100);
		AccountBLService bl = new AccountController();
		ArrayList<AccountVO> vos = bl.show();
		for (AccountVO vo : vos) {
			System.out.println(vo.money);
		}
		
	}

}
