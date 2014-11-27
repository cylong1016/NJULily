package businesslogic.accountbl;

import java.rmi.Naming;
import java.util.ArrayList;

import dataenum.FindTypeAccount;
import dataservice.AccountDataService;
import dataservice.DataFactoryService;
import message.ResultMessage;
import po.AccountPO;
import vo.AccountVO;

public class Account implements businesslogic.accountbillbl.AccountInfo {

	private DataFactoryService factory;
	
	private AccountDataService accountData;
	
	private AccountPO po;
	
	public Account() {
		try {
			factory = (DataFactoryService)Naming.lookup("rmi://127.0.0.1:8888/factory");
			accountData = (AccountDataService)factory.getAccountData();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	/**
	 * @see businesslogic.accountbillbl.AccountInfo#getAllAccount()
	 */
	public ArrayList<AccountPO> getAllAccount() {
		return null;
	}
	
	public ArrayList<AccountVO> findAccount(String keywords) {
		ArrayList<AccountPO> pos = accountData.find(keywords, null);
		ArrayList<AccountVO> vos = new ArrayList<AccountVO>();
		for (int i = 0; i < pos.size(); i++) {
			AccountVO vo = new AccountVO(pos.get(i).getName(), pos.get(i).getMoney());
			vos.add(vo);
		}
		return vos;
	}

	public ResultMessage addAccount(String name, double money) {
		po = new AccountPO(name, money);
		accountData.insert(po);
		return ResultMessage.SUCCESS;
	}

	public ResultMessage deleteAccount(String name) {
		po = accountData.find(name, FindTypeAccount.NAME).get(0);
		if (po == null) {
			return ResultMessage.FAILURE;
		}
		accountData.delete(name);
		return ResultMessage.SUCCESS;
	}

	public ResultMessage updAccount(String name) {
		po = accountData.find(name, FindTypeAccount.NAME).get(0);
		if (po == null) {
			return ResultMessage.FAILURE;
		}
		po = new AccountPO(name, po.getMoney());
		accountData.update(po);
		return ResultMessage.SUCCESS;
	}

	
}
