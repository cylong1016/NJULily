package server.data.promotiondata;

import po.PromotionPO;
import server.common.ParseXML;
import server.data.CommonData;

/**
 * @author cylong
 * @version 2014年12月2日 下午9:01:18
 */
public class PromotionData extends CommonData<PromotionPO> {

	/**
	 * @see dataservice.DataService#init()
	 */
	@Override
	public void init() {
		parsexml = new ParseXML("UserData");
		prefix = parsexml.getValue("prefix");
	}

	/**
	 * @see server.data.CommonData#getID()
	 */
	@Override
	public String getID() {
		return prefix + super.getID();
	}

}
