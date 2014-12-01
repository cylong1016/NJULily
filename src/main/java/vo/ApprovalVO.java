package vo;

import java.util.ArrayList;

public class ApprovalVO {
	
	public ValueObject vo;
	
	public ArrayList<SalesVO> salesVOs;
	
	public ArrayList<PurchaseVO> purchaseVOs;
	
	public ArrayList<AccountBillVO> accountBillVOs;
	
	public ArrayList<InventoryBillVO> inventoryBillVOs;
	
	public ArrayList<CashBillVO> cashBillVOs;
	
	public ApprovalVO(ArrayList<SalesVO> salesVOs, ArrayList<PurchaseVO> purchaseVOs, ArrayList<AccountBillVO> accountBillVOs,
			ArrayList<InventoryBillVO> inventoryBillVOs, ArrayList<CashBillVO> cashBillVOs) {
		this.salesVOs = salesVOs;
		this.purchaseVOs = purchaseVOs;
		this.accountBillVOs = accountBillVOs;
		this.inventoryBillVOs = inventoryBillVOs;
		this.cashBillVOs = cashBillVOs;
	}
	
}
