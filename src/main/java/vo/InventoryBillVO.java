package vo;

import java.util.ArrayList;

import dataenum.BillType;


/**
 * 赠送单、报溢单、报损单、报警单值对象
 * @author cylong
 * @version Oct 26, 2014  2:26:55 PM
 */
/**
 * 
 * @author Zing
 * @version 2014年11月4日下午4:17:12
 */
public class InventoryBillVO {
	/** 商品集合（赠送单） */
	public ArrayList<GiftCommodityItemVO> commodities;
	/** 商品（报损、报溢、报警） */
	public String commodityID;
	/** 报损、报溢数量*/
	public int num;
	/** 赠送商品的数量*/
	public int giftNum;
	/** 添加备注 */
	public String remark;
	/** 单子类型，报损／报溢／报警*/
	public BillType billType;
	
	public InventoryBillVO(BillType billType, String commodityID, int num, String remark) {
		this.billType = billType;
		this.commodityID = commodityID;
		this.num = num;
	}
	
	public InventoryBillVO(ArrayList<GiftCommodityItemVO> commodities, String remark) {
		this.commodities = commodities;
		this.remark = remark;
	}

}
