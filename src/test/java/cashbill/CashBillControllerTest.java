package cashbill;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import businesslogic.cashbillbl.CashBillController;


/**
 * 
 * @author cylong
 * @version 2014年12月18日  上午12:21:58
 */
public class CashBillControllerTest {

	/**
	 * @throws java.lang.Exception
	 * @author cylong
	 * @version 2014年12月18日  上午12:21:58
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 * @author cylong
	 * @version 2014年12月18日  上午12:21:58
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link businesslogic.cashbillbl.CashBillController#getID()}.
	 */
	@Test
	public void testGetID() {
		System.out.println(new CashBillController().getID());
	}

}
