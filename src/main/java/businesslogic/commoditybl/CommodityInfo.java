package businesslogic.commoditybl;

import java.util.ArrayList;

import po.CommodityPO;
import dataservice.commoditydataservice.CommodityDataService;
import businesslogic.inventorybl.info.CommodityInfo_Inventory;
import businesslogic.promotionbl.CommodityInfo_Promotion;
import businesslogic.salebl.CommodityInfo_Sale;

public class CommodityInfo implements CommodityInfo_Sale, businesslogic.purchasebl.CommodityInfo_Purchase, CommodityInfo_Inventory, CommodityInfo_Promotion{
	
	private Commodity commodity;
	
	private CommodityDataService commodityData;
	
	private CommodityPO po;
	
	public CommodityInfo() {
		commodity = new Commodity();
		this.commodityData = commodity.getCommodityData();
	}
	
	public String getType(String ID) {
		po = commodityData.find(ID);
		return 	po.getType();
	}

	public String getName(String ID) {
		po = commodityData.find(ID);
		return po.getName();
	}

	public ArrayList<String> getAllID() {
		return 	commodityData.getAllID();
	}

	public int getNumber(String ID) {
		po = commodityData.find(ID);
		return po.getInventoryNum();
	}

	public double getAvePrice(String ID) {
		po = commodityData.find(ID);
		return po.getPurPrice();
	}

	public double getPurPrice(String ID) {
		po = commodityData.find(ID);
		return po.getPurPrice();
	}

}
