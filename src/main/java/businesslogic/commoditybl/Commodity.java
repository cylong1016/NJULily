package businesslogic.commoditybl;

import java.rmi.Naming;
import java.util.ArrayList;

import config.RMI;
import message.ResultMessage;
import po.CommodityPO;
import vo.CommodityVO;
import blservice.commodityblservice.CommodityInputInfo;
import businesslogic.inventorybl.info.CommodityInfo_Inventory;
import businesslogic.promotionbl.CommodityInfo_Promotion;
import businesslogic.salebl.CommodityInfo_Sale;
import dataenum.FindTypeCommo;
import dataservice.CommodityDataService;
import dataservice.CommoditySortDataService;
import dataservice.commondata.DataFactoryService;
/**
 * 商品管理
 * @author Zing
 * @version 2014年11月9日下午2:53:19
 */
public class Commodity implements CommodityInfo_Sale, businesslogic.purchasebl.CommodityInfo_Purchase, CommodityInfo_Inventory, CommodityInfo_Promotion{
	
	private CommodityDataService commodityData;
	
	private CommoditySortDataService commoditySortData;
	
	private CommodityPO po;
	
	private String ID;
	
	public Commodity() {
		try {
			DataFactoryService factory = (DataFactoryService)Naming.lookup(RMI.URL);
			commodityData = factory.getCommodityData();
			commoditySortData = factory.getCommoditySortData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getID(){
		ID = commodityData.getID();
		return ID;
	}
	
	public ResultMessage addCommo(CommodityInputInfo info) {
		po = new CommodityPO(ID, info.name, commoditySortData.find(info.sortID), info.type, info.purPrice, info.salePrice);
		commodityData.insert(po);
		return ResultMessage.SUCCESS;
	}

	public ResultMessage deletCommo(String id) {
		po = commodityData.find(id, FindTypeCommo.ID).get(0);
		if (po!=null) {
			return commodityData.delete(po.getID());
		}
		else 
			return ResultMessage.FAILURE;
	}

	public ResultMessage updCommo(String ID, CommodityInputInfo info){
		po = new CommodityPO(ID, info.name, commoditySortData.find(info.sortID), info.type, info.purPrice, info.salePrice);	
		return commodityData.update(po);
	}

	public ArrayList<CommodityPO> findCommo(String info, FindTypeCommo type) {
		return commodityData.find(info, type);
	}

	public ArrayList<CommodityVO> showCommo() {
		//
		return null;
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
