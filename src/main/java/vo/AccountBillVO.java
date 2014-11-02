package vo;

import java.util.ArrayList;

/**
 * 付款单收款单值对象
 * @author cylong
 * @version Oct 26, 2014  2:24:03 PM
 */
public class AccountBillVO {

	/** 编号 */
	public String id;
	/** 客户 */
	public ClientVO client;
	/** 操作员 */
	public UserVO user;
	/** 转账列表 */
	public ArrayList<BillItemVO> bills;
	/** 汇款总额 */
	public int sumMoney;
	
	public AccountBillVO(String id, ClientVO client, UserVO user, ArrayList<BillItemVO> bills, int sumMoney){
		this.id = id;
		this.client = client;
		this.user = user;
		this.bills = bills;
		this.sumMoney = sumMoney;
	}
}
