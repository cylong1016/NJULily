package vo;

import java.util.ArrayList;

import vo.commodity.CommodityItemVO;
import dataenum.BillState;
import dataenum.BillType;

/**
 * 赠送单、报溢单、报损单、报警单值对象
 * @author cylong
 * @version Oct 26, 2014 2:26:55 PM
 */
/**
 * @author Zing
 * @version 2014年11月4日下午4:17:12
 */
public class InventoryBillVO extends ValueObject {

	/** 单子类型，报损／报溢／报警/赠送 */
	public BillType billType;
	/** 商品集合（赠送单、报损单、报溢单、报警单） */
	public ArrayList<CommodityItemVO> commodities;
	/** 添加备注 */
	public String remark;
	/** 单据状态 */
	public BillState state;

	public InventoryBillVO(String ID, BillType billType, ArrayList<CommodityItemVO> commodities, String remark, BillState state) {
		this.ID = ID;
		this.billType = billType;
		this.commodities = commodities;
		this.remark = remark;
		this.state = state;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[单据ID=" + ID + ", 单据类型=" + billType.value + ", 商品列表=" + commodities + ",\r\n备注=" + remark + ", 单据状态="
				+ state.value + "]";
	}

}
