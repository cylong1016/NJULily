package businesslogic.accountbl;

import java.util.ArrayList;

import message.ResultMessage;
import po.AccountPO;
import server.data.accountdata.AccountData;
import vo.AccountVO;
import blservice.accountblservice.AccountBLService;
import dataenum.FindTypeAccount;
import dataservice.accountdataservice.AccountDataService;

public class Account implements AccountBLService {

	private AccountDataService accountData;

	private AccountPO po;

	public Account() {
//		try {
//			DataFactoryService factory = (DataFactoryService)Naming.lookup(RMI.URL);
//			accountData = factory.getAccountData();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		accountData = new AccountData();
	}

	/**
	 * 查找账户
	 * @param keywords 关键字
	 * @param type 查找类型； null为模糊查找
	 * @return 返回满足条件的全部账户
	 * @author cylong
	 * @version 2014年12月1日 上午2:22:44
	 */
	public ArrayList<AccountVO> find(String keywords, FindTypeAccount type) {
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
	 */
	public ResultMessage add(AccountVO vo) {
		po = new AccountPO(vo.ID, vo.name, vo.money);
		return accountData.insert(po);
	}

	/**
	 * 以帐户ID删除账户
	 * @param ID 帐户ID
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
	 * @return 全部的AccountVO
	 * @author cylong
	 * @version 2014年11月30日 上午2:23:57
	 */
	public ArrayList<AccountVO> show() {
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
	 */
	public String getID() {
		return accountData.getID();
	}

	/**
	 * 根据账户ID精确查找账户
	 * @param ID 账户ID
	 * @return AccountVO
	 * @author cylong
	 * @version 2014年12月1日 下午5:02:16
	 */
	public AccountVO find(String ID) {
		AccountPO po = accountData.find(ID);
		return poToVO(po);
	}

	public AccountDataService getAccountData() {
		return accountData;
	}

}
