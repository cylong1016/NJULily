package server.data.userdata;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dataenum.UserIdentity;
import po.UserPO;

/**
 * @author cylong
 * @version 2014年12月3日 下午2:12:17
 */
public class UserDataTest {

	
	/**
	 * @throws java.lang.Exception
	 * @author cylong
	 * @version 2014年12月3日 下午2:12:17
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 * @author cylong
	 * @version 2014年12月3日 下午2:12:17
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		UserPO po = new UserPO("1234", "cylong", "cylong11", "cylong11", "11", UserIdentity.FINANCE_MANAGER);
		UserData userData = new UserData();
		System.out.println(userData.insert(po));
	}

}
