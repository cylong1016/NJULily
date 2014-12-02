package po;

import java.util.ArrayList;

import dataenum.BillState;
import dataenum.BillType;

/**
 * 赠送单、报溢单、报损单、报警单持久化对象
 * @author cylong
 * @version Oct 26, 2014 2:19:50 PM
 */
public class InventoryBillPO extends PersistentObject {

	private static final long serialVersionUID = 1L;
	/** 单据ID */
	private String ID;
	/** 商品集合（赠送单） */
	private ArrayList<CommodityItemPO> commodities;
	/** 备注 */
	private String remark;
	/** 单子类型，报损／报溢／报警/赠送 */
	private BillType billType;
	/** 单据状态 */
	private BillState state;

	public InventoryBillPO(String ID, BillType billType, ArrayList<CommodityItemPO> commodities, String remark) {
		super(ID);
		this.ID = ID;
		this.billType = billType;
		this.commodities = commodities;
		this.remark = remark;
		this.state = BillState.APPROVALING;
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
	public BillType getBillType() {
		return billType;
	}

	public String getRemark() {
		return remark;
	}

	public ArrayList<CommodityItemPO> getCommodities() {
		return commodities;
	}
}
