package businesslogic.accountbillbl;

import java.util.ArrayList;
import java.util.HashMap;

import message.ResultMessage;
import po.UserPO;
import vo.AccountBillVO;
import vo.AccountBillItemVO;
import businesslogic.recordbl.info.ValueObjectInfo_Record;
import dataenum.BillType;
import dataenum.Storage;

public class AccountBill implements ValueObjectInfo_Record<AccountBillVO> {

	/** 编号 */
	private String id;
	/** 客户ID */
	private String clientID;
	/** 客户名称 */
	private String clientName;
	/** 操作员 */
	private UserPO user;
	/** 转账列表 */
	private AccountBillList bills = new AccountBillList();
	/** 汇款总额 */
	private double sumMoney;

	public String getID(BillType type) {
		return null;
	}

	public HashMap<String, String> getAllClients() {
		return null;
	}

	public ResultMessage addClient(String clientID, String clientName) {
		this.clientID = clientID;
		this.clientName = clientName;
		return ResultMessage.SUCCESS;
	}

	public HashMap<String, String> getAllAccounts() {
		return null;
	}

	public ResultMessage addBillItem(AccountBillItemVO vo) {
		bills.addBillItem(accountName, money, remark);
		sumMoney = bills.getSumMoney();
		return ResultMessage.SUCCESS;
	}

	public double getSumMoney() {
		return this.sumMoney;
	}

	public ResultMessage addExpenses(String clientID) {
		return null;
	}

	public ResultMessage addPay(String clientID) {
		return null;
	}

	public ResultMessage submit() {
		return null;
	}

	/**
	 * 收款（付款）单保存成草稿状态
	 * @return 处理结果
	 * @author cylong
	 * @version 2014年11月30日 下午10:43:20
	 */
	public ResultMessage save() {
		return null;
	}

	/**
	 * @see businesslogic.recordbl.info.ValueObjectInfo_Record#show(dataenum.BillType)
	 */
	@Override
	public ArrayList<AccountBillVO> show(BillType billType) {
		return null;
	}

	/**
	 * @see businesslogic.recordbl.info.ValueObjectInfo_Record#getID(java.lang.String, java.lang.String,
	 *      java.lang.String, dataenum.Storage)
	 */
	@Override
	public String getID(String ID, String clientName, String salesman, Storage storage) {
		return null;
	}
}
