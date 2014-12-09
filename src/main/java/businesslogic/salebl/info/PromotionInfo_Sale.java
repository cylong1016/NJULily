package businesslogic.salebl.info;

import java.util.ArrayList;

public interface PromotionInfo_Sale {

	/**
	 * 查看是否有合适的商品的促销
	 * @param iD
	 * @param commodityIDs
	 * @author Zing
	 * @version Dec 9, 2014 6:01:53 PM
	 */
	void findFitPromotionCommodity(String iD, ArrayList<String> commodityIDs);

	/**
	 * 查看是否有合适的客户等级的促销
	 * @param iD
	 * @param clientID
	 * @author Zing
	 * @version Dec 9, 2014 6:02:12 PM
	 */
	void findFitPromotionClient(String iD, String clientID);

	/**
	 * 查看是否有合适的总价的促销
	 * @param iD
	 * @param beforePrice
	 * @author Zing
	 * @version Dec 9, 2014 6:02:35 PM
	 */
	void findFitPromotionTotal(String iD, double beforePrice);
	
}
