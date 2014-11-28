package businesslogic.accountbl;

import java.util.ArrayList;

import vo.AccountVO;
import message.ResultMessage;
import blservice.accountblservice.AccountBLService;

public class AccountController implements AccountBLService{
	
	private Account account;
	
	public AccountController() {
		account = new Account();
	}

	public ArrayList<AccountVO> findAccount(String keyword) {
		return account.findAccount(keyword);
	}

	public ResultMessage addAccount(String name, double money) {
		return account.addAccount(name, money);
	}

	public ResultMessage deleteAccount(String name) {
		return account.deleteAccount(name);
	}

	public ResultMessage updAccount(String name) {
		return account.updAccount(name);
	}

	

}
