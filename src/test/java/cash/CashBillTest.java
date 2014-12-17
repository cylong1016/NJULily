package cash;

import java.rmi.RemoteException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import businesslogic.cashbillbl.CashBill;


/**
 * 
 * @author cylong
 * @version 2014年12月18日  上午12:09:52
 */
public class CashBillTest {

	/**
	 * @throws java.lang.Exception
	 * @author cylong
	 * @version 2014年12月18日  上午12:09:52
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 * @author cylong
	 * @version 2014年12月18日  上午12:09:52
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link businesslogic.cashbillbl.CashBill#getID()}.
	 * @throws RemoteException 
	 */
	@Test
	public void testGetID() throws RemoteException {
		System.out.println(new CashBill().getID());
	}

}
