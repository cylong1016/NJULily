package Record;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import vo.AccountBillVO;
import vo.ValueObject;
import businesslogic.recordbl.BusinessProList;
import config.RMIConfig;
import dataenum.BillType;
import dataservice.purchasedataservice.PurchaseInfoService;

public class testPro {

	@Test
	public void test() throws RemoteException, MalformedURLException, NotBoundException {
		BusinessProList pro = new BusinessProList(null, null);
		pro.setInfo(BillType.EXPENSE, null, null, null);
		ArrayList<ValueObject> vos = pro.getBusinessPro();
		for (ValueObject vo : vos) {
			System.out.println(vo.ID);
		}
	}
}
