package businesslogic.approvalbl;

import businesslogic.accountbillbl.AccountBillInfo;
import businesslogic.accountbl.AccountInfo;
import businesslogic.approvalbl.info.AccountBill_Approval;
import businesslogic.approvalbl.info.CashBillInfo_Approval;
import businesslogic.cashbillbl.CashBillInfo;
import vo.AccountBillVO;
import vo.CashBillVO;
import vo.InventoryBillVO;
import vo.PurchaseVO;
import vo.SalesVO;

public class PassApproval {
	

	public PassApproval() {
	}

	public void passBill(PurchaseVO vo) {
		
	}

	public void passBill(SalesVO vo) {
		 
	}

	public void passBill(AccountBillVO vo) {
		AccountBill_Approval info = new AccountBillInfo();
		// TODO
		info.pass(vo);
	}

	public void passBill(InventoryBillVO vo) {
		
	}

	public void passBill(CashBillVO vo) {
		CashBillInfo_Approval info = new CashBillInfo();
		info.pass(vo);
	}
	
	

}
