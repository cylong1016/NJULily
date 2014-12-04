package businesslogic.approvalbl;

import vo.AccountBillVO;
import vo.CashBillVO;
import vo.InventoryBillVO;
import vo.PurchaseVO;
import vo.SalesVO;
import businesslogic.accountbillbl.AccountBillInfo;
import businesslogic.approvalbl.info.AccountBill_Approval;
import businesslogic.approvalbl.info.CashBillInfo_Approval;
import businesslogic.approvalbl.info.InventoryInfo_Approval;
import businesslogic.approvalbl.info.PurchaseInfo_Approval;
import businesslogic.approvalbl.info.SaleInfo_Approval;
import businesslogic.cashbillbl.CashBillInfo;
import businesslogic.inventorybl.InventoryInfo;
import businesslogic.purchasebl.PurchaseInfo;
import businesslogic.salebl.SaleInfo;

public class PassApproval {
	

	public PassApproval() {
	}

	public void passBill(PurchaseVO vo) {
		PurchaseInfo_Approval info = new PurchaseInfo();
		info.pass(vo);
	}

	public void passBill(SalesVO vo) {
		 SaleInfo_Approval info = new SaleInfo();
		 info.pass(vo);
	}

	public void passBill(AccountBillVO vo) {
		AccountBill_Approval info = new AccountBillInfo();
		info.pass(vo);
	}

	public void passBill(InventoryBillVO vo) {
		InventoryInfo_Approval info = new InventoryInfo();
		info.pass(vo);
	}

	public void passBill(CashBillVO vo) {
		CashBillInfo_Approval info = new CashBillInfo();
		info.pass(vo);
	}
	
	

}
