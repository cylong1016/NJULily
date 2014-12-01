package businesslogic.approvalbl;

import java.rmi.Naming;
import java.util.ArrayList;

import config.RMI;
import dataservice.ApprovalDataService;
import dataservice.commondata.DataFactoryService;
import businesslogic.accountbillbl.AccountBillInfo;
import businesslogic.cashbillbl.CashBillInfo;
import businesslogic.inventorybl.InventoryInfo;
import businesslogic.purchasebl.PurchaseInfo;
import businesslogic.salebl.SaleInfo;
import message.ResultMessage;
import vo.AccountBillVO;
import vo.ApprovalVO;
import vo.CashBillVO;
import vo.InventoryBillVO;
import vo.PurchaseVO;
import vo.SalesVO;
import vo.ValueObject;

public class Approval {
	
	private ApprovalDataService approvalData;
	
	
	
	public Approval() {
		this.approvalData = getApprovalData();
	}
	
	
	public ApprovalVO show() {
		ValueObject_Approval<SalesVO> salesVOs = new SaleInfo();
		ValueObject_Approval<PurchaseVO> purchaseVOs = new PurchaseInfo();
		ValueObject_Approval<AccountBillVO> accountBillVOs = new AccountBillInfo();
		ValueObject_Approval<InventoryBillVO> inventoryBillVOs = new InventoryInfo();
		ValueObject_Approval<CashBillVO> cashBillVOs = new CashBillInfo();
		ApprovalVO vo = new ApprovalVO(salesVOs.findApproval(), purchaseVOs.findApproval(),accountBillVOs.findApproval(), inventoryBillVOs.findApproval(), cashBillVOs.findApproval());
		return vo;
	}

	public ResultMessage updateBill(ArrayList<ValueObject> VOs) {
		return null;
	}

	public ResultMessage passBill(ArrayList<ApprovalVO> VOs) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private ApprovalDataService getApprovalData() {
		try {
			DataFactoryService factory = (DataFactoryService)Naming.lookup(RMI.URL);
			ApprovalDataService approvalData = factory.getApprovalData();
			return approvalData;		
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}
}
