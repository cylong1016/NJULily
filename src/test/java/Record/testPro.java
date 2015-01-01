package Record;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import vo.AccountBillVO;
import businesslogic.accountbillbl.AccountBillShow;
import config.RMIConfig;
import dataservice.accountbilldataservice.AccountBillDataService;

public class testPro {

	@Test
	public void test() throws RemoteException, MalformedURLException, NotBoundException {
		AccountBillDataService accountBillData = (AccountBillDataService)Naming.lookup(RMIConfig.PREFIX + AccountBillDataService.NAME);
//		ArrayList<AccountBillPO> pos = accountBillData.show();
//		for (AccountBillPO po : pos) {
//			System.out.println(po.getID());
//		}
//		AccountBillInfoService accountBill = (AccountBillInfoService)Naming.lookup(RMIConfig.PREFIX+AccountBillInfoService.NAME);
//		ArrayList<String> IDs = accountBill.getAllID(BillType.EXPENSE);
//		PurchaseInfoService purInfo = (PurchaseInfoService)Naming.lookup(RMIConfig.PREFIX+PurchaseInfoService.NAME);
		AccountBillShow show = new AccountBillShow();
		ArrayList<AccountBillVO> pos = show.showExpense();
		ArrayList<String> IDs = new ArrayList<String>();
		for (AccountBillVO id : pos) {
			System.out.println(id.ID);
			IDs.add(id.ID);
		}
		ArrayList<AccountBillVO> vos = show.showPay();
		for (AccountBillVO id : vos) {
			System.out.println(id.ID);
			IDs.add(id.ID);
		}	
		for (String id : IDs) {
			System.out.println(id);
			accountBillData.find(id);
		}
//		BusinessProList pro = new BusinessProList(null, null);
//		pro.setInfo(BillType.PAY, null, null, null);
//		ArrayList<ValueObject> vos = pro.getBusinessPro();
//		for (ValueObject vo : vos) {
//			System.out.println(vo.ID);
//		}
	}
}
