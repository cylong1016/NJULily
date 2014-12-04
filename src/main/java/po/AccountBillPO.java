package po;

import java.util.ArrayList;

import dataenum.BillState;
import dataenum.BillType;

/**
 * 收款单付款单持久化对象
 * @author cylong
 * @version Oct 26, 2014 2:18:04 PM
 */
/**
 * 修改原因：将clientPO改成clientID因为clientPO中很多东西是不需要的，保存太多浪费
 * 删除了ID属性，因为在父类中有ID属性了
 * @author cylong
 * @version Nov 16, 2014 3:42:42 PM
 */
/**
 * 将操作员ID改为操作员name，添加用户name
 * @author cylong
 * @version 2014年12月4日 下午7:24:55
 */
public class AccountBillPO extends PersistentObject {

	/** serialVersionUID */
	private static final long serialVersionUID = 5795283762610233239L;
	/** 客户ID */
	private String clientID;
	/** 客户name */
	private String clientName;
	/** 操作员ID */
	private String username;
	/** 转账列表 */
	private ArrayList<AccountBillItemPO> bills;
	/** 汇款总额 */
	private double sumMoney;
	/** 单据状态 */
	private BillState state;
	/** 区分收款单和付款单 */
	private BillType type;

	public AccountBillPO(String ID, String clientID, String clientName, String username, ArrayList<AccountBillItemPO> bills, BillType type) {
		super(ID);
		this.ID = ID;
		this.clientID = clientID;
		this.clientName = clientName;
		this.username = username;
		this.bills = bills;
		this.type = type;
		this.state = BillState.APPROVALING;
		this.sumMoney = calcSumMoney();
	}

	/**
	 * 根据转账列表结算汇款总额
	 * @return 总额
	 * @author cylong
	 * @version 2014年11月30日 下午11:57:18
	 */
	public double calcSumMoney() {
		double sum = 0;
		for(int i = 0; i < bills.size(); i++) {
			sum += bills.get(i).getMoney();
		}
		return sum;
	}

	public BillType getType() {
		return this.type;
	}

	public BillState getState() {
		return this.state;
	}

	public void setState(BillState state) {
		this.state = state;
	}

	public String getClientID() {
		return this.clientID;
	}

	public String getClientName() {
		return this.clientName;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public String getUsername() {
		return this.username;
	}

	public ArrayList<AccountBillItemPO> getBills() {
		return bills;
	}

	public void setBills(ArrayList<AccountBillItemPO> bills) {
		this.bills = bills;
	}

	public double getSumMoney() {
		return sumMoney;
	}

	public void setSumMoney(int sumMoney) {
		this.sumMoney = sumMoney;
	}

}
