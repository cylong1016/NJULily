package businesslogic.accountbillbl;

import java.util.ArrayList;

import po.AccountBillItemPO;
import vo.AccountBillItemVO;

/**
 * 转账列表，并提供返回总额方法
 * @author cylong
 * @version Nov 16, 2014 4:10:10 PM
 */
public class AccountBillList {

	private double sumMoney = 0;
	private ArrayList<AccountBillItemVO> billList;

	public AccountBillList() {
		billList = new ArrayList<AccountBillItemVO>();
	}

	public void addBillItem(AccountBillItemVO vo) {
		AccountBillItemVO item = new AccountBillItemVO(vo.accountID, vo.money, vo.remark);
		sumMoney += vo.money;
		billList.add(item);
	}
	
	public double getSumMoney() {
		return this.sumMoney;
	}
	
	/**
	 * voList转化成poList
	 * @return poList
	 * @author cylong
	 * @version 2014年12月1日  上午1:13:19
	 */
	public ArrayList<AccountBillItemPO> toPOList() {
		ArrayList<AccountBillItemPO> poList = new ArrayList<AccountBillItemPO>();
		for(int i = 0; i < billList.size(); i++) {
			AccountBillItemVO vo = billList.get(i);
			String accountID = vo.accountID;
			int money = vo.money;
			String remark = vo.remark;
			AccountBillItemPO po = new AccountBillItemPO(accountID, money, remark);
			poList.add(po);
		}
		return poList;
	}
}
