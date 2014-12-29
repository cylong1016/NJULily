package Record;

import java.rmi.RemoteException;

import org.junit.Test;

import businesslogic.recordbl.BusinessStateList;

public class testBussinessState {

	@Test
	public void test() throws RemoteException {
		new BusinessStateList("20141211", "20141220");
	}

}
