package businesslogic.accountbillbl;

import java.util.HashMap;

import message.ResultMessage;
import dataenum.BillType;
import businesslogicservice.AccountBillBLService;

/**
 * 实现AccountBillBLService接口，并通过调用AccountBill来完成收款单和付款单的创建
 * @see businesslogicservice.AccountBillBLService
 * @see businesslogic.accountbillbl.AccountBill
 * @author cylong
 * @version Nov 16, 2014 3:27:36 PM
 */
public class AccountBillController implements AccountBillBLService {

	private AccountBill accountBill;

	/**
	 * @see businesslogicservice.AccountBillBLService#getID(dataenum.BillType)
	 */
	public String getID(BillType type) {
		return accountBill.getID(type);
	}

	/**
	 * @see businesslogicservice.AccountBillBLService#getAllClients()
	 */
	public HashMap<String, String> getAllClients() {
		return accountBill.getAllClients();
	}

	/**
	 * @see businesslogicservice.AccountBillBLService#addClient(java.lang.String, java.lang.String)
	 */
	public ResultMessage addClient(String clientID, String clientName) {
		return accountBill.addClient(clientID, clientName);
	}

	/**
	 * @see businesslogicservice.AccountBillBLService#getAllAccountName()
	 */
	public HashMap<String, String> getAllAccountName() {
		return accountBill.getAllAccountName();
	}

	/**
	 * @see businesslogicservice.AccountBillBLService#addBillItem(java.lang.String, int, java.lang.String)
	 */
	public ResultMessage addBillItem(String accountName, int money, String remark) {
		return accountBill.addBillItem(accountName, money, remark);
	}

	/**
	 * @see businesslogicservice.AccountBillBLService#getSumMoney()
	 */
	public double getSumMoney() {
		return accountBill.getSumMoney();
	}

	/**
	 * @see businesslogicservice.AccountBillBLService#addExpenses()
	 */
	public ResultMessage addExpenses() {
		return accountBill.addExpenses();
	}

	/**
	 * @see businesslogicservice.AccountBillBLService#addPay()
	 */
	public ResultMessage addPay() {
		return accountBill.addPay();
	}

	/**
	 * @see businesslogicservice.AccountBillBLService#submit()
	 */
	public ResultMessage submit() {
		return accountBill.submit();
	}
}
