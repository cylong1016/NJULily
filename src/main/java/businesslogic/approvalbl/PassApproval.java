  package businesslogic.approvalbl;

import java.rmi.RemoteException;

import dataenum.ResultMessage;
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
import businesslogic.purchasebl.PurchaseOperate;
import businesslogic.salebl.SaleOperate;

public class PassApproval {
	

	public PassApproval() {
	}

	public ResultMessage passBill(PurchaseVO vo) throws RemoteException {
		PurchaseInfo_Approval info = new PurchaseOperate();
		return info.pass(vo);
	}

	public ResultMessage passBill(SalesVO vo) throws RemoteException {
		 SaleInfo_Approval info = new SaleOperate();
		 return info.pass(vo);
	}

	public ResultMessage passBill(AccountBillVO vo) throws RemoteException {
		AccountBill_Approval info = new AccountBillInfo();
		info.pass(vo);
		return ResultMessage.SUCCESS;
	}

	public ResultMessage passBill(InventoryBillVO vo) throws RemoteException {
		InventoryInfo_Approval info = new InventoryInfo();
		info.pass(vo);
		return ResultMessage.SUCCESS;
	}

	public ResultMessage passBill(CashBillVO vo) throws RemoteException {
		CashBillInfo_Approval info = new CashBillInfo();
		info.pass(vo);
		return ResultMessage.SUCCESS;
	}
	
	

}
