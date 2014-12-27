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
/**
 * 操作员ID改为操作员name，添加客户姓名属性
 * @author cylong
 * @version 2014年12月4日 下午7:29:06
 */
public class AccountBillVO extends ValueObject {

	/** 客户ID */
	public String clientID;
	/** 客户名 */
	public String clientName;
	/** 操作员name */
	public String username;
	/** 转账列表 */
	public ArrayList<AccountBillItemVO> bills;
	/** 汇款总额 */
	public double sumMoney;
	/** 单据状态 */
	public BillState state;
	/** 区分收款单和付款单 */
	public BillType type;

	public AccountBillVO(String ID, String clientID, String clientName, String username, ArrayList<AccountBillItemVO> bills, BillState state, BillType type) {
		this.ID = ID;
		this.clientID = clientID;
		this.clientName = clientName;
		this.username = username;
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

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[单据ID=" + this.ID + ", " + "客户ID=" + this.clientID + ", 客户姓名=" + this.clientName + ", 操作员="
				+ this.username + ", bills=" + this.bills + ",\r\n总价=" + this.sumMoney + ", 单据状态="
				+ this.state.value + ", 单据类型=" + this.type.value + "]";
	}

}
