package businesslogic.commoditybl;

import java.rmi.Naming;
import java.util.ArrayList;

import message.ResultMessage;
import po.CommodityPO;
import vo.CommodityVO;
import businesslogic.salebl.CommodityInfo;
import dataenum.FindTypeCommo;
import dataservice.CommodityDataService;
import dataservice.CommoditySortDataService;
import dataservice.DataFactoryService;
/**
 * 商品管理
 * @author Zing
 * @version 2014年11月9日下午2:53:19
 */
public class Commodity implements CommodityInfo, businesslogic.purchasebl.CommodityInfo, businesslogic.inventorybl.info.CommodityInfo{
	
	private CommodityDataService commodityData;
	
	private CommoditySortDataService commoditySortData;
	
	private CommodityPO po;
	
	private String ID;
	
	public Commodity() {
		try {
			DataFactoryService factory = (DataFactoryService)Naming.lookup("rmi://127.0.0.1:1994/factory");
			commodityData = (CommodityDataService)factory.getCommodityData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getID(){
		ID = commodityData.getID();
		return ID;
	}
	
	public ResultMessage addCommo(String sortID, String name, String type, double purPrice, double salePrice) {
		po = new CommodityPO(getID(), name, commoditySortData.find(sortID), type, purPrice, salePrice);
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

	public ResultMessage updCommo(String sortID, String ID, String name, String type, double purPrice, double salePrice){
		po = new CommodityPO(ID, name, commoditySortData.find(sortID), type, purPrice, salePrice);	
		return commodityData.update(po);
	}

	public ArrayList<CommodityPO> findCommo(String info, FindTypeCommo type) {
		return commodityData.find(info, type);
	}

	public ArrayList<CommodityVO> showCommo() {
		// TODO
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
