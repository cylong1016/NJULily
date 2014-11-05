package businesslogic.commoditysortbl;

import dataservice.CommoditySortDataService;
import message.ResultMessage;
import po.CommoditySortPO;
import vo.CommoditySortVO;
import businesslogicservice.CommoditySortBLService;

public class CommoditySortController implements CommoditySortBLService{
	
	private CommoditySortDataService commoditySortData;
	
	public ResultMessage addCommoSort(String sortName,
			CommoditySortVO parentSort) {
		
		CommoditySortPO po = 
				new CommoditySortPO(
						commoditySortData.getID(), 
						sortName, 
						commoditySortData.find(parentSort.name), null);
		commoditySortData.insert(po);
		return ResultMessage.SUCCESS;
	}

	
	public ResultMessage deleteCommoSort(CommoditySortVO sort) {
		commoditySortData.delete(sort.name);
		return ResultMessage.SUCCESS;
	}

	public ResultMessage updCommoSort(CommoditySortVO sort) {		
		CommoditySortPO po = 
				new CommoditySortPO(
						sort.ID, 
						sort.name, 
						commoditySortData.find(sort.name).getFather(),
						commoditySortData.find(sort.name).getChildren());
						commoditySortData.update(po);
		return ResultMessage.SUCCESS;
	}

}
