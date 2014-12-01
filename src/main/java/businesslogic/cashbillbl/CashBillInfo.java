package businesslogic.cashbillbl;

import dataenum.Storage;
import dataservice.CashBillDataService;
import vo.CashBillVO;
import businesslogic.recordbl.info.ValueObjectInfo_Record;

public class CashBillInfo implements ValueObjectInfo_Record<CashBillVO>{
	
	private CashBill cashBill;
	
	public CashBillInfo() {
		cashBill = new CashBill();
	}
	
	private CashBillDataService getCashBillData() {
		return cashBill.getCashBillData();
	}
	
	public String getID(String ID, String clientName, String salesman, Storage storage) {
		CashBillDataService cashBillData = getCashBillData();
		return null;
	}

	public CashBillVO find(String ID) {
		// TODO Auto-generated method stub
		return null;
	}
}
