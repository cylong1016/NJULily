package businesslogic.commoditybl;

import java.util.ArrayList;

import dataenum.FindTypeCommo;
import message.ResultMessage;
import vo.CommodityVO;
import blservice.commodityblservice.CommodityBLService;
import blservice.commodityblservice.CommodityInputInfo;

public class CommodityController implements CommodityBLService{
	
	private Commodity commodity;
	
	public CommodityController() {
		commodity = new Commodity();
	}

	public String getID(String sortID) {
		return commodity.getID(sortID);
	}
	
	public ArrayList<CommodityVO> show() {
		return commodity.show();
		
	}
	
	public CommodityVO show(String ID) {
		return commodity.show(ID);
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

	public ArrayList<CommodityVO> findCommo(String info, FindTypeCommo type) {
		return commodity.findCommo(info, type);
	}

	public ResultMessage setAlarm(ArrayList<String> IDs, int alarmNumber) {
		return commodity.setAlarm(IDs, alarmNumber);
	}




}
