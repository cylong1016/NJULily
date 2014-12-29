package Record;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import config.RMIConfig;
import dataenum.BillType;
import dataservice.purchasedataservice.PurchaseInfoService;

public class testPro {

	@Test
	public void test() throws RemoteException, MalformedURLException, NotBoundException {
		
		PurchaseInfoService purInfo = (PurchaseInfoService)Naming.lookup(RMIConfig.PREFIX+PurchaseInfoService.NAME);
		ArrayList<String> IDs = purInfo.getAllID(BillType.PURCHASE);
//		Date begin = DateOperate.changeBeginDate("20141220");
//		Date end = DateOperate.changeEndDate("20141229");
//		ValueObjectInfo_Record<?> info = new PurchaseInfo(begin, end);
//		ArrayList<String> IDs = info.purIDs;
//		BusinessProList bl = new BusinessProList("20141220", "20141229");
//		bl.setInfo(BillType.PURCHASE, null, null, null);
//		ArrayList<ValueObject> vos = bl.getBusinessPro();
//		for(ValueObject vo : vos)
//			System.out.println(vo.ID);
//	}
		for(String ID : IDs)
			System.out.println(ID);
	}
}
