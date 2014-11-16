package Accountbill;

import businesslogic.clientbl.Client;

/**
 * 类之间协作的Client桩程序
 * @author cylong
 * @version Nov 16, 2014 4:29:32 PM
 */
public class MockClient extends Client {

	private String ID;
	private String name;
	private double receivable;

	public MockClient(String ID, String name, double receivable) {
		this.ID = ID;
		this.name = name;
		this.receivable = receivable;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getReceivable() {
		return this.receivable;
	}

	public void setReceivable(double receivable) {
		this.receivable = receivable;
	}

	public String getID() {
		return this.ID;
	}

}
