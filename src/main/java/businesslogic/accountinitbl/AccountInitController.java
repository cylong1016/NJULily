package businesslogic.accountinitbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import log.LogController;
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
	public AccountaInitVO buildAccount() {
		try {
			AccountaInitVO vo = accountInit.buildAccount();
			if (vo == null) {
				return null;
			}
			LogController.addLog(vo.toString());
			return vo;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.accountinitblservice.AccountInitBLService#show()
	 */
	@Override
	public ArrayList<AccountaInitVO> show() {
		try {
			ArrayList<AccountaInitVO> vos = accountInit.show();
			LogController.addLog("查看所有的以往的期初建账");
			return vos;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

}
