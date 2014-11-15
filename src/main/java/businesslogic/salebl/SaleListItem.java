package businesslogic.salebl;

import businesslogic.commoditybl.Commodity;

/**
 * 出货商品清单中要显示
 * 商品的编号，
 * 名称（从商品选择界面选择），
 * 型号，数量（手工输入），
 * 单价（默认为商品信息里的销售价，可修改），
 * 金额（自动生成），
 * 商品备注。
 * 销售单通过审批后，会更改库存数据和客户的应收应付数据。
 * @author Zing
 * @version 2014年11月11日下午9:02:13
 */
public class SaleListItem {
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
	
	public SaleListItem(String name, int number, double price, String remark) {
		this.name = name;
		this.number = number;
		info = new Commodity();
		this.ID = info.getID(name);
		this.type = info.getType(name);
		this.price = price;
		this.total = number * price;
		this.remark = remark;
	}
	
	public String getID(){
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


	
}
