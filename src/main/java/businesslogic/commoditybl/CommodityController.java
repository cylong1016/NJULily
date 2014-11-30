package businesslogic.commoditybl;

import java.util.ArrayList;

import dataenum.FindTypeCommo;
import po.CommodityPO;
import message.ResultMessage;
import vo.CommodityVO;
import blservice.commodityblservice.CommodityBLService;
import blservice.commodityblservice.CommodityInputInfo;

public class CommodityController implements CommodityBLService{
	
	private Commodity commodity;
	
	public CommodityController() {
		commodity = new Commodity();
	}

	public String getID() {
		return commodity.getID();
	}
	
	public ResultMessage addCommo(CommodityInputInfo info) {
		return 	commodity.addCommo(info);
	}

	public ResultMessage deletCommo(String ID) {
			return commodity.deletCommo(ID);
	}

	public ResultMessage updCommo(String ID, CommodityInputInfo info) {
		return commodity.updCommo(ID,info);
	}

	public ArrayList<CommodityPO> findCommo(String info, FindTypeCommo type) {
		return commodity.findCommo(info, type);
	}

	public ArrayList<CommodityVO> showCommo() {
		return commodity.showCommo();
		
	}


}
