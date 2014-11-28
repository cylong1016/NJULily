package po;

import java.util.ArrayList;

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
	private String id;
	/** 客户 */
	private String client;
	/** 仓库 */
	private Storage storage;
	/** 操作员 */
	private String user;
	/** 商品列表清单 */
	private ArrayList<CommodityItemPO> commodities;
	/** 总额 */
	private double sumPrice;
	/** 备注 */
	private String remark;

	private BillType type;

	public PurchasePO(String ID, String client, String user, Storage storage, ArrayList<CommodityItemPO> commodities, double sumPrice, BillType type) {
		super(ID);
		this.id = ID;
		this.client = client;
		this.user = user;
		this.storage = storage;
		this.commodities = commodities;
		this.sumPrice = sumPrice;
		this.type = type;
	}

	public String getId() {
		return id;
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

	public double getSumPrice() {
		return sumPrice;
	}

	public String getRemark() {
		return remark;
	}

	public BillType getType() {
		return this.type;
	}

}
