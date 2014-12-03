package server.data.commoditysortdata;

import message.ResultMessage;
import po.CommoditySortPO;
import server.common.ParseXML;
import server.data.CommonData;
import dataservice.commoditysortdataservice.CommoditySortDataService;

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
	 * 名称存在就添加失败
	 * @see server.data.CommonData#insert(po.PersistentObject)
	 */
	@Override
	public ResultMessage insert(CommoditySortPO po) {
		for(CommoditySortPO temp : poList.getInList()) {
			if (temp.getName().equals(po.getName())) {
				return ResultMessage.FAILURE;
			}
		}
		super.insert(po);
		return ResultMessage.SUCCESS;
	}

	/**
	 * 有子类就不能删除
	 * @see server.data.CommonData#delete(java.lang.String)
	 */
	@Override
	public ResultMessage delete(String ID) {
		CommoditySortPO po = find(ID);
		if (po.getChildrenID() == null && po.getCommoditiesID() == null) {
			return super.delete(ID);
		}
		return ResultMessage.FAILURE;
	}

}
