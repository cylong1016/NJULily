package businesslogic.salebl;

import java.util.ArrayList;

import po.CommodityItemPO;
/**
 * 销售列表的一些处理
 * 包括转换PO、添加单条的商品列表、计算折让前的价格
 * @author Zing
 * @version Nov 27, 201410:59:45 AM
 */
public class SaleList {
	private ArrayList<SaleListItem> commodities;
	
	private double beforePrice;
	
	public SaleList() {
		commodities = new ArrayList<SaleListItem>();
		beforePrice = 0;
	}

	public void add(SaleListItem item){
		commodities.add(item);
	}
	
	/**
	 * 计算折让前价格
	 * @return
	 */
	public double getBeforePrice(){
		for (int i = 0; i < commodities.size(); i++) {
			beforePrice+=commodities.get(i).getTotal();
		}
		return beforePrice;
	}
	
	/**
	 * 进行po的转换
	 * @return
	 */
	public ArrayList<CommodityItemPO> getCommodities() {
		ArrayList<CommodityItemPO> commoditiesPO = new ArrayList<CommodityItemPO>();
		for (int i = 0; i < commodities.size(); i++) {
			SaleListItem c = commodities.get(i);
			CommodityItemPO po = new CommodityItemPO(c.getID(), c.getName(), 
					c.getType(), c.getNumber(), c.getPrice(), c.getTotal(), c.getRemark());
			commoditiesPO.add(po);
		}
		return commoditiesPO;
	}
}
