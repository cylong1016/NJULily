package businesslogic.inventorybl;

import java.rmi.RemoteException;

import businesslogic.commoditybl.CommodityInfo;
import businesslogic.inventorybl.info.CommodityInfo_Inventory;

public class BillListItem {

	private String ID;
	/** 商品名称 */
	private String name;
	/** 商品型号 */
	private String type;
	/** 商品赠送的数量 */
	private int number;
	/** 商品进价 */
	private double purPrice;
	/** 商品总价 */
	private double total;

	private CommodityInfo_Inventory info;

	public BillListItem() {
	}

	public BillListItem(String ID, int number) throws RemoteException {
		info = new CommodityInfo();
		this.number = number;
		this.ID = ID;
		this.name = info.getName(ID);
		this.type = info.getType(ID);
		this.purPrice = info.getPurPrice(ID);
		this.total = number * purPrice;
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

	public double getPurPrice() {
		return purPrice;
	}

	public CommodityInfo_Inventory getInfo() {
		return info;
	}

	public double getTotal() {
		return total;
	}

}
