package businesslogic.inventorybl;

import java.util.ArrayList;

import message.ResultMessage;
import vo.GiftCommodityItemVO;
import dataenum.BillType;
import businesslogicservice.InventoryBLService;

public class InventoryController implements InventoryBLService{

	public ResultMessage viewInventory(String beginDate, String endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage checkRecord() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addCommodity(String ID, int number) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage giftRecord(ArrayList<GiftCommodityItemVO> commodities) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage overflowRecord(BillType billType, String commodityID,
			int num, String remark) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage lossRecord(BillType billType, String commodityID,
			int num, String remark) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage alarmRecord(BillType billType, String commodityID,
			int nowNum, int alarmNum, String remark) {
		// TODO Auto-generated method stub
		return null;
	}
}
