package businesslogic.accountbillbl;

import java.util.ArrayList;
import java.util.HashMap;

import message.ResultMessage;
import po.AccountBillItemPO;
import po.AccountBillPO;
import server.data.accountbilldata.AccountBillData;
import vo.AccountBillItemVO;
import vo.AccountBillVO;
import businesslogic.accountbl.AccountInfo;
import businesslogic.clientbl.ClientInfo;
import businesslogic.userbl.UserInfo;
import dataenum.BillState;
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
		ClientInfo_AccountBill clientInfo = new ClientInfo();
		return clientInfo.getAllClients();
	}

	/**
	 * @see businesslogic.accountbillbl.AccountInfo_AccountBill
	 * @author cylong
	 * @version 2014年12月1日 上午1:36:29
	 */
	public HashMap<String, String> getAllAccounts() {
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
	public void addAccountBill(String clientID) {
		UserInfo_AccountBill userInfo = new UserInfo();
		String userID = userInfo.getUserID();
		ArrayList<AccountBillItemPO> billsPO = bills.toPOList();
		po = new AccountBillPO(ID, clientID, userID, billsPO, type);
	}

	/**
	 * @return 全部的收款单和付款单
	 * @author cylong
	 * @version 2014年12月1日 下午3:21:44
	 */
	public ArrayList<AccountBillVO> show() {
		ArrayList<AccountBillPO> billsPO = accountBillData.show();
		ArrayList<AccountBillVO> billsVO = billsPOToBillsVO(billsPO);
		return billsVO;
	}

	/**
	 * 根据单据类型返回单子（收款单，付款单）
	 * @param type 单据类型
	 * @return ArrayList<AccountBillVO>
	 * @author cylong
	 * @version 2014年12月1日 下午3:22:01
	 */
	public ArrayList<AccountBillVO> show(BillType type) {
		ArrayList<AccountBillPO> billsPO = accountBillData.show(type);
		ArrayList<AccountBillVO> billsVO = billsPOToBillsVO(billsPO);
		return billsVO;
	}

	/**
	 * 将收款单（付款单）的PO集合转化成VO集合
	 * @param billsPO
	 * @return ArrayList<AccountBillVO>
	 * @author cylong
	 * @version 2014年12月1日 下午3:45:32
	 */
	private ArrayList<AccountBillVO> billsPOToBillsVO(ArrayList<AccountBillPO> billsPO) {
		ArrayList<AccountBillVO> billsVO = new ArrayList<AccountBillVO>();
		for(AccountBillPO po : billsPO) {
			AccountBillVO vo = poToVO(po);
			billsVO.add(vo);
		}
		return billsVO;
	}

	/**
	 * 将AccountBillPO转化成AccountBillVO
	 * @param po AccountBillPO
	 * @return AccountBillVO
	 * @author cylong
	 * @version 2014年12月1日 下午3:40:52
	 */
	public AccountBillVO poToVO(AccountBillPO po) {
		String ID = po.getID();
		String clientID = po.getClientID();
		String userID = po.getUserID();
		ArrayList<AccountBillItemVO> bills = toItemVOList(po.getBills());
		BillState state = po.getState();
		BillType type = po.getType();
		AccountBillVO vo = new AccountBillVO(ID, clientID, userID, bills, state, type);
		return vo;
	}

	/**
	 * itemPOList转化成itemVOList
	 * @return itemVOList
	 * @author cylong
	 * @version 2014年12月1日 上午1:13:19
	 */
	public ArrayList<AccountBillItemVO> toItemVOList(ArrayList<AccountBillItemPO> itemPOList) {
		ArrayList<AccountBillItemVO> itemVOList = new ArrayList<AccountBillItemVO>();
		for(AccountBillItemPO po : itemPOList) {
			String accountID = po.getAccountID();
			double money = po.getMoney();
			String remark = po.getRemark();
			AccountBillItemVO vo = new AccountBillItemVO(accountID, money, remark);
			itemVOList.add(vo);
		}
		return itemVOList;
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
	 * 根据ID精确查找账单
	 * @param ID 账单ID
	 * @return AccountBillVO
	 * @author cylong
	 * @version 2014年12月1日 下午5:07:56
	 */
	public AccountBillVO find(String ID) {
		AccountBillPO po = accountBillData.find(ID);
		return poToVO(po);
	}

	public AccountBillDataService getAccountBillData() {
		return this.accountBillData;
	}
}
