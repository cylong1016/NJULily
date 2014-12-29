package businesslogic.approvalbl.info;

import java.rmi.RemoteException;

import vo.AccountBillVO;
import vo.CashBillVO;
import vo.InventoryBillVO;
import vo.PurchaseVO;
import vo.sale.SalesVO;
import businesslogic.accountbillbl.AccountBillInfo;
import businesslogic.cashbillbl.CashBillInfo;
import businesslogic.inventorybl.InventoryInfo;
import businesslogic.purchasebl.PurchaseOperate;
import businesslogic.salebl.SaleOperate;

public class NoPassApproval {

	public void noPassBill(PurchaseVO vo) throws RemoteException {
		PurchaseInfo_Approval info = new PurchaseOperate();
		info.noPass(vo);
	}

	public void noPassBill(SalesVO vo) throws RemoteException {
		SaleInfo_Approval info = new SaleOperate();
		info.noPass(vo);
	}

	public void noPassBill(AccountBillVO vo) throws RemoteException {
		AccountBill_Approval info = new AccountBillInfo();
		info.noPass(vo);
	}

	public void noPassBill(InventoryBillVO vo) throws RemoteException {
		InventoryInfo_Approval info = new InventoryInfo();
		info.noPass(vo);
	}

	public void noPassBill(CashBillVO vo) throws RemoteException {
		CashBillInfo_Approval info = new CashBillInfo();
		info.noPass(vo);
	}

}
