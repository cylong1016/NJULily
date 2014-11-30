package businesslogic.accountbl;

import java.rmi.Naming;
import java.util.ArrayList;

import message.ResultMessage;
import po.AccountPO;
import vo.AccountVO;
import businesslogic.accountbillbl.AccountInfo_AccountBill;
import config.RMI;
import dataenum.FindTypeAccount;
import dataservice.AccountDataService;
import dataservice.DataFactoryService;

public class Account implements AccountInfo_AccountBill {

	private AccountDataService accountData;

	private AccountPO po;

	public Account() {
		try {
			DataFactoryService factory = (DataFactoryService)Naming.lookup(RMI.URL);
			accountData = factory.getAccountData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see businesslogic.accountbillbl.AccountInfo_AccountBill#getAllAccount()
	 */
	public ArrayList<AccountPO> getAllAccount() {
		return accountData.show();
	}

	public ArrayList<AccountVO> find(String keywords, FindTypeAccount type) {
		ArrayList<AccountPO> AccountsPO = accountData.find(keywords, type);
		ArrayList<AccountVO> AccountsVO = new ArrayList<AccountVO>();
		for(int i = 0; i < AccountsPO.size(); i++) {
			AccountPO po = AccountsPO.get(i);
			AccountVO vo = poToVO(po);
			AccountsVO.add(vo);
		}
		return AccountsVO;
	}

	public ResultMessage add(AccountVO vo) {
		po = new AccountPO(vo.ID, vo.name, vo.money);
		return accountData.insert(po);
	}

	/**
	 * 以帐户名删除账户
	 * @param ID 帐户名
	 * @return 处理结果
	 * @author cylong
	 * @version 2014年11月30日 上午2:40:10
	 */
	public ResultMessage delete(String ID) {
		po = accountData.find(ID);
		if (po == null) {
			return ResultMessage.FAILURE;
		}
		return accountData.delete(ID);
	}

	/**
	 * 更新账户
	 * @param vo AccountVO
	 * @return 处理结果
	 * @author cylong
	 * @version 2014年11月30日 上午2:38:52
	 */
	public ResultMessage update(AccountVO vo) {
		po = accountData.find(vo.name);
		if (po == null) {
			return ResultMessage.FAILURE;
		}
		po = new AccountPO(vo.ID, vo.name, vo.money);
		return accountData.update(po);
	}

	/**
	 * @return
	 * @author cylong 全部的AccountVO
	 * @version 2014年11月30日 上午2:23:57
	 */
	public ArrayList<AccountVO> show() {
		ArrayList<AccountVO> AccountsVO = new ArrayList<AccountVO>();
		ArrayList<AccountPO> AccountsPO = accountData.show();
		for(int i = 0; i < AccountsPO.size(); i++) {
			AccountPO po = AccountsPO.get(i);
			AccountVO vo = poToVO(po);
			AccountsVO.add(vo);
		}
		return AccountsVO;
	}

	/**
	 * AccountPO转化成AccountVO
	 * @param po AccountPO
	 * @return AccountVO
	 * @author cylong
	 * @version 2014年11月30日 上午2:35:43
	 */
	public AccountVO poToVO(AccountPO po) {
		String ID = po.getID();
		String name = po.getName();
		double money = po.getMoney();
		AccountVO vo = new AccountVO(ID, name, money);
		return vo;
	}

	/**
	 * @return 新建账户时候可用的ID
	 * @author cylong
	 * @version 2014年11月30日 下午1:15:58
	 */
	public String getID() {
		return accountData.getID();
	}

}
