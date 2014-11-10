package businesslogic.commoditybl;

import java.util.ArrayList;

import dataenum.FindTypeCommo;
import po.CommodityPO;
import message.ResultMessage;
import vo.CommoditySortVO;
import businesslogicservice.CommodityBLService;

public class CommodityController implements CommodityBLService{
	
	private Commodity commodity;
	
	public CommodityController() {
		// TODO Auto-generated constructor stub
	}
	public ResultMessage addCommo(CommoditySortVO sort, String name,
			String type, double purPrice, double salePrice) {
		// TODO Auto-generated method stub
		return 	commodity.addCommo(sort, name, type, purPrice, salePrice);
	}

	public ResultMessage deletCommo(String name) {
			return commodity.deletCommo(name);
	}

	public ResultMessage updCommo(String id, String name, CommoditySortVO sort,
		String type, double purPrice, double salePrice) {
		return commodity.updCommo(id, name, sort, type, purPrice, salePrice);
	}

	public ArrayList<CommodityPO> findCommo(String info, FindTypeCommo type) {
		return commodity.findCommo(info, type);
	}

	public void showCommo() {
		commodity.showCommo();
		
	}


}
