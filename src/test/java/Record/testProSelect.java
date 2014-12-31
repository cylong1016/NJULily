package Record;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import po.AccountBillPO;
import vo.ValueObject;
import businesslogic.accountbillbl.AccountBill;
import businesslogic.recordbl.BusinessProList;
import dataenum.BillType;

public class testProSelect {

	@Test
	public void test() throws RemoteException {
		BusinessProList pro = new BusinessProList(null, null);
		pro.setInfo(BillType.PAY, null, "jingli", null);
		ArrayList<ValueObject> vos = pro.getBusinessPro();
		String ID = null;
		for (ValueObject vo : vos) {
			System.out.println(vo.ID);
			ID = vo.ID;
		}
		
		AccountBill sale = new AccountBill();
		AccountBillPO po = sale.getAccountBillData().find(ID);
//		System.out.println(po.getUsername());
		
		
	}

}
