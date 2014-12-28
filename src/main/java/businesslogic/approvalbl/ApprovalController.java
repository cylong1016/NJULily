package businesslogic.approvalbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import log.LogMsgController;
import vo.ValueObject;
import blservice.approvalblservice.ApprovalBLService;
import dataenum.BillType;
import dataenum.ResultMessage;

/**
 * @see blservice.approvalblservice.ApprovalBLService
 * @author cylong
 * @version 2014年12月14日 下午4:53:38
 */
public class ApprovalController implements ApprovalBLService {

	private Approval approval;

	/**
	 * @author cylong
	 * @version 2014年12月14日 下午4:55:16
	 */
	public ApprovalController() {
		approval = new Approval();
	}

	/**
	 * @see blservice.approvalblservice.ApprovalBLService#updateBill(vo.ValueObject, dataenum.BillType)
	 */
	@Override
	public ResultMessage updateBill(ValueObject vo, BillType billType) {
		try {
			ResultMessage res = approval.updateBill(vo, billType);
			if (res.equals(ResultMessage.SUCCESS)) {
				LogMsgController.addLog("更改了单据 " + vo.toString());
			}
			return res;
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.REMOTE_EXCEPTION;
		}
	}

	/**
	 * @see blservice.approvalblservice.ApprovalBLService#passBill(java.util.ArrayList, java.util.ArrayList)
	 */
	@Override
	public ResultMessage passBill(ArrayList<ValueObject> VOs, ArrayList<BillType> billTypes) {
		try {
			ResultMessage res = approval.passBill(VOs, billTypes);
			if (res.equals(ResultMessage.SUCCESS)) {
				LogMsgController.addLog("通过了单据 " + VOs.toString());
			}
			return res;
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.REMOTE_EXCEPTION;
		}
	}

	/**
	 * @see blservice.approvalblservice.ApprovalBLService#noPassBill(java.util.ArrayList, java.util.ArrayList)
	 */
	@Override
	public ResultMessage noPassBill(ArrayList<ValueObject> VOs, ArrayList<BillType> billTypes) {
		try {
			LogMsgController.addLog("审批未通过 " + VOs.toString());
			return approval.noPassBill(VOs, billTypes);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.REMOTE_EXCEPTION;
		}
	}

}
