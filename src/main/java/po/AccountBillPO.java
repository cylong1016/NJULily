package po;

import java.util.ArrayList;

/**
 * 收款单付款单持久化对象
 * @author cylong
 * @version Oct 26, 2014 2:18:04 PM
 */
/**
 * 修改原因：将clientPO改成clientID和clientName因为clientPO中很多东西是不需要的，保存太多浪费
 * 删除了id属性，因为在父类中有id属性了
 * @author cylong
 * @version Nov 16, 2014 3:42:42 PM
 */
public class AccountBillPO extends PersistentObject {

	private static final long serialVersionUID = 1L;
	/** 客户ID */
	private String clientID;
	/** 客户名称 */
	private String clientName;
	/** 操作员 */
	private UserPO user;
	/** 转账列表 */
	private ArrayList<BillItemPO> bills;
	/** 汇款总额 */
	private double sumMoney;

	public AccountBillPO(String id, String clientID, String clientName, UserPO user, ArrayList<BillItemPO> bills, double sumMoney) {
		super(id);
		this.id = id;
		this.clientID = clientID;
		this.clientName = clientName;
		this.user = user;
		this.bills = bills;
		this.sumMoney = sumMoney;
	}

	public String getClientID() {
		return this.clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public String getClientName() {
		return this.clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
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

	public double getSumMoney() {
		return sumMoney;
	}

	public void setSumMoney(int sumMoney) {
		this.sumMoney = sumMoney;
	}

}
