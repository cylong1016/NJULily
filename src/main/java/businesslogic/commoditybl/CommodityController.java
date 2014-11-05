package businesslogic.commoditybl;

import dataservice.CommodityDataService;
import dataservice.CommoditySortDataService;
import po.CommodityPO;
import message.ResultMessage;
import vo.CommoditySortVO;
import businesslogicservice.CommodityBLService;

public class CommodityController implements CommodityBLService{
	
	private CommodityDataService commodityData;
	private CommoditySortDataService commoditySortData;
	
	public CommodityController(CommodityDataService commodityData) {
		this.commodityData = commodityData;
	}
	
	public CommodityController(CommoditySortDataService commoditySortData){
		this.commoditySortData = commoditySortData;
	}


	public ResultMessage addCommo(CommoditySortVO sort, String name,
			String type, double purPrice, double salePrice) {
		// TODO Auto-generated method stub
		CommodityPO po = 
				new CommodityPO(
						commodityData.getID(), 
						name, 
						commoditySortData.find(sort.name), 
						type, purPrice, salePrice);
		commodityData.insert(po);
		return ResultMessage.SUCCESS;
	}

	public ResultMessage deletCommo(String name) {
		CommodityPO po = commodityData.find(name);
		if (po!=null) {
			return commodityData.delete(po.getId());
		}
		else 
			return ResultMessage.FAILURE;
	}

	public ResultMessage updCommo(String id, String name, CommoditySortVO sort,
		String type, double purPrice, double salePrice) {
		CommodityPO po = new CommodityPO(
				id, name, 
				commoditySortData.find(sort.name), 
				type, purPrice, salePrice);
		
		return commodityData.update(po);
	}

	public ResultMessage findCommo(String name, String id, String type) {
		// TODO Auto-generated method stub
		return null;
	}


}
