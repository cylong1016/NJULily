package server.data;

import java.util.ArrayList;

import po.CommodityPO;
import server.common.ParseXML;
import dataenum.FindTypeCommo;
import dataservice.CommodityDataService;

/**
 * @see dataservice.CommodityDataService
 * @author cylong
 * @version 2014年12月1日 下午6:59:23
 */
public class CommodityData extends CommonData<CommodityPO> implements CommodityDataService {

	/**
	 * @see dataservice.commondata.DataService#init()
	 */
	@Override
	public void init() {
		parsexml = new ParseXML("ClientData");
	}

	/**
	 * @see dataservice.CommodityDataService#find(java.lang.String, dataenum.FindTypeCommo)
	 */
	@Override
	public ArrayList<CommodityPO> find(String keywords, FindTypeCommo type) {
		ArrayList<CommodityPO> commodities = new ArrayList<CommodityPO>();
		keywords = keywords.toLowerCase(); // 为了不区分大小写
		return null;
	}

	/**
	 * @see dataservice.CommodityDataService#findType(java.lang.String)
	 */
	@Override
	public ArrayList<String> findType(String ID) {
		return null;
	}

	/**
	 * @see dataservice.CommodityDataService#getAllID()
	 */
	@Override
	public ArrayList<String> getAllID() {
		return null;
	}

}
