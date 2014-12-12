package businesslogic.approvalbl;

import vo.AccountBillVO;
import vo.ApprovalVO;
import vo.CashBillVO;
import vo.InventoryBillVO;
import vo.PurchaseVO;
import vo.sale.SalesVO;
import blservice.approvalblservice.ApprovalShowBLService;
import businesslogic.accountbillbl.AccountBillInfo;
import businesslogic.approvalbl.info.ValueObject_Approval;
import businesslogic.cashbillbl.CashBillInfo;
import businesslogic.inventorybl.InventoryInfo;
import businesslogic.purchasebl.PurchaseInfo;
import businesslogic.salebl.SaleInfo;

/**
 * 返回所有需要审批的单子QvQ，分成了五类： 1. 销售类单据（销售出货单，销售退货单） 2. 进货类单据（进货单，进货退货单） 3.
 * 财务类单据（付款单，收款单） 4. 现金费用单 （这个可以根据类型判断 然后和3放在一起显示，都为财务类单据） 5.
 * 库存类单据（报溢单，报损单，赠送单）
 * 
 * @return
 * @author Zing
 * @version Dec 2, 2014 2:09:48 PM
 */
public class ApprovalShow implements ApprovalShowBLService{
	
	
	private ValueObject_Approval<SalesVO> salesVOs;
	private ValueObject_Approval<PurchaseVO> purchaseVOs;
	private ValueObject_Approval<AccountBillVO> accountBillVOs;
	private ValueObject_Approval<InventoryBillVO> inventoryBillVOs;
	private ValueObject_Approval<CashBillVO> cashBillVOs;
	
	public ApprovalShow() {
		salesVOs = new SaleInfo();
		purchaseVOs = new PurchaseInfo();
		accountBillVOs = new AccountBillInfo();
		inventoryBillVOs = new InventoryInfo();
		cashBillVOs = new CashBillInfo();
	}

	@Override
	public ApprovalVO ShowApproving() {
		ApprovalVO vo = new ApprovalVO(salesVOs.findApproval(),
				purchaseVOs.findApproval(), accountBillVOs.findApproval(),
				inventoryBillVOs.findApproval(), cashBillVOs.findApproval());
		return vo;
	}

	@Override
	public ApprovalVO showPass() {
		ApprovalVO vo = new ApprovalVO(salesVOs.showPass(), purchaseVOs.showPass(), accountBillVOs.showPass(), 
				inventoryBillVOs.showPass(), cashBillVOs.showPass());
		return vo;
	}

	@Override
	public ApprovalVO showFailure() {
		ApprovalVO vo = new ApprovalVO(salesVOs.showFailure(), purchaseVOs.showFailure(), accountBillVOs.showFailure(), 
				inventoryBillVOs.showFailure(), cashBillVOs.showFailure());
		return vo;
	}


}
