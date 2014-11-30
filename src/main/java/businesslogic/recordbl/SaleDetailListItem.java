package businesslogic.recordbl;

import businesslogic.recordbl.info.SaleInfo_Record;
import businesslogic.salebl.Sale;

public class SaleDetailListItem {
	public String ID;
	/** 商品名称 */
	public String name;
	/** 商品型号 */
	public String type;
	/** 商品数量 */
	public int number;
	/** 商品 单价 */
	public double price;
	/** 总价 */
	public double total;
	
	public SaleInfo_Record info;
	
	public SaleDetailListItem(String ID, String commodityName) {
		info = new Sale();
		this.ID = info.getCommodity(ID, commodityName);
		if (this.ID != null) {
			this.name = info.getName(this.ID);
			this.type = info.getType(this.ID);
			this.number = info.getNumber(this.ID);
			this.price = info.getPrice(this.ID);
			this.total = price * number;
		}
	}

}
