package businesslogic.accountbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import message.ResultMessage;
import vo.AccountVO;
import dataenum.FindTypeAccount;
import blservice.accountblservice.AccountBLService;

/**
 * @see blservice.accountblservice.AccountBLService
 * @author cylong
 * @version 2014年12月14日 下午2:59:13
 */
public class AccountController implements AccountBLService {

	private Account account;

	/**
	 * @author cylong
	 * @version 2014年12月14日 下午3:07:45
	 */
	public AccountController() {
		account = new Account();
	}

	/**
	 * @see blservice.accountblservice.AccountBLService#getID()
	 */
	@Override
	public String getID() {
		try {
			return account.getID();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.accountblservice.AccountBLService#show()
	 */
	@Override
	public ArrayList<AccountVO> show() {
		try {
			return account.show();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.accountblservice.AccountBLService#find(java.lang.String, dataenum.FindTypeAccount)
	 */
	@Override
	public ArrayList<AccountVO> find(String keywords, FindTypeAccount type) {
		try {
			return account.find(keywords, type);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.accountblservice.AccountBLService#find(java.lang.String)
	 */
	@Override
	public AccountVO find(String ID) {
		try {
			return account.find(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.accountblservice.AccountBLService#add(vo.AccountVO)
	 */
	@Override
	public ResultMessage add(AccountVO vo) {
		try {
			return account.add(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.REMOTE_EXCEPTION;
		}
	}

	/**
	 * @see blservice.accountblservice.AccountBLService#delete(java.lang.String)
	 */
	@Override
	public ResultMessage delete(String ID) {
		try {
			return account.delete(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.REMOTE_EXCEPTION;
		}
	}

	/**
	 * @see blservice.accountblservice.AccountBLService#update(vo.AccountVO)
	 */
	@Override
	public ResultMessage update(AccountVO vo) {
		try {
			return account.update(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.REMOTE_EXCEPTION;
		}
	}

}
