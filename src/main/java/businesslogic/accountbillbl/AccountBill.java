package businesslogic.accountbillbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import po.AccountBillItemPO;
import po.AccountBillPO;
import vo.AccountBillItemVO;
import vo.AccountBillVO;
import businesslogic.accountbillbl.info.AccountInfo_AccountBill;
import businesslogic.accountbillbl.info.ClientInfo_AccountBill;
import businesslogic.accountbillbl.info.UserInfo_AccountBill;
import businesslogic.accountbl.AccountInfo;
import businesslogic.clientbl.ClientInfo;
import businesslogic.userbl.UserInfo;
import config.RMIConfig;
import dataenum.BillType;
import dataservice.accountbilldataservice.AccountBillDataService;

public class AccountBill {

	/** 编号 */
	private String ID;
	/** 收款单或者付款单 */
	private BillType type;
	/** 转账列表 */
	private AccountBillList bills = new AccountBillList();
	/** 汇款总额 */
	private double sumMoney;
	/** 收款单（付款单） */
	private AccountBillPO po;

	private AccountBillDataService accountBillData;

	public AccountBill() {
		try {
			accountBillData = (AccountBillDataService)Naming.lookup(RMIConfig.PREFIX + AccountBillDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return 新建收款单时候，返回一个可用的收款单ID
	 * @author cylong
	 * @version 2014年12月17日 下午11:43:40
	 * @throws RemoteException
	 */
	public String getExpenseID() throws RemoteException {
		this.type = BillType.EXPENSE;
		return ID = accountBillData.getExpenseID();
	}

	/**
	 * @return 新建付款单的时候，返回一个可用的付款单ID
	 * @throws RemoteException
	 * @author cylong
	 * @version 2014年12月17日 下午11:48:09
	 */
	public String getPayID() throws RemoteException {
		this.type = BillType.PAY;
		return ID = accountBillData.getPayID();
	}

	/**
	 * @see businesslogic.accountbillbl.info.ClientInfo_AccountBill
	 * @author cylong
	 * @version 2014年12月1日 上午1:33:04
	 * @throws RemoteException
	 */
	public HashMap<String, String> getAllClients() throws RemoteException {
		ClientInfo_AccountBill clientInfo = new ClientInfo();
		return clientInfo.getAllClients();
	}

	/**
	 * @see businesslogic.accountbillbl.info.AccountInfo_AccountBill
	 * @author cylong
	 * @version 2014年12月1日 上午1:36:29
	 * @throws RemoteException
	 */
	public HashMap<String, String> getAllAccounts() throws RemoteException {
		AccountInfo_AccountBill accountInfo = new AccountInfo();
		return accountInfo.getAllAccounts();
	}

	/**
	 * 添加转账列表中的一条数据
	 * @param vo AccountBillItemVO
	 * @author cylong
	 * @version 2014年12月1日 上午1:37:20
	 */
	public void addBillItem(AccountBillItemVO vo) {
		bills.addBillItem(vo);
		sumMoney = bills.getSumMoney();
	}

	/**
	 * @return 转账列表的总额
	 * @author cylong
	 * @version 2014年12月1日 上午1:37:46
	 */
	public double getSumMoney() {
		return this.sumMoney;
	}

	/**
	 * 添加一条账单（单据类型已经在前面的getID方法中获得）
	 * @param clientID 客户ID
	 * @return 处理结果
	 * @author cylong
	 * @version 2014年12月1日 上午1:39:47
	 */
	/**
	 * 添加一条账单（单据类型已经在前面的getID方法中获得）
	 * @param clientID 客户ID
	 * @param clientName 客户name
	 * @author cylong
	 * @version 2014年12月4日 下午7:34:15
	 */
	public void addAccountBill(String clientID, String clientName) {
		UserInfo_AccountBill userInfo = new UserInfo();
		String username = userInfo.getUsername();
		ArrayList<AccountBillItemPO> billsPO = bills.toPOList();
		po = new AccountBillPO(ID, clientID, clientName, username, billsPO, type);
	}


	/**
	 * 提交成正在审批状态
	 * @return 处理结果
	 * @author cylong
	 * @version 2014年12月1日 上午1:56:06
	 * @throws RemoteException
	 */
	public AccountBillVO submit() throws RemoteException {
		accountBillData.insert(po);
		return AccountBillTrans.poToVO(po);
	}

	/**
	 * 收款（付款）单保存成草稿状态
	 * @return 处理结果
	 * @author cylong
	 * @version 2014年11月30日 下午10:43:20
	 */
	public AccountBillVO save() {
		// TODO AccountBill保存成草稿状态
		return null;
	}

	/**
	 * 根据ID精确查找账单
	 * @param ID 账单ID
	 * @return AccountBillVO
	 * @author cylong
	 * @version 2014年12月1日 下午5:07:56
	 * @throws RemoteException
	 */
	public AccountBillVO find(String ID) throws RemoteException {
		AccountBillPO po = accountBillData.find(ID);
		return AccountBillTrans.poToVO(po);
	}

	public AccountBillDataService getAccountBillData() {
		return this.accountBillData;
	}
}
