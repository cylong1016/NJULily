package businesslogic.accountbillbl;

import java.rmi.RemoteException;
import java.util.HashMap;

import log.LogMsgController;
import vo.AccountBillItemVO;
import vo.AccountBillVO;
import blservice.accountbillblservice.AccountBillBLService;

/**
 * @see blservice.accountbillblservice.AccountBillBLService
 * @author cylong
 * @version 2014年12月14日 上午8:51:44
 */
public class AccountBillController implements AccountBillBLService {

	private AccountBill accountBill;

	public AccountBillController() {
		accountBill = new AccountBill();
	}

	/**
	 * @see blservice.accountbillblservice.AccountBillBLService#getPayID()
	 */
	@Override
	public String getPayID() {
		try {
			return accountBill.getPayID();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.accountbillblservice.AccountBillBLService#getExpenseID()
	 */
	@Override
	public String getExpenseID() {
		try {
			return accountBill.getExpenseID();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.accountbillblservice.AccountBillBLService#find(java.lang.String)
	 */
	@Override
	public AccountBillVO find(String ID) {
		try {
			LogMsgController.addLog("查看收款（付款）单 [单据ID=" + ID + "]");
			return accountBill.find(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.accountbillblservice.AccountBillBLService#getAllClients()
	 */
	@Override
	public HashMap<String, String> getAllClients() {
		try {
			return accountBill.getAllClients();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @throws RemoteException
	 * @see blservice.accountbillblservice.AccountBillBLService#getAllAccounts()
	 */
	@Override
	public HashMap<String, String> getAllAccounts() {
		try {
			return accountBill.getAllAccounts();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.accountbillblservice.AccountBillBLService#addBillItem(vo.AccountBillItemVO)
	 */
	@Override
	public void addBillItem(AccountBillItemVO vo) {
		accountBill.addBillItem(vo);
	}

	/**
	 * @see blservice.accountbillblservice.AccountBillBLService#getSumMoney()
	 */
	@Override
	public double getSumMoney() {
		return accountBill.getSumMoney();
	}

	/**
	 * @see blservice.accountbillblservice.AccountBillBLService#addAccountBill(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public void addAccountBill(String clientID, String clientName) {
		accountBill.addAccountBill(clientID, clientName);
	}

	/**
	 * @see blservice.accountbillblservice.AccountBillBLService#submit()
	 */
	@Override
	public AccountBillVO submit() {
		try {
			AccountBillVO bill = accountBill.submit();
			if(bill != null) {
				LogMsgController.addLog("提交收款（付款）单 " + bill.toString());
			}
			return bill;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.accountbillblservice.AccountBillBLService#save()
	 */
	@Override
	public AccountBillVO save() {
		try {
			AccountBillVO bill = accountBill.save();
			if(bill != null) {
				LogMsgController.addLog("保存收款（付款）单为草稿状态 " + bill.toString());
			}
			return bill;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

}
