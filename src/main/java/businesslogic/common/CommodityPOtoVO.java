package businesslogic.common;

import java.util.ArrayList;

import po.CommodityPO;
import vo.commodity.CommodityVO;

public class CommodityPOtoVO {
	public ArrayList<CommodityVO> itemPOToVO(ArrayList<CommodityPO> itemsPO) {
		ArrayList<CommodityVO> itemsVO = new ArrayList<CommodityVO>();
		for(CommodityPO po : itemsPO) {
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
			CommodityVO vo = new CommodityVO(ID, name, type, sortID, inventoryNum, purPrice, salePrice, recentPurpPrice, recentSalePrice, alarmNumber);
			itemsVO.add(vo);
		}
		return itemsVO;
	}
}
