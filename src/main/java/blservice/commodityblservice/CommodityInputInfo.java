package blservice.commodityblservice;

public class CommodityInputInfo {
	
	public String name;
	
	public String type;
	
	public double purPrice;
	
	public double salePrice;
	
	public String sortID;
	
	public CommodityInputInfo(String name, String type, double purPrice, double salePrice, String sortID) {
		this.name = name;
		this.type = type;
		this.purPrice = purPrice;
		this.salePrice = salePrice;
		this.sortID = sortID;
	}

}
