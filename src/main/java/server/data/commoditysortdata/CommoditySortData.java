package server.data.commoditysortdata;

import message.ResultMessage;
import dataservice.commoditysortdataservice.CommoditySortDataService;
import po.CommoditySortPO;
import server.common.Common;
import server.common.ParseXML;
import server.data.CommonData;

/**
 * @see dataservice.commoditysortdataservice.CommoditySortDataService
 * @author cylong
 * @version 2014年12月1日 下午9:47:21
 */
public class CommoditySortData extends CommonData<CommoditySortPO> implements CommoditySortDataService {

	/**
	 * @see dataservice.DataService#init()
	 */
	@Override
	public void init() {
		parsexml = new ParseXML("CommoditySortData");
	}

	/**
	 * @see dataservice.commoditysortdataservice.CommoditySortDataService#getID(java.lang.String)
	 */
	@Override
	public String getID(String fatherID) {
		if (fatherID == null) {
			return getID();
		}
		CommoditySortPO po = find(fatherID);
		String newID = po.getID() + "-" + getID();
		return newID;
	}

	/**
	 * 得到分类当前ID
	 * @see server.data.CommonData#getID()
	 */
	@Override
	public String getID() {
		if (poList.isEmpty()) {
			return initID;
		}
		String currentID = poList.get(poList.size() - 1).getID();
		String[] splitID = currentID.split("-");
		String newID = Common.intToString(Integer.parseInt(splitID[splitID.length - 1]) + 1, IDMaxBit);
		return newID;
	}

	@Override
	public ResultMessage delete(String ID) {
		CommoditySortPO po = find(ID);
		if (po.getChildrenID() == null && po.getCommoditiesID() == null) {
			return super.delete(ID);
		}
		return ResultMessage.FAILURE;
	}

}
