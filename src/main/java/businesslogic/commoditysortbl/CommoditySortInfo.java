package businesslogic.commoditysortbl;

import java.util.ArrayList;

import dataservice.commoditysortdataservice.CommoditySortDataService;
import po.CommoditySortPO;
import vo.commodity.CommoditySortVO;
import businesslogic.accountainitbl.info.CommoditySortInfo_Init;
import businesslogic.commoditybl.CommoditySort_Commodity;

public class CommoditySortInfo implements CommoditySortInfo_Init, CommoditySort_Commodity{

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
	
	public void deleteCommodity(String sortID, String ID) {
		CommoditySortPO sortPO = sortData.find(sortID);
		sortPO.removeCommodity(ID);
		sortData.update(sortPO);
	}
	
	public void addCommodity(String sortID, String ID) {
		CommoditySortPO sortPO = sortData.find(sortID);
		sortPO.addCommodityID(ID);
		sortData.update(sortPO);
	}

}
