package vo;

import java.util.ArrayList;

import dataenum.BillState;
import dataenum.BillType;

/**
 * 付款单收款单值对象
 * @author cylong
 * @version Oct 26, 2014 2:24:03 PM
 */
/**
 * 修改原因: @see po.AccountBillPO
 * 继承了ValueObject类
 * @author cylong
 * @version Nov 16, 2014 3:38:40 PM
 */
public class AccountBillVO extends ValueObject {

	/** 客户ID */
	public String clientID;
	/** 操作员ID */
	public String userID;
	/** 转账列表 */
	public ArrayList<AccountBillItemVO> bills;
	/** 汇款总额 */
	public double sumMoney;
	/** 单据状态 */
	public BillState state;
	/** 区分收款单和付款单 */
	public BillType type;

	public AccountBillVO(String ID, String clientID, String userID, ArrayList<AccountBillItemVO> bills, BillState state, BillType type) {
		this.ID = ID;
		this.clientID = clientID;
		this.userID = userID;
		this.bills = bills;
		this.sumMoney = this.calcSumMoney();
		this.state = state;
		this.type = type;
	}

	/**
	 * 根据转账列表计算总额
	 * @return 总额
	 * @author cylong
	 * @version 2014年12月1日 上午12:09:48
	 */
	public double calcSumMoney() {
		double sum = 0;
		for(int i = 0; i < bills.size(); i++) {
			sum += bills.get(i).money;
		}
		return sum;
	}

}
