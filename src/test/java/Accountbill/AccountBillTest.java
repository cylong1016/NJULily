package Accountbill;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import businesslogic.accountbillbl.AccountBill;

/**
 * @author cylong
 * @version Nov 16, 2014 4:45:49 PM
 */
public class AccountBillTest {

	AccountBill accountBill;
	MockAccount account;
	MockClient client;

	public AccountBillTest() {
		super();
		accountBill = new AccountBill();
		account = new MockAccount("1", "账户1", 10000);
		client = new MockClient("1", "客户1", 5000);
	}

	/**
	 * Test method for
	 * {@link businesslogic.accountbillbl.AccountBill#addBillItem(java.lang.String, int, java.lang.String)}.
	 */
	@Test
	public void testAddBillItem() {
	}

	/**
	 * Test method for {@link businesslogic.accountbillbl.AccountBill#getSumMoney()}.
	 */
	@Test
	public void testGetSumMoney() {
		assertEquals(0, accountBill.getSumMoney(), 0);
	}

}
