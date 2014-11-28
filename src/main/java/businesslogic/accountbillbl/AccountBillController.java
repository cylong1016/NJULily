package businesslogic.accountbillbl;

import java.util.HashMap;

import message.ResultMessage;
import dataenum.BillType;
import blservice.accountbillblservice.AccountBillBLService;

/**
 * 实现AccountBillBLService接口，并通过调用AccountBill来完成收款单和付款单的创建
 * @see blservice.accountbillblservice.AccountBillBLService
 * @see businesslogic.accountbillbl.AccountBill
 * @author cylong
 * @version Nov 16, 2014 3:27:36 PM
 */
public class AccountBillController implements AccountBillBLService {

	private AccountBill accountBill;

	/**
	 * @see blservice.accountbillblservice.AccountBillBLService#getID(dataenum.BillType)
	 */
	public String getID(BillType type) {
		return accountBill.getID(type);
	}

	/**
	 * @see blservice.accountbillblservice.AccountBillBLService#getAllClients()
	 */
	public HashMap<String, String> getAllClients() {
		return accountBill.getAllClients();
	}

	/**
	 * @see blservice.accountbillblservice.AccountBillBLService#addClient(java.lang.String, java.lang.String)
	 */
	public ResultMessage addClient(String clientID, String clientName) {
		return accountBill.addClient(clientID, clientName);
	}

	/**
	 * @see blservice.accountbillblservice.AccountBillBLService#getAllAccountName()
	 */
	public HashMap<String, String> getAllAccountName() {
		return accountBill.getAllAccountName();
	}

	/**
	 * @see blservice.accountbillblservice.AccountBillBLService#addBillItem(java.lang.String, int, java.lang.String)
	 */
	public ResultMessage addBillItem(String accountName, int money, String remark) {
		return accountBill.addBillItem(accountName, money, remark);
	}

	/**
	 * @see blservice.accountbillblservice.AccountBillBLService#getSumMoney()
	 */
	public double getSumMoney() {
		return accountBill.getSumMoney();
	}

	/**
	 * @see blservice.accountbillblservice.AccountBillBLService#addExpenses()
	 */
	public ResultMessage addExpenses() {
		return accountBill.addExpenses();
	}

	/**
	 * @see blservice.accountbillblservice.AccountBillBLService#addPay()
	 */
	public ResultMessage addPay() {
		return accountBill.addPay();
	}

	/**
	 * @see blservice.accountbillblservice.AccountBillBLService#submit()
	 */
	public ResultMessage submit() {
		return accountBill.submit();
	}
}
