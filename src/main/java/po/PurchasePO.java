package po;

import java.util.ArrayList;

import dataenum.BillState;
import dataenum.BillType;
import dataenum.Storage;

/**
 * 进货单和进货退货单持久化对象
 * @author cylong
 * @version Oct 26, 2014 1:41:14 PM
 */
/**
 * @author Zing
 * @version 2014年10月31日下午4:52:15
 */
public class PurchasePO extends PersistentObject {

	private static final long serialVersionUID = 1L;
	/** 单据编号 */
	private String ID;
	/** 客户ID */
	private String clientID;
	/** 客户 */
	private String client;
	/** 仓库 */
	private Storage storage;
	/** 操作员 */
	private String user;
	/** 商品列表清单 */
	private ArrayList<CommodityItemPO> commodities;
	/** 总额 */
	private double beforePrice;
	/** 备注 */
	private String remark;
	/** 单据类型 */
	private BillType type;
	/** 单据状态 */
	private BillState state;

	public PurchasePO(String ID, String clientID, String client, String user, Storage storage, ArrayList<CommodityItemPO> commodities, double beforePrice, String remark, BillType type) {
		super(ID);
		this.ID = ID;
		this.clientID = clientID;
		this.client = client;
		this.user = user;
		this.storage = storage;
		this.commodities = commodities;
		this.beforePrice = beforePrice;
		this.type = type;
		this.remark = remark;
		this.state = BillState.APPROVALING;
	}

	public String getClientID() {
		return this.clientID;
	}

	public BillState getState() {
		return this.state;
	}

	public void setState(BillState state) {
		this.state = state;
	}

	public String getID() {
		return ID;
	}

	public String getClient() {
		return client;
	}

	public Storage getStorage() {
		return storage;
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

	public String getRemark() {
		return remark;
	}

	public BillType getType() {
		return this.type;
	}

}
