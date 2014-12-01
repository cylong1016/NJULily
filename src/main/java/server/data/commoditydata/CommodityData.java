package server.data.commoditydata;

import java.util.ArrayList;

import message.ResultMessage;
import po.CommodityPO;
import po.CommoditySortPO;
import server.common.ParseXML;
import server.data.CommonData;
import server.data.commoditysortdata.CommoditySortData;
import dataenum.FindTypeCommo;
import dataservice.commoditydataservice.CommodityDataService;

/**
 * @see dataservice.commoditydataservice.CommodityDataService
 * @author cylong
 * @version 2014年12月1日 下午6:59:23
 */
public class CommodityData extends CommonData<CommodityPO> implements CommodityDataService {

	/**
	 * @see dataservice.DataService#init()
	 */
	@Override
	public void init() {
		parsexml = new ParseXML("CommodityData");
		prefix = parsexml.getValue("prefix");
	}

	/**
	 * @see dataservice.commoditydataservice.CommodityDataService#getID(java.lang.String)
	 */
	@Override
	public String getID(String fatherID) {
		if (fatherID == null) {
			return null;
		}
		CommoditySortData sortData = new CommoditySortData();
		CommoditySortPO sortPO = sortData.find(fatherID);
		String newID = sortPO.getID() + "-" + prefix + super.getID();
		return newID;
	}

	/**
	 * @see dataservice.commoditydataservice.CommodityDataService#find(java.lang.String,
	 *      dataenum.FindTypeCommo)
	 */
	@Override
	public ArrayList<CommodityPO> find(String keywords, FindTypeCommo type) {
		ArrayList<CommodityPO> commodities = new ArrayList<CommodityPO>();
		keywords = keywords.toLowerCase(); // 为了不区分大小写
		if (type == null) {	// 查询商品全部信息
			for(CommodityPO commodity : poList.getInList()) {
				if (commodity.toString().toLowerCase().contains(keywords)) {
					commodities.add(commodity);
				}
			}
			return commodities;
		}
		switch(type) {
		case ID:
			for(CommodityPO commodity : poList.getInList()) {
				if (commodity.getID().toLowerCase().contains(keywords)) {
					commodities.add(commodity);
				}
			}
			break;
		case NAME:
			for(CommodityPO commodity : poList.getInList()) {
				if (commodity.getName().toLowerCase().contains(keywords)) {
					commodities.add(commodity);
				}
			}
			break;
		case NUMBER:
			for(CommodityPO commodity : poList.getInList()) {
				if (Integer.toString(commodity.getInventoryNum()).contains(keywords)) {
					commodities.add(commodity);
				}
			}
			break;
		case PURCHASE:
			for(CommodityPO commodity : poList.getInList()) {
				if (Double.toString(commodity.getPurPrice()).contains(keywords)) {
					commodities.add(commodity);
				}
			}
			break;
		case RECENTPUR:
			for(CommodityPO commodity : poList.getInList()) {
				if (Double.toString(commodity.getRecentPurPrice()).contains(keywords)) {
					commodities.add(commodity);
				}
			}
			break;
		case RECENTSALE:
			for(CommodityPO commodity : poList.getInList()) {
				if (Double.toString(commodity.getRecentSalePrice()).contains(keywords)) {
					commodities.add(commodity);
				}
			}
			break;
		case SALE:
			for(CommodityPO commodity : poList.getInList()) {
				if (Double.toString(commodity.getSalePrice()).contains(keywords)) {
					commodities.add(commodity);
				}
			}
			break;
		case TYPE:
			for(CommodityPO commodity : poList.getInList()) {
				if (commodity.getType().toString().toLowerCase().contains(keywords)) {
					commodities.add(commodity);
				}
			}
			break;
		default:
			break;
		}
		return commodities;
	}

	/**
	 * @see dataservice.commoditydataservice.CommodityDataService#getAllID()
	 */
	@Override
	public ArrayList<String> getAllID() {
		ArrayList<String> IDs = new ArrayList<String>();
		for(CommodityPO commodity : poList.getInList()) {
			IDs.add(commodity.getID());
		}
		return IDs;
	}

	/**
	 * 若商品已经被进货或者销售就不能删除
	 * @return 处理结果
	 * @author cylong
	 * @version 2014年12月1日 下午9:26:31
	 */
	@Override
	public ResultMessage delete(String ID) {
		CommodityPO po = find(ID);
		if ((po.getRecentPurPrice() + po.getRecentSalePrice()) != 0) {
			return ResultMessage.FAILURE;
		}
		return super.delete(ID);
	}

}
