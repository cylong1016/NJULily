package businesslogic.accountbl;

import java.util.ArrayList;

import dataenum.FindTypeAccount;
import vo.AccountVO;
import message.ResultMessage;
import blservice.accountblservice.AccountBLService;

/**
 * @see blservice.accountblservice.AccountBLService
 * @author cylong
 * @version 2014年11月30日 上午2:22:52
 */
public class AccountController implements AccountBLService {

	private Account account;

	public AccountController() {
		account = new Account();
	}

	/**
	 * @see blservice.accountblservice.AccountBLService#show()
	 */
	@Override
	public ArrayList<AccountVO> show() {
		return account.show();
	}

	/**
	 * @see blservice.accountblservice.AccountBLService#find(java.lang.String, dataenum.FindTypeAccount)
	 */
	@Override
	public ArrayList<AccountVO> find(String keywords, FindTypeAccount type) {
		return account.find(keywords, type);
	}

	/**
	 * @see blservice.accountblservice.AccountBLService#add(vo.AccountVO)
	 */
	@Override
	public ResultMessage add(AccountVO vo) {
		return account.add(vo);
	}

	/**
	 * @see blservice.accountblservice.AccountBLService#delete(java.lang.String)
	 */
	@Override
	public ResultMessage delete(String ID) {
		return account.delete(ID);
	}

	/**
	 * @see blservice.accountblservice.AccountBLService#update(vo.AccountVO)
	 */
	@Override
	public ResultMessage update(AccountVO vo) {
		return account.update(vo);
	}

	/**
	 * @see blservice.accountblservice.AccountBLService#getID()
	 */
	@Override
	public String getID() {
		return account.getID();
	}

}
