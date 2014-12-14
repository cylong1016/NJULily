package businesslogic.accountbillbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.AccountBillVO;
import blservice.accountbillblservice.AccountBillShowBLService;

/**
 * @see blservice.accountbillblservice.AccountBillShowBLService
 * @author cylong
 * @version 2014年12月14日 上午9:06:32
 */
public class AccountBillShowController implements AccountBillShowBLService {

	private AccountBillShow accountBillShow;

	/**
	 * @author cylong
	 * @version 2014年12月14日 上午9:12:24
	 */
	public AccountBillShowController() {
		accountBillShow = new AccountBillShow();
	}

	/**
	 * @see blservice.accountbillblservice.AccountBillShowBLService#showPay()
	 */
	@Override
	public ArrayList<AccountBillVO> showPay() {
		try {
			return accountBillShow.showPay();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.accountbillblservice.AccountBillShowBLService#showExpense()
	 */
	@Override
	public ArrayList<AccountBillVO> showExpense() {
		try {
			return accountBillShow.showExpense();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.accountbillblservice.AccountBillShowBLService#showPayApproving()
	 */
	@Override
	public ArrayList<AccountBillVO> showPayApproving() {
		try {
			return accountBillShow.showPayApproving();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.accountbillblservice.AccountBillShowBLService#showExpenseApproving()
	 */
	@Override
	public ArrayList<AccountBillVO> showExpenseApproving() {
		try {
			return accountBillShow.showExpenseApproving();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.accountbillblservice.AccountBillShowBLService#showPayPass()
	 */
	@Override
	public ArrayList<AccountBillVO> showPayPass() {
		try {
			return accountBillShow.showPayPass();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.accountbillblservice.AccountBillShowBLService#showExpensePass()
	 */
	@Override
	public ArrayList<AccountBillVO> showExpensePass() {
		try {
			return accountBillShow.showExpensePass();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.accountbillblservice.AccountBillShowBLService#showPayFailure()
	 */
	@Override
	public ArrayList<AccountBillVO> showPayFailure() {
		try {
			return accountBillShow.showPayFailure();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.accountbillblservice.AccountBillShowBLService#showExpenseFailure()
	 */
	@Override
	public ArrayList<AccountBillVO> showExpenseFailure() {
		try {
			return accountBillShow.showExpenseFailure();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

}
