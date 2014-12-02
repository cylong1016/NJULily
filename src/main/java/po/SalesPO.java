package po;

import java.util.ArrayList;

import dataenum.BillState;
import dataenum.BillType;
import dataenum.Storage;

/**
 * 销售和销售退货单持久化对象
 * @author cylong
 * @version Oct 26, 2014 2:04:19 PM
 */
/**
 * 持久化对象就是销售单和销售退货单
 * @author Zing
 * @version 2014年10月29日上午9:48:18
 */
public class SalesPO extends PersistentObject {

	private static final long serialVersionUID = 1L;
	/** 单据编号 */
	private String ID;
	/** 客户ID */
	private String clientID;
	/** 客户 */
	private String client;
	/** 仓库 */
	private Storage storage;
	/** 业务员 */
	private String salesman;
	/** 操作员 */
	private String user;
	/** 商品列表清单 */
	private ArrayList<CommodityItemPO> commodities;
	/** 折让前总额 */
	private double beforePrice;
	/** 折让金额 */
	private double allowance;
	/** 代金券总额 */
	private double voucher;
	/** 折让后总额 */
	private double afterPrice;
	/** 备注 */
	private String remark;
	/** 单据类型 */
	private BillType type;
	/** 单据状态 */
	private BillState state;

	public SalesPO(String ID, String clientID, String client, String salesman, String user, Storage storage, ArrayList<CommodityItemPO> commodities, double beforePrice, double allowance, double voucher, String remark, double afterPrice, BillType type) {
		super(ID);
		this.ID = ID;
		this.clientID = clientID;
		this.client = client;
		this.salesman = salesman;
		this.user = user;
		this.storage = storage;
		this.commodities = commodities;
		this.beforePrice = beforePrice;
		this.allowance = allowance;
		this.voucher = voucher;
		this.remark = remark;
		this.afterPrice = afterPrice;
		this.type = type;
		this.state = BillState.APPROVALING;
	}

	public String getID() {
		return ID;
	}

	public String getClientID() {
		return this.clientID;
	}

	public String getClient() {
		return client;
	}

	public Storage getStorage() {
		return storage;
	}

	public String getSalesman() {
		return salesman;
	}

	public String getUser() {
		return user;
	}

	public ArrayList<CommodityItemPO> getCommodities() {
		return commodities;
	}

	public double getBeforePrice() {
		return beforePrice;
	}

	public double getAllowance() {
		return allowance;
	}

	public double getVoucher() {
		return voucher;
	}

	public double getAfterPrice() {
		return afterPrice;
	}

	public String getRemark() {
		return remark;
	}

	public BillType getType() {
		return type;
	}

	public BillState getState() {
		return this.state;
	}

	public void setState(BillState state) {
		this.state = state;
	}

}
