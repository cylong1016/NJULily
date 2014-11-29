package businesslogic.purchasebl;

import businesslogic.commoditybl.Commodity;
import businesslogic.purchasebl.CommodityInfo;

/**
 * 其中入库商品列表包含的信息有：
 * 商品编号，名称（从商品选择界面进行选择），型号（手动选择），数量（手动输入），单价（默认为商品信息中的进价），金额，备注（手动输入）。
 * 没有下划线的部分是自动计算并填充进去的。
 * 进货单通过审批后，会更改库存数据和客户的应收应付数据
 * @author Zing
 * @version Nov 15, 20144:38:31 PM
 */
public class PurchaseListItem {
	/** 商品编号 */
	private String ID;
	/** 商品名称 */
	private String name;
	/** 商品型号 */
	private String type;
	/** 商品数量 */
	private int number;
	/** 商品 单价 */
	private double price;
	/** 总价 */
	private double total;
	/** 商品备注 */
	private String remark;
	
	CommodityInfo info;
	
	public PurchaseListItem(){
	}
	
	public PurchaseListItem(String ID, int number, double price, String remark){
		this.number = number;
		this.ID = ID;
		info = new Commodity();
		this.name = info.getName(ID);
		this.type = info.getType(ID);
		this.price = price;
		this.total = number * price;
		this.remark = remark;
	}

	public String getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public int getNumber() {
		return number;
	}

	public double getPrice() {
		return price;
	}

	public double getTotal() {
		return total;
	}

	public String getRemark() {
		return remark;
	}

	public CommodityInfo getInfo() {
		return info;
	}
	
	
}
