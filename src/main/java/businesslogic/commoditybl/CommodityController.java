package businesslogic.commoditybl;

import java.util.ArrayList;
import dataenum.FindTypeCommo;
import po.CommodityPO;
import message.ResultMessage;
import vo.CommodityVO;
import businesslogicservice.CommodityBLService;

public class CommodityController implements CommodityBLService{
	
	private Commodity commodity;
	
	public CommodityController() {
		commodity = new Commodity();
	}
	
	public ResultMessage addCommo(String sortID, String name, String type, double purPrice, double salePrice) {
		return 	commodity.addCommo(sortID, name, type, purPrice, salePrice);
	}

	public ResultMessage deletCommo(String ID) {
			return commodity.deletCommo(ID);
	}

	public ResultMessage updCommo(String sortID, String ID, String name, String type, double purPrice, double salePrice) {
		return commodity.updCommo(sortID, ID, name, type, purPrice, salePrice);
	}

	public ArrayList<CommodityPO> findCommo(String info, FindTypeCommo type) {
		return commodity.findCommo(info, type);
	}

	public ArrayList<CommodityVO> showCommo() {
		return commodity.showCommo();
		
	}


}
