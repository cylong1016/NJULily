package businesslogic.accountbillbl;

import java.util.ArrayList;
import java.util.HashMap;

import message.ResultMessage;
import po.AccountBillItemPO;
import po.AccountBillPO;
import server.data.AccountBillData;
import vo.AccountBillItemVO;
import vo.AccountBillVO;
import businesslogic.accountbl.Account;
import businesslogic.clientbl.Client;
import businesslogic.recordbl.info.ValueObjectInfo_Record;
import businesslogic.userbl.User;
import dataenum.BillType;
import dataenum.Storage;
import dataservice.AccountBillDataService;

public class AccountBill implements ValueObjectInfo_Record<AccountBillVO> {

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
		//		try {
		//			DataFactoryService factory = (DataFactoryService)Naming.lookup(RMI.URL);
		//			accountBillData = factory.getAccountBillData();
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//		}
		this.accountBillData = new AccountBillData();
	}

	/**
	 * 创建收款（付款）单的时候返回一个可用的单子ID
	 * @param type 创建单子的类型
	 * @return 新的ID
	 * @author cylong
	 * @version 2014年12月1日 上午1:32:18
	 */
	public String getID(BillType type) {
		this.type = type;
		this.ID = accountBillData.getID(type);
		return ID;
	}

	/**
	 * @see businesslogic.accountbillbl.ClientInfo_AccountBill
	 * @author cylong
	 * @version 2014年12月1日 上午1:33:04
	 */
	public HashMap<String, String> getAllClients() {
		ClientInfo_AccountBill clientInfo = new Client();
		return clientInfo.getAllClients();
	}

	/**
	 * @see businesslogic.accountbillbl.AccountInfo_AccountBill
	 * @author cylong
	 * @version 2014年12月1日 上午1:36:29
	 */
	public HashMap<String, String> getAllAccounts() {
		AccountInfo_AccountBill accountInfo = new Account();
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
	public void addAccountBill(String clientID) {
		UserInfo_AccountBill userInfo = new User();
		String userID = userInfo.getUserID();
		ArrayList<AccountBillItemPO> billsPO = bills.toPOList();
		po = new AccountBillPO(ID, clientID, userID, billsPO, type);
	}

	/**
	 * 提交成正在审批状态
	 * @return 处理结果
	 * @author cylong
	 * @version 2014年12月1日 上午1:56:06
	 */
	public ResultMessage submit() {
		return accountBillData.insert(po);
	}

	/**
	 * 收款（付款）单保存成草稿状态
	 * @return 处理结果
	 * @author cylong
	 * @version 2014年11月30日 下午10:43:20
	 */
	public ResultMessage save() {
		// TODO AccountBill保存成草稿状态
		return null;
	}

	/**
	 * @see businesslogic.recordbl.info.ValueObjectInfo_Record#show(dataenum.BillType)
	 */
	@Override
	public ArrayList<AccountBillVO> show(BillType billType) {
		// TODO cylong求告知这个方法是干什么的
		return null;
	}

	/**
	 * @see businesslogic.recordbl.info.ValueObjectInfo_Record#getID(java.lang.String, java.lang.String,
	 *      java.lang.String, dataenum.Storage)
	 */
	@Override
	public String getID(String ID, String clientName, String salesman, Storage storage) {
		// TODO cylong求告知这个方法是干什么的
		return null;
	}
}
