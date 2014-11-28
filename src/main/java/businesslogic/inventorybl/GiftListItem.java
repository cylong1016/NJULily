package businesslogic.inventorybl;

import businesslogic.commoditybl.Commodity;
import businesslogic.inventorybl.info.CommodityInfo;

public class GiftListItem {
	private String ID;
	/** 商品名称 */
	private String name;
	/** 商品型号 */
	private String type;
	/** 商品赠送的数量 */
	private int number;
	/** 商品进价 */
	private double purPrice;
	
	private CommodityInfo info;
	
	public GiftListItem() {
	}
	
	public GiftListItem(String ID, int number) {
		info = new Commodity();
		this.number = number;
		this.ID = ID;
		this.name = info.getName(ID);
		this.type = info.getType(ID);
		this.purPrice = info.getPurPrice(ID);
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

	public CommodityInfo getInfo() {
		return info;
	}
	
	
}
