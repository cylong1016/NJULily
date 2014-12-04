package server.data.promotiondata;

import java.util.ArrayList;

import po.PromotionPO;
import server.common.ParseXML;
import server.data.CommonData;
import dataenum.PromotionType;
import dataservice.promotiondataservice.PromotionDataService;

/**
 * @author cylong
 * @version 2014年12月2日 下午9:01:18
 */
public class PromotionData extends CommonData<PromotionPO> implements PromotionDataService {

	/**
	 * @see dataservice.DataService#init()
	 */
	@Override
	public void init() {
		parsexml = new ParseXML("PromotionData");
		prefix = parsexml.getValue("prefix");
	}

	/**
	 * @see server.data.CommonData#getID()
	 */
	@Override
	public String getID() {
		return prefix + super.getID();
	}

	/**
	 * @see dataservice.promotiondataservice.PromotionDataService#show(dataenum.PromotionType)
	 */
	@Override
	public ArrayList<PromotionPO> show(PromotionType type) {
		ArrayList<PromotionPO> pos = new ArrayList<PromotionPO>();
		for(PromotionPO po : poList.getInList()) {
			if (po.getType().equals(type)) {
				pos.add(po);
			}
		}
		return pos;
	}

}
