package businesslogic.accountbillbl;

import java.util.ArrayList;

import message.ResultMessage;

/**
 * 转账列表，并提供返回总额方法
 * @author cylong
 * @version Nov 16, 2014 4:10:10 PM
 */
public class AccountBillList {

	private double sumMoney = 0;
	private ArrayList<BillItem> billList;

	public AccountBillList() {
		billList = new ArrayList<BillItem>();
	}

	public ResultMessage addBillItem(String accountName, int money, String remark) {
		BillItem item = new BillItem(accountName, money, remark);
		sumMoney += money;
		billList.add(item);
		return ResultMessage.SUCCESS;
	}
	
	public double getSumMoney() {
		return this.sumMoney;
	}
}
