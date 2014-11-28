package businesslogic.salebl;

import java.util.ArrayList;
import dataenum.Storage;
import po.CommodityItemPO;

/**
 * 销售（销售退货）单和一些处理
 * 包括转换PO、添加单条的商品列表、计算折让后的价格
 * @author Zing
 * @version Nov 27, 2014 10:59:45 AM
 */
public class SaleList {

	/** 客户 */
	private String clientID;
	/** 仓库 */
	private Storage storage;
	/** 商品列表清单 */
	private ArrayList<SaleListItem> commodities;
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

	public SaleList() {
		commodities = new ArrayList<SaleListItem>();
		beforePrice = 0;
	}

	/**
	 * 添加一条商品
	 * @param item
	 * @author Zing
	 * @version 2014年11月28日  下午8:16:37
	 */
	public void add(SaleListItem item) {
		commodities.add(item);
	}

	/**
	 * 计算折让前价格
	 */
	public double getBeforePrice() {
		for(int i = 0; i < commodities.size(); i++) {
			beforePrice += commodities.get(i).getTotal();
		}
		return beforePrice;
	}

	/**
	 * 得到折让后的价格
	 */
	public double getAfterPrice() {
		this.afterPrice = beforePrice - allowance - voucher;
		return afterPrice;
	}

	/**
	 * 进行po的转换
	 */
	public ArrayList<CommodityItemPO> getCommodities() {
		ArrayList<CommodityItemPO> commoditiesPO = new ArrayList<CommodityItemPO>();
		for(int i = 0; i < commodities.size(); i++) {
			SaleListItem c = commodities.get(i);
			CommodityItemPO po = new CommodityItemPO(c.getID(), 
					c.getNumber(), c.getPrice(), c.getTotal(), c.getRemark());
			commoditiesPO.add(po);
		}
		return commoditiesPO;
	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public double getAllowance() {
		return allowance;
	}

	public void setAllowance(double allowance) {
		this.allowance = allowance;
	}

	public double getVoucher() {
		return voucher;
	}

	public void setVoucher(double voucher) {
		this.voucher = voucher;
	}

}
