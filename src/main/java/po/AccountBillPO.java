package po;

import java.util.ArrayList;

/**
 * 收款单付款单持久化对象
 * @author cylong
 * @version Oct 26, 2014  2:18:04 PM
 */
public class AccountBillPO extends DocumentPO{
	
	/** 编号 */
	private String id;
	/** 客户 */
	private ClientPO client;
	/** 操作员 */
	private UserPO user;
	/** 转账列表 */
	private ArrayList<BillItemPO> bills;
	/** 汇款总额 */
	private int sumMoney;
	
	public AccountBillPO(String id, ClientPO client, UserPO user, ArrayList<BillItemPO> bills, int sumMoney){
		this.id = id;
		this.client = client;
		this.user = user;
		this.bills = bills;
		this.sumMoney = sumMoney;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ClientPO getClient() {
		return client;
	}

	public void setClient(ClientPO client) {
		this.client = client;
	}

	public UserPO getUser() {
		return user;
	}

	public void setUser(UserPO user) {
		this.user = user;
	}

	public ArrayList<BillItemPO> getBills() {
		return bills;
	}

	public void setBills(ArrayList<BillItemPO> bills) {
		this.bills = bills;
	}

	public int getSumMoney() {
		return sumMoney;
	}

	public void setSumMoney(int sumMoney) {
		this.sumMoney = sumMoney;
	}
	
	
}
