package Purchase;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import vo.ValueObject;
import businesslogic.recordbl.BusinessProList;

public class TestPro {

	@Test
	public void test() throws MalformedURLException, RemoteException, NotBoundException {
//		
//		Date begin = DateOperate.changeBeginDate("20141221");
//		Date end = DateOperate.changeEndDate("20141230");
//		PurchaseInfo info = new PurchaseInfo(begin, end);
//		ArrayList<String> purIDs = info.purIDs;
//		for (String id: purIDs) {
//			System.out.println(id);
//		}
		BusinessProList bl = new BusinessProList("20141221", "20141230");
		bl.setInfo(null, null, null, null);
		ArrayList<vo.ValueObject> vos = bl.getBusinessPro();
		for (ValueObject vo : vos) {
			System.out.println(vo.ID);
		}
	}

}
