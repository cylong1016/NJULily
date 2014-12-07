package businesslogic.commoditybl;

import po.CommodityPO;
import vo.commodity.CommodityVO;

public class CommodityTrans {
	
	/**
	 * 把一个商品PO转换成VO
	 * @param po
	 * @return 一个商品VO
	 * @author Zing
	 * @version Dec 1, 2014 9:33:15 PM
	 */
	public CommodityVO POtoVO(CommodityPO po) {
		String ID = po.getID();
		String name = po.getName();
		String type = po.getType();
		String sortID = po.getSortID();
		int inventoryNum = po.getInventoryNum();
		double purPrice = po.getPurPrice();
		double salePrice = po.getSalePrice();
		double recentPurpPrice = po.getRecentPurPrice();
		double recentSalePrice = po.getRecentSalePrice();
		int alarmNumber = po.getAlarmNumber();
		CommodityVO vo = new CommodityVO(ID, name, type, sortID, inventoryNum,
				purPrice, salePrice, recentPurpPrice, recentSalePrice,
				alarmNumber);
		return vo;
	}


}
