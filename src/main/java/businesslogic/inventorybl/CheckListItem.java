package businesslogic.inventorybl;

import businesslogic.commoditybl.Commodity;
import businesslogic.inventorybl.info.CommodityInfo;

/**
 * 包括之前所有的各种商品的名称，型号，库存数量，库存均价，批次，批号
 * 盘点时，系统自动根据当前盘点时间生成一个截止点，这个点就是批次（日期）批号（序号）
 * @author Zing
 * @version Nov 28, 201410:53:51 AM
 */
public class CheckListItem {
	/** 商品名 */
	private String name;
	/** 类型 */
	private String type;
	/** 库存数量 */
	private int number;
	/** 库存均价 */
	private double avePrice;
	
	private String commodityID;
	
	public CheckListItem(String commodityID) {
		this.commodityID = commodityID;
		CommodityInfo info = new Commodity();
		this.name = info.getName(ID);
		this.type = info.getType(ID);
	}

}
