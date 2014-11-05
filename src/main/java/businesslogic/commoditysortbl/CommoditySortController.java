package businesslogic.commoditysortbl;

import dataservice.CommodityManageDataServer;
import message.ResultMessage;
import po.CommoditySortPO;
import vo.CommoditySortVO;
import businesslogicservice.CommoditySortBLService;

public class CommoditySortController implements CommoditySortBLService{
	
	private CommodityManageDataServer commodityManageData;
	
	public ResultMessage addCommoSort(String sortName,
			CommoditySortVO parentSort) {
		
		CommoditySortPO po = 
				new CommoditySortPO(
						commodityManageData.getID(), 
						sortName, 
						commodityManageData.find(parentSort.name), null);
		commodityManageData.insert(po);
		return ResultMessage.SUCCESS;
	}

	
	public ResultMessage deleteCommoSort(CommoditySortVO sort) {
		commodityManageData.delete(sort.name);
		return ResultMessage.SUCCESS;
	}

	public ResultMessage updCommoSort(CommoditySortVO sort) {		
		CommoditySortPO po = 
				new CommoditySortPO(
						sort.ID, 
						sort.name, 
				commodityManageData.find(sort.name).getFather(),
				commodityManageData.find(sort.name).getChildren());
		commodityManageData.update(po);
		return ResultMessage.SUCCESS;
	}

}
