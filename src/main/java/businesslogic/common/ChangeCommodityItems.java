package businesslogic.common;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CommodityItemPO;
import vo.commodity.CommodityItemVO;
import businesslogic.commoditybl.CommodityInfo;
import businesslogic.salebl.info.CommodityInfo_Sale;

public class ChangeCommodityItems {

	public static ArrayList<CommodityItemVO> itemPOToVO(ArrayList<CommodityItemPO> itemsPO) throws RemoteException {
		ArrayList<CommodityItemVO> itemsVO = new ArrayList<CommodityItemVO>();
		for(CommodityItemPO po : itemsPO) {
			String ID = po.getID();
			int number = po.getNumber();
			double price = po.getPrice();
			String remark = po.getRemark();
			CommodityInfo_Sale info = new CommodityInfo();
			String name = info.getName(ID);
			String type = info.getType(ID);
			CommodityItemVO vo = new CommodityItemVO(ID, number, price, remark, name, type);
			itemsVO.add(vo);
		}
		return itemsVO;
	}

	public static ArrayList<CommodityItemPO> itemsVOtoPO(ArrayList<CommodityItemVO> commodities) {
		ArrayList<CommodityItemPO> commoditiesPO = new ArrayList<CommodityItemPO>();
		for(CommodityItemVO c : commodities) {
			CommodityItemPO po = new CommodityItemPO(c.ID, c.name, c.number, c.price, c.remark);
			commoditiesPO.add(po);
		}
		return commoditiesPO;
	}
}
