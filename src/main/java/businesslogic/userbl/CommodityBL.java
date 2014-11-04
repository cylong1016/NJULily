package businesslogic.userbl;

import po.CommodityManagePO;
import po.CommodityPO;
import dataservice.CommodityDataService;
import dataservice.CommoditySortDataService;
import message.ResultMessage;
import vo.CommodityManageVO;
import businesslogicservice.CommodityBLService;

public class CommodityBL implements CommodityBLService{
	
	private CommodityDataService commodityData;
	private CommoditySortDataService commodityManageData;
	
	public CommodityBL(CommodityDataService commodityData) {
		this.commodityData = commodityData;
	}
	
	public CommodityBL(CommoditySortDataService commodityManageData){
		this.commodityManageData = commodityManageData;
	}

	public ResultMessage addCommoSort(String sortName,
			CommodityManageVO parentSort) {
		
		CommodityManagePO po = 
				new CommodityManagePO(
						commodityManageData.getID(), 
						sortName, 
						commodityManageData.find(parentSort.name), null);
		commodityManageData.insert(po);
		return ResultMessage.SUCCESS;
	}

	
	public ResultMessage deleteCommoSort(CommodityManageVO sort) {
		commodityManageData.delete(sort.name);
		return ResultMessage.SUCCESS;
	}

	public ResultMessage updCommoSort(CommodityManageVO sort) {		
		CommodityManagePO po = 
				new CommodityManagePO(
						sort.ID, 
						sort.name, 
				commodityManageData.find(sort.name).getFather(),
				commodityManageData.find(sort.name).getChildren());
		commodityManageData.update(po);
		return ResultMessage.SUCCESS;
	}

	public ResultMessage addCommo(CommodityManageVO sort, String name,
			String type, double purPrice, double salePrice) {
		// TODO Auto-generated method stub
		CommodityPO po = 
				new CommodityPO(
						commodityData.getID(), 
						name, 
						commodityManageData.find(sort.name), 
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

	public ResultMessage updCommo(String id, String name, CommodityManageVO sort,
		String type, double purPrice, double salePrice) {
		CommodityPO po = new CommodityPO(
				id, name, 
				commodityManageData.find(sort.name), 
				type, purPrice, salePrice);
		
		return commodityData.update(po);
	}

	public ResultMessage findCommo(String name, String id, String type) {
		// TODO Auto-generated method stub
		return null;
	}


}
