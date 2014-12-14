package businesslogic.commoditysortbl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.commoditysortdataservice.CommoditySortDataService;
import po.CommoditySortPO;
import vo.commodity.CommoditySortVO;
import businesslogic.accountainitbl.info.CommoditySortInfo_Init;
import businesslogic.commoditybl.CommoditySort_Commodity;

public class CommoditySortInfo implements CommoditySortInfo_Init, CommoditySort_Commodity {

	CommoditySort sort;
	CommoditySortDataService sortData;

	public CommoditySortInfo() throws MalformedURLException, RemoteException, NotBoundException {
		sort = new CommoditySort();
		sortData = sort.getCommoditySortData();
	}

	public ArrayList<CommoditySortPO> getSortPOs() throws RemoteException {
		return sortData.show();
	}

	public ArrayList<CommoditySortVO> getSortVOs(ArrayList<CommoditySortPO> POs) {
		return sort.allPOtoVO(POs);
	}

	public void deleteCommodity(String sortID, String ID) throws RemoteException {
		CommoditySortPO sortPO = sortData.find(sortID);
		sortPO.removeCommodity(ID);
		sortData.update(sortPO);
	}

	public void addCommodity(String sortID, String ID) throws RemoteException {
		CommoditySortPO sortPO = sortData.find(sortID);
		sortPO.addCommodityID(ID);
		sortData.update(sortPO);
	}

	public boolean hasLeaf(String sortID) throws RemoteException {
		CommoditySortPO sortPO = sortData.find(sortID);
		if (sortPO.getChildrenID() == null) {
			return false;
		} else {
			if (sortPO.getChildrenID().isEmpty()) {
				return false;
			}
		}
		return true;
	}

}
