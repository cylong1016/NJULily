package businesslogic.accountainitbl;

import java.util.ArrayList;

import message.ResultMessage;
import vo.AccountaInitVO;
import blservice.accountainitblservice.AccountainitBLService;

public class AccountainitController implements AccountainitBLService{
	
	private Accountainit accountainit;
	
	public AccountainitController() {
		accountainit = new Accountainit();
	}

	public ResultMessage buildAccount() {
		return accountainit.buildAccount();
	}

	public ArrayList<AccountaInitVO> show() {
		return accountainit.show();
	}

}
