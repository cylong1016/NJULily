package businesslogic.approvalbl;

import java.rmi.Naming;
import java.util.ArrayList;

import config.RMI;
import dataenum.BillType;
import dataservice.DataFactoryService;
import dataservice.approvaldataservice.ApprovalDataService;
import businesslogic.accountbillbl.AccountBillInfo;
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
import vo.ValueObject;
import vo.sale.SalesVO;

/**
 * 审批
 * @author Zing
 * @version Dec 2, 2014 11:48:42 PM
 */
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
	 * 更新特定单据的数据 直接传递一个数据vo过来，还要有数据的类型
	 * 
	 * @param VOs
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 2:11:54 PM
	 */
	
	public ResultMessage updateBill(ValueObject vo, BillType billType) {
		UpdateApproval update = new UpdateApproval();
		switch (billType) {
		case SALE:
		case SALEBACK:
			return update.updateBill((SalesVO)vo);
		case PURCHASE:
		case PURCHASEBACK:
			return update.updateBill((PurchaseVO)vo);
		case GIFT:
		case OVERFLOW:
		case LOSS:
			return update.updateBill((InventoryBillVO)vo);
		case PAY:
		case EXPENSE:
			return update.updateBill((AccountBillVO)vo);
		case CASH:
			return update.updateBill((CashBillVO)vo);
		default:
			break;
		}
		return ResultMessage.FAILURE;
	}
	

	/**
	 * 单子通过审核（可以批量）
	 * @param VOs
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 9:22:47 PM
	 */
	public ResultMessage passBill(ArrayList<ValueObject> VOs, ArrayList<BillType> billTypes) {
		PassApproval pass = new PassApproval();
		for (int i=0; i < VOs.size(); i++) {
			BillType billType = billTypes.get(i);
			ValueObject vo = VOs.get(i);
			switch (billType) {
			case SALE:
			case SALEBACK:
				pass.passBill((SalesVO)vo);
				 break;
			case PURCHASE:
			case PURCHASEBACK:
				pass.passBill((PurchaseVO)vo);
				 break;
			case GIFT:
			case OVERFLOW:
			case LOSS:
				pass.passBill((InventoryBillVO)vo);
				 break;
			case PAY:
			case EXPENSE:
				pass.passBill((AccountBillVO)vo);
				 break;
			case CASH:
				pass.passBill((CashBillVO)vo);
				 break;
			default:
				break;
			}
		}
		return ResultMessage.SUCCESS;
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
