package cashbill;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import vo.CashBillVO;
import businesslogic.cashbillbl.CashBillShow;

/**
 * @author cylong
 * @version 2014年12月18日 下午10:05:39
 */
public class CashBillShowTest {

	/**
	 * @throws java.lang.Exception
	 * @author cylong
	 * @version 2014年12月18日 下午10:05:39
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 * @author cylong
	 * @version 2014年12月18日 下午10:05:39
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link businesslogic.cashbillbl.CashBillShow#show()}.
	 * @throws RemoteException 
	 */
	@Test
	public void testShow() throws RemoteException {
		ArrayList<CashBillVO> VOs = new CashBillShow().show();
		for(CashBillVO vo : VOs) {
			System.out.println(vo.ID);
		}
	}

}
