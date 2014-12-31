package Accountbill;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import vo.client.ClientVO;
import blservice.clientblservice.ClientBLService;
import businesslogic.clientbl.ClientController;
import businesslogic.clientbl.ClientInfo;

public class TestChangeClient {

	@Test
	public void test() throws RemoteException {
		ClientInfo info = new ClientInfo();
		ClientBLService bl = new ClientController();
		ArrayList<ClientVO> vos = bl.show();
		ClientVO kehu = bl.findClient("KH00001");
		System.out.println(kehu.payable);
		if (vos.isEmpty() || vos == null) {
			System.out.println("Empty");
		}
		for (ClientVO vo : vos) {
			System.out.println(vo.ID);
		}
		info.changePayable("KH00001", -1000);
		ClientVO kehu1 = bl.findClient("KH00001");
		System.out.println(kehu1.payable);
	}

}
