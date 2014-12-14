package businesslogic.accountinitbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import message.ResultMessage;
import vo.AccountaInitVO;
import blservice.accountinitblservice.AccountInitBLService;

/**
 * @see blservice.accountinitblservice.AccountInitBLService
 * @author cylong
 * @version 2014年12月14日 下午4:48:58
 */
public class AccountInitController implements AccountInitBLService {

	private AccountInit accountInit;

	/**
	 * @author cylong
	 * @version 2014年12月14日 下午4:51:46
	 */
	public AccountInitController() {
		accountInit = new AccountInit();
	}

	/**
	 * @see blservice.accountinitblservice.AccountInitBLService#buildAccount()
	 */
	@Override
	public ResultMessage buildAccount() {
		try {
			return accountInit.buildAccount();
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.REMOTE_EXCEPTION;
		}
	}

	/**
	 * @see blservice.accountinitblservice.AccountInitBLService#show()
	 */
	@Override
	public ArrayList<AccountaInitVO> show() {
		try {
			return accountInit.show();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

}
