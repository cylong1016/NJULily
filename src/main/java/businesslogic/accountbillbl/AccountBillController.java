package businesslogic.accountbillbl;

import java.util.HashMap;

import message.ResultMessage;
import vo.AccountBillItemVO;
import blservice.accountbillblservice.AccountBillBLService;
import dataenum.BillType;

/**
 * 实现AccountBillBLService接口，并通过调用AccountBill来完成收款单和付款单的创建查看
 * @see blservice.accountbillblservice.AccountBillBLService
 * @see businesslogic.accountbillbl.AccountBill
 * @author cylong
 * @version Nov 16, 2014 3:27:36 PM
 */
public class AccountBillController implements AccountBillBLService {

	private AccountBill accountBill;

	public AccountBillController() {
		accountBill = new AccountBill();
	}

	/**
	 * @see blservice.accountbillblservice.AccountBillBLService#getID(dataenum.BillType)
	 */
	@Override
	public String getID(BillType type) {
		return accountBill.getID(type);
	}

	/**
	 * @see blservice.accountbillblservice.AccountBillBLService#getAllClients()
	 */
	@Override
	public HashMap<String, String> getAllClients() {
		return accountBill.getAllClients();
	}

	/**
	 * @see blservice.accountbillblservice.AccountBillBLService#getAllAccounts()
	 */
	@Override
	public HashMap<String, String> getAllAccounts() {
		return accountBill.getAllAccounts();
	}

	/**
	 * @see blservice.accountbillblservice.AccountBillBLService#addBillItem(vo.AccountBillItemVO)
	 */
	@Override
	public ResultMessage addBillItem(AccountBillItemVO vo) {
		return accountBill.addBillItem(vo);
	}

	/**
	 * @see blservice.accountbillblservice.AccountBillBLService#getSumMoney()
	 */
	@Override
	public double getSumMoney() {
		return accountBill.getSumMoney();
	}

	/**
	 * @see blservice.accountbillblservice.AccountBillBLService#addExpenses(java.lang.String)
	 */
	@Override
	public ResultMessage addExpenses(String clientID) {
		return accountBill.addExpenses(clientID);
	}

	/**
	 * @see blservice.accountbillblservice.AccountBillBLService#addPay(java.lang.String)
	 */
	@Override
	public ResultMessage addPay(String clientID) {
		return accountBill.addPay(clientID);
	}

	/**
	 * @see blservice.accountbillblservice.AccountBillBLService#submit()
	 */
	@Override
	public ResultMessage submit() {
		return accountBill.submit();
	}

	/**
	 * @see blservice.accountbillblservice.AccountBillBLService#save()
	 */
	@Override
	public ResultMessage save() {
		return accountBill.save();
	}
}
