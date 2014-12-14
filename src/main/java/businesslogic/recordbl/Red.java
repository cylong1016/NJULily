package businesslogic.recordbl;

import java.rmi.RemoteException;

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
import vo.AccountBillVO;
import vo.CashBillVO;
import vo.InventoryBillVO;
import vo.PurchaseVO;
import vo.sale.SalesVO;

public class Red {
	
	private boolean isCopy;
	
	public Red(boolean  isCopy) {
		this.isCopy = isCopy;
	}

	public SalesVO addRed(SalesVO vo) throws RemoteException {
		SaleInfo_Approval info = new SaleOperate();
		return info.addRed(vo, isCopy);
	}

	public PurchaseVO addRed(PurchaseVO vo) throws RemoteException {
		PurchaseInfo_Approval info = new PurchaseInfo();
		return info.addRed(vo, isCopy);
	}

	public InventoryBillVO addRed(InventoryBillVO vo) throws RemoteException {
		InventoryInfo_Approval info = new InventoryInfo();
		return info.addRed(vo, isCopy);
	}

	public AccountBillVO addRed(AccountBillVO vo) throws RemoteException {
		AccountBill_Approval info = new AccountBillInfo();
		return info.addRed(vo, isCopy);
	}

	public CashBillVO addRed(CashBillVO vo) throws RemoteException {
		CashBillInfo_Approval info = new CashBillInfo();
		return info.addRed(vo, isCopy);
	}

}
