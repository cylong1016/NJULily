package businesslogic.approvalbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import log.LogController;
import message.ResultMessage;
import vo.ValueObject;
import blservice.approvalblservice.ApprovalBLService;
import dataenum.BillType;

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
			LogController.addLog("更改了" + vo.toString());
			return approval.updateBill(vo, billType);
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
			if (res != ResultMessage.SUCCESS) {
				return ResultMessage.FAILURE;
			}
			LogController.addLog("通过了" + VOs.toString());
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
			LogController.addLog("审批未通过" + VOs.toString());
			return approval.noPassBill(VOs, billTypes);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.REMOTE_EXCEPTION;
		}
	}

}
