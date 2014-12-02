package businesslogic.commoditysortbl;

import java.util.ArrayList;

import dataservice.commoditysortdataservice.CommoditySortDataService;
import po.CommoditySortPO;
import vo.CommoditySortVO;
import businesslogic.accountainitbl.info.CommoditySortInfo_Init;

public class CommoditySortInfo implements CommoditySortInfo_Init{

	CommoditySort sort;
	CommoditySortDataService sortData;
	
	public CommoditySortInfo() {
		sort = new CommoditySort();
		sortData = sort.getCommoditySortData();
	}
	public ArrayList<CommoditySortPO> getSortPOs() {
		return sortData.show();
	}
	
	public ArrayList<CommoditySortVO> getSortVOs(ArrayList<CommoditySortPO> POs) {
		return sort.allPOtoVO(POs);
	}

}
