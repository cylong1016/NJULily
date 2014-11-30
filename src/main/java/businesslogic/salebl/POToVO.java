package businesslogic.salebl;

import java.util.ArrayList;

import po.CommodityItemPO;
import vo.CommodityItemVO;
import businesslogic.commoditybl.Commodity;

public class POToVO {

	public ArrayList<CommodityItemVO> itemPOToVO(ArrayList<CommodityItemPO> itemsPO) {
		ArrayList<CommodityItemVO> itemsVO = new ArrayList<CommodityItemVO>();
		for(int i = 0; i < itemsPO.size(); i++) {
			CommodityItemPO po = itemsPO.get(i);
			String ID = po.getID();
			int number = po.getNumber();
			double price = po.getPrice();
			String remark = po.getRemark();
			CommodityInfo_Sale info = new Commodity();
			String name = info.getName(ID);
			String type = info.getType(ID);
			CommodityItemVO vo = new CommodityItemVO(ID, number, price, remark, name, type);
			itemsVO.add(vo);
		}
		return itemsVO;
	}
}
