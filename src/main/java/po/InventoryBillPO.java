package po;

import java.util.ArrayList;

import dataenum.BillType;

/**
 * 赠送单、报溢单、报损单、报警单持久化对象
 * @author cylong
 * @version Oct 26, 2014 2:19:50 PM
 */
public class InventoryBillPO extends PersistentObject {

	private static final long serialVersionUID = 1L;
	/** 单据ID */
	private static String id;
	/** 商品集合（赠送单） */
	private ArrayList<GiftCommodityItemPO> commodities;
	/** 商品（报损、报溢、报警） */
	private String commodityID;
	/** 报损、报溢数量 */
	private int num;
	/** 备注*/
	private String remark;
	/** 单子类型，报损／报溢／报警 */
	private BillType billType;

	public InventoryBillPO(BillType billType, ArrayList<GiftCommodityItemPO> commodities, int num, String remark) {
		super(id);
		this.billType = billType;
		this.commodities = commodities;
		this.num = num;
		this.remark = remark;
	}

	public InventoryBillPO(ArrayList<GiftCommodityItemPO> commodities, String remark) {
		super(id);
		this.commodities = commodities;
		this.remark = remark;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static String getId() {
		return id;
	}

	public String getCommodityID() {
		return commodityID;
	}

	public int getNum() {
		return num;
	}
	
	public BillType getBillType() {
		return billType;
	}

	public String getRemark() {
		return remark;
	}

	public ArrayList<GiftCommodityItemPO> getCommodities() {
		return commodities;
	}
}
