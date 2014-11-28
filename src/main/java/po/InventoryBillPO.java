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
	private ArrayList<CommodityPO> commodities;
	/** 客户 */
	private String clientID;
	/** 商品（报损、报溢、报警） */
	private String commodityID;
	/** 报损、报溢数量 */
	private int num;
	/** 赠送商品的数量 */
	private int giftNum;
	/** 单子类型，报损／报溢／报警 */
	private BillType billType;

	public InventoryBillPO(BillType billType, ArrayList<CommodityPO> commodities, int num) {
		super(id);
		this.billType = billType;
		this.num = num;
	}

	public InventoryBillPO(ArrayList<CommodityPO> commodities, int giftNum, String clientID) {
		super(id);
		this.commodities = commodities;
		this.giftNum = giftNum;
		this.clientID = clientID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static String getId() {
		return id;
	}

	public ArrayList<CommodityPO> getCommodities() {
		return commodities;
	}

	public String getClientID() {
		return clientID;
	}

	public String getCommodityID() {
		return commodityID;
	}

	public int getNum() {
		return num;
	}

	public int getGiftNum() {
		return giftNum;
	}

	public BillType getBillType() {
		return billType;
	}

}
