package Accountbill;

import java.util.HashMap;

import businesslogic.accountbl.Account;

/**
 * 类之间协作的Account桩程序
 * @author cylong
 * @version Nov 16, 2014 4:42:43 PM
 */
public class MockAccount extends Account {

	private String ID;
	private String name;
	private double money;

	public MockAccount(String iD, String name, double money) {
		super();
		this.ID = iD;
		this.name = name;
		this.money = money;
	}

	/**
	 * @see businesslogic.accountbillbl.AccountInfo_AccountBill#getAllAccounts()
	 */
	public HashMap<String, String> getAllAccountName() {
		return null;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMoney() {
		return this.money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getID() {
		return this.ID;
	}

}
