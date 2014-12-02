package businesslogic.approvalbl;

import java.rmi.Naming;
import java.util.ArrayList;

import config.RMI;
import dataenum.BillType;
import dataservice.DataFactoryService;
import dataservice.approvaldataservice.ApprovalDataService;
import businesslogic.accountbillbl.AccountBillInfo;
import businesslogic.approvalbl.info.AccountBill_Approval;
import businesslogic.approvalbl.info.CashBillInfo_Approval;
import businesslogic.approvalbl.info.InventoryInfo_Approval;
import businesslogic.approvalbl.info.PurchaseInfo_Approval;
import businesslogic.approvalbl.info.SaleInfo_Approval;
import businesslogic.approvalbl.info.ValueObject_Approval;
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

	/**
	 * 返回所有需要审批的单子QvQ，分成了五类： 1. 销售类单据（销售出货单，销售退货单） 2. 进货类单据（进货单，进货退货单） 3.
	 * 财务类单据（付款单，收款单） 4. 现金费用单 （这个可以根据类型判断 然后和3放在一起显示，都为财务类单据） 5.
	 * 库存类单据（报溢单，报损单，赠送单）
	 * 
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 2:09:48 PM
	 */
	public ApprovalVO show() {
		ValueObject_Approval<SalesVO> salesVOs = new SaleInfo();
		ValueObject_Approval<PurchaseVO> purchaseVOs = new PurchaseInfo();
		ValueObject_Approval<AccountBillVO> accountBillVOs = new AccountBillInfo();
		ValueObject_Approval<InventoryBillVO> inventoryBillVOs = new InventoryInfo();
		ValueObject_Approval<CashBillVO> cashBillVOs = new CashBillInfo();
		ApprovalVO vo = new ApprovalVO(salesVOs.findApproval(),
				purchaseVOs.findApproval(), accountBillVOs.findApproval(),
				inventoryBillVOs.findApproval(), cashBillVOs.findApproval());
		return vo;
	}

	/**
	 * 更新特定单据的数据 直接传递一个数据vo过来
	 * 
	 * @param VOs
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 2:11:54 PM
	 */
	
	public ResultMessage updateBill(ValueObject vo, BillType billType) {
		switch (billType) {
		case SALE:
		case SALEBACK:
			return updateBill((SalesVO)vo);
		case PURCHASE:
		case PURCHASEBACK:
			return updateBill((PurchaseVO)vo);
		case GIFT:
		case OVERFLOW:
		case LOSS:
			return updateBill((InventoryBillVO)vo);
		case PAY:
		case EXPENSE:
			return updateBill((AccountBillVO)vo);
		case CASH:
			return updateBill((CashBillVO)vo);
		default:
			break;
		}
		return ResultMessage.FAILURE;
	}
	
	private ResultMessage updateBill(SalesVO vo) {
		SaleInfo_Approval info = new SaleInfo();
		return info.update(vo);
	}
	
	private ResultMessage updateBill(PurchaseVO vo) {
		PurchaseInfo_Approval info = new PurchaseInfo();
		return info.update(vo);
	}
	
	private ResultMessage updateBill(InventoryBillVO vo) {
		InventoryInfo_Approval info = new InventoryInfo();
		return info.update(vo);
	}
	
	private ResultMessage updateBill(CashBillVO vo) {
		CashBillInfo_Approval info = new CashBillInfo();
		return info.update(vo);
	}
	
	private ResultMessage updateBill(AccountBillVO vo) {
		AccountBill_Approval info = new AccountBillInfo();
		return info.update(vo);
	}

	/**
	 * 单子通过审核（可以批量，单要同一种类型的才可以）
	 * @param VOs
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 9:22:47 PM
	 */
	public ResultMessage passBill(ArrayList<ValueObject> VOs) {
		return null;
	}
	

	private ApprovalDataService getApprovalData() {
		try {
			DataFactoryService factory = (DataFactoryService) Naming
					.lookup(RMI.URL);
			ApprovalDataService approvalData = factory.getApprovalData();
			return approvalData;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
