package po;

public class InventoryCommoItemPO {
	
	/** 商品的ID */
	private String ID;
	/** 商品赠送的数量 */
	private int number;
	/** 商品进价 */
	private double purPrice;
	
	public InventoryCommoItemPO(String ID, int number, double purPrice) {
		this.ID = ID;
		this.number = number;
		this.purPrice = purPrice;
	}

	public String getID() {
		return ID;
	}
	public int getNumber() {
		return number;
	}

	public double getPurPrice() {
		return purPrice;
	}
	

}
