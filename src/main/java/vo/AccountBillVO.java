package vo;

import java.util.ArrayList;

import dataenum.BillState;

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
public class AccountBillVO extends ValueObject{

	/** 客户ID */
	public String clientID;
	/** 客户姓名 */
	public String clientName;
	/** 操作员 */
	public UserVO user;
	/** 转账列表 */
	public ArrayList<BillItemVO> bills;
	/** 汇款总额 */
	public double sumMoney;
	/** 单据状态 */
	public BillState state;

	public AccountBillVO(String ID, String clientID, String clientName, UserVO user, ArrayList<BillItemVO> bills, double sumMoney, BillState state) {
		this.ID = ID;
		this.clientID = clientID;
		this.clientName = clientName;
		this.user = user;
		this.bills = bills;
		this.sumMoney = sumMoney;
		this.state = state;
	}
}
