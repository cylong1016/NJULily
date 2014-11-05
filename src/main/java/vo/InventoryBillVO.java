package vo;

import java.util.ArrayList;

import dataenum.BillType;
import dataenum.Date;


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
	/** 时间区间 开始*/
	public Date begin;
	/** 时间区间 结束*/
	public Date end;
	/** 商品集合（赠送单） */
	public ArrayList<CommodityVO> commodities;
	/** 客户 */
	public ClientVO client;
	/** 商品（报损、报溢、报警） */
	public CommodityVO commodity;
	/** 报损、报溢数量*/
	public int num;
	/** 赠送商品的数量*/
	public int giftNum;
	/** 单子类型，报损／报溢／报警*/
	public BillType billType;
	
	public InventoryBillVO(BillType billType, CommodityVO commodity, int num) {
		this.billType = billType;
		this.commodity = commodity;
		this.num = num;
	}
	
	public InventoryBillVO(ArrayList<CommodityVO> commodities, int giftNum, ClientVO client) {
		this.commodities = commodities;
		this.giftNum = giftNum;
		this.client = client;
	}

}
