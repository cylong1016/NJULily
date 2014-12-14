package businesslogic.recordbl;

import java.rmi.RemoteException;

import businesslogic.recordbl.info.SaleInfo_Record;
import businesslogic.salebl.SaleInfo;

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
	
	public SaleDetailListItem(String ID, String commodityName) throws RemoteException {
		info = new SaleInfo();
		this.ID = info.getCommodityID(ID, commodityName);
		if (this.ID != null) {
			this.name = info.getCommodityName(this.ID);
			this.type = info.getCommodityType(this.ID);
			this.number = info.getCommodityNumber(this.ID);
			this.price = info.getCommodityPrice(this.ID);
			this.total = price * number;
		}
	}

}
