package businesslogic.accountbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import message.ResultMessage;
import po.AccountPO;
import vo.AccountVO;
import config.RMIConfig;
import dataenum.FindTypeAccount;
import dataservice.accountdataservice.AccountDataService;

public class Account {

	private AccountDataService accountData;

	private AccountPO po;

	public Account() {
		try {
			accountData = (AccountDataService)Naming.lookup(RMIConfig.PREFIX + AccountDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查找账户
	 * @param keywords 关键字
	 * @param type 查找类型； null为模糊查找
	 * @return 返回满足条件的全部账户
	 * @author cylong
	 * @version 2014年12月1日 上午2:22:44
	 * @throws RemoteException
	 */
	public ArrayList<AccountVO> find(String keywords, FindTypeAccount type) throws RemoteException {
		ArrayList<AccountPO> AccountsPO = accountData.find(keywords, type);
		ArrayList<AccountVO> AccountsVO = new ArrayList<AccountVO>();
		for(AccountPO po : AccountsPO) {
			AccountVO vo = poToVO(po);
			AccountsVO.add(vo);
		}
		return AccountsVO;
	}

	/**
	 * 添加账户
	 * @param vo AccountVO
	 * @return 处理信息
	 * @author cylong
	 * @version 2014年12月1日 上午2:23:30
	 * @throws RemoteException
	 */
	public ResultMessage add(AccountVO vo) throws RemoteException {
		po = new AccountPO(vo.ID, vo.name, vo.money);
		return accountData.insert(po);
	}

	/**
	 * 以帐户ID删除账户
	 * @param ID 帐户ID
	 * @return 处理结果
	 * @author cylong
	 * @version 2014年11月30日 上午2:40:10
	 * @throws RemoteException
	 */
	public ResultMessage delete(String ID) throws RemoteException {
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
	 * @throws RemoteException
	 */
	public ResultMessage update(AccountVO vo) throws RemoteException {
		po = accountData.find(vo.name);
		if (po == null) {
			return ResultMessage.FAILURE;
		}
		po = new AccountPO(vo.ID, vo.name, vo.money);
		return accountData.update(po);
	}

	/**
	 * @return 全部的AccountVO
	 * @author cylong
	 * @version 2014年11月30日 上午2:23:57
	 * @throws RemoteException
	 */
	public ArrayList<AccountVO> show() throws RemoteException {
		return POstoVOs(accountData.show());
	}

	/**
	 * 把PO集合转换成VO集合
	 * @param POs
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 8:44:58 PM
	 */
	public ArrayList<AccountVO> POstoVOs(ArrayList<AccountPO> POs) {
		ArrayList<AccountVO> VOs = new ArrayList<AccountVO>();
		for(AccountPO po : POs) {
			AccountVO vo = poToVO(po);
			VOs.add(vo);
		}
		return VOs;
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
	 * @throws RemoteException
	 */
	public String getID() throws RemoteException {
		return accountData.getID();
	}

	/**
	 * 根据账户ID精确查找账户
	 * @param ID 账户ID
	 * @return AccountVO
	 * @author cylong
	 * @version 2014年12月1日 下午5:02:16
	 * @throws RemoteException
	 */
	public AccountVO find(String ID) throws RemoteException {
		AccountPO po = accountData.find(ID);
		return poToVO(po);
	}

	public AccountDataService getAccountData() {
		return accountData;
	}

}
