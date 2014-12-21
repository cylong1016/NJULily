package businesslogic.approvalbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import message.ResultMessage;
import vo.ValueObject;
import dataenum.BillType;
import blservice.approvalblservice.ApprovalBLService;

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
			return approval.passBill(VOs, billTypes);
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
			return approval.noPassBill(VOs, billTypes);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.REMOTE_EXCEPTION;
		}
	}

}
