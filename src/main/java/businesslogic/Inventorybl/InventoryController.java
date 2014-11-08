package businesslogic.Inventorybl;

import java.util.ArrayList;

import message.ResultMessage;
import vo.CommodityVO;
import vo.GiftCommodityItemVO;
import dataenum.BillType;
import dataenum.Date;
import businesslogicservice.InventoryBLService;

public class InventoryController implements InventoryBLService{

	public ResultMessage viewInventory(Date beginDate, Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage checkRecord() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addCommodity(CommodityVO commodity, int number) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage overflowRecord(BillType billType,
			CommodityVO commodity, int num) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage lossRecor(BillType billType, CommodityVO commodity,
			int num) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage alarmRecord(BillType billType, CommodityVO commodity,
			int num) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage giftRecord(ArrayList<GiftCommodityItemVO> commodities) {
		// TODO Auto-generated method stub
		return null;
	}

}
