package businesslogic.accountbillbl;

import java.util.HashMap;

import businesslogic.recordbl.info.ValueObjectInfo_Record;
import message.ResultMessage;
import po.UserPO;
import vo.AccountBillVO;
import dataenum.BillType;

public class AccountBill implements ValueObjectInfo_Record<AccountBillVO>{

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

	public HashMap<String, String> getAllAccountName() {
		return null;
	}

	public ResultMessage addBillItem(String accountName, int money, String remark) {
		bills.addBillItem(accountName, money, remark);
		sumMoney = bills.getSumMoney();
		return ResultMessage.SUCCESS;
	}

	public double getSumMoney() {
		return this.sumMoney;
	}

	public ResultMessage addExpenses() {
		return null;
	}

	public ResultMessage addPay() {
		return null;
	}

	public ResultMessage submit() {
		return null;
	}
}
