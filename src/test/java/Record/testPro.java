package Record;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import vo.ValueObject;
import businesslogic.recordbl.BusinessProList;
import dataenum.BillType;

public class testPro {

	@Test
	public void test() throws RemoteException, MalformedURLException, NotBoundException {
//		AccountBillDataService accountBillData = (AccountBillDataService)Naming.lookup(RMIConfig.PREFIX + AccountBillDataService.NAME);
//		ArrayList<AccountBillPO> pos = accountBillData.show();
//		for (AccountBillPO po : pos) {
//			System.out.println(po.getID());
//		}
//		AccountBillInfoService accountBill = (AccountBillInfoService)Naming.lookup(RMIConfig.PREFIX+AccountBillInfoService.NAME);
//		ArrayList<String> IDs = accountBill.getAllID(BillType.EXPENSE);
//		PurchaseInfoService purInfo = (PurchaseInfoService)Naming.lookup(RMIConfig.PREFIX+PurchaseInfoService.NAME);
//		ArrayList<String> IDs = purInfo.getAllID(BillType.PURCHASE);
//		for (String id : IDs) {
//			System.out.println(id);
//		}
		BusinessProList pro = new BusinessProList(null, null);
		pro.setInfo(BillType.EXPENSE, null, null, null);
		ArrayList<ValueObject> vos = pro.getBusinessPro();
		for (ValueObject vo : vos) {
			System.out.println(vo.ID);
		}
	}
}
