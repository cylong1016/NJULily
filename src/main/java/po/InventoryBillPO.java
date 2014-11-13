package po;

import java.util.ArrayList;

import dataenum.BillType;
import dataenum.Date;


/**
 * 赠送单、报溢单、报损单、报警单持久化对象
 * @author cylong
 * @version Oct 26, 2014  2:19:50 PM
 */
public class InventoryBillPO extends PersistentObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 单据ID */
	
	private static String id;
	/** 时间区间 开始*/
	private Date begin;
	/** 时间区间 结束*/
	private Date end;
	/** 商品集合（赠送单） */
	private ArrayList<CommodityPO> commodities;
	/** 客户 */
	private ClientPO client;
	/** 商品（报损、报溢、报警） */
	private CommodityPO commodity;
	/** 报损、报溢数量*/
	private int num;
	/** 赠送商品的数量*/
	private int giftNum;
	/** 单子类型，报损／报溢／报警*/
	private BillType billType;
	
	public InventoryBillPO(BillType billType, ArrayList<CommodityPO> commodities, int num) {
		super(id);
		this.billType = billType;
		this.num = num;
	}
	
	public InventoryBillPO(ArrayList<CommodityPO> commodities, int giftNum, ClientPO client) {
		super(id);
		this.commodities = commodities;
		this.giftNum = giftNum;
		this.client = client;
	}

	public Date getBegin() {
		return begin;
	}

	public void setBegin(Date begin) {
		this.begin = begin;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public ArrayList<CommodityPO> getCommodities() {
		return commodities;
	}

	public void setCommodities(ArrayList<CommodityPO> commodities) {
		this.commodities = commodities;
	}

	public ClientPO getClient() {
		return client;
	}

	public void setClient(ClientPO client) {
		this.client = client;
	}

	public CommodityPO getCommodity() {
		return commodity;
	}

	public void setCommodity(CommodityPO commodity) {
		this.commodity = commodity;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public BillType getBillType() {
		return billType;
	}

	public void setBillType(BillType billType) {
		this.billType = billType;
	}

	public int getGiftNum() {
		return giftNum;
	}

	public void setGiftNum(int giftNum) {
		this.giftNum = giftNum;
	}
	
	
}
