package Record;


import java.rmi.RemoteException;

import org.junit.Test;

import businesslogic.recordbl.BusinessStateList;

public class testBussinessState {

	@Test
	public void test() throws RemoteException {
		BusinessStateList businessStateList = new BusinessStateList("20141211", "20141220");
		System.out.println(businessStateList.getBusinessState().saleIncome);
		System.out.println(businessStateList.getBusinessState().saleCost);
	}

}
