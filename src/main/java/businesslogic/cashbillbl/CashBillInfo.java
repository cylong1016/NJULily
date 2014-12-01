package businesslogic.cashbillbl;

import dataenum.Storage;
import vo.CashBillVO;
import businesslogic.recordbl.info.ValueObjectInfo_Record;

public class CashBillInfo implements ValueObjectInfo_Record<CashBillVO>{
	
	private CashBill cashBill;
	
	public CashBillInfo() {
		cashBill = new CashBill();
	}
	
	public String getID(String ID, String clientName, String salesman, Storage storage) {
		// TODO Auto-generated method stub
		return null;
	}

	public CashBillVO show(String ID) {
		// TODO Auto-generated method stub
		return null;
	}
}
