package businesslogic.approvalbl;

import message.ResultMessage;
import vo.AccountBillVO;
import vo.CashBillVO;
import vo.InventoryBillVO;
import vo.PurchaseVO;
import vo.sale.SalesVO;
import businesslogic.accountbillbl.AccountBillInfo;
import businesslogic.approvalbl.info.AccountBill_Approval;
import businesslogic.approvalbl.info.CashBillInfo_Approval;
import businesslogic.approvalbl.info.InventoryInfo_Approval;
import businesslogic.approvalbl.info.PurchaseInfo_Approval;
import businesslogic.approvalbl.info.SaleInfo_Approval;
import businesslogic.cashbillbl.CashBillInfo;
import businesslogic.inventorybl.InventoryInfo;
import businesslogic.purchasebl.PurchaseInfo;
import businesslogic.salebl.SaleOperate;
/**
 * 更新各种单子
 * @author Zing
 * @version Dec 6, 2014 4:49:50 PM
 */
public class UpdateApproval {
	
	public ResultMessage updateBill(SalesVO vo) {
		SaleInfo_Approval info = new SaleOperate();
		return info.update(vo);
	}
	
	public ResultMessage updateBill(PurchaseVO vo) {
		PurchaseInfo_Approval info = new PurchaseInfo();
		return info.update(vo);
	}
	
	public ResultMessage updateBill(InventoryBillVO vo) {
		InventoryInfo_Approval info = new InventoryInfo();
		return info.update(vo);
	}
	
	public ResultMessage updateBill(CashBillVO vo) {
		CashBillInfo_Approval info = new CashBillInfo();
		return info.update(vo);
	}
	
	public ResultMessage updateBill(AccountBillVO vo) {
		AccountBill_Approval info = new AccountBillInfo();
		return info.update(vo);
	}
}
