package businesslogic.approvalbl;

import java.rmi.RemoteException;

import log.LogController;
import vo.ApprovalVO;
import blservice.approvalblservice.ApprovalShowBLService;

/**
 * @see blservice.approvalblservice.ApprovalShowBLService
 * @author cylong
 * @version 2014年12月14日 下午4:53:08
 */
public class ApprovalShowController implements ApprovalShowBLService {

	private ApprovalShow approvalShow;

	/**
	 * @author cylong
	 * @version 2014年12月14日 下午4:56:46
	 */
	public ApprovalShowController() {
		approvalShow = new ApprovalShow();
	}

	/**
	 * @see blservice.approvalblservice.ApprovalShowBLService#ShowApproving()
	 */
	@Override
	public ApprovalVO ShowApproving() {
		try {
			LogController.addLog("查看所有待审批的单据");
			return approvalShow.ShowApproving();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.approvalblservice.ApprovalShowBLService#showPass()
	 */
	@Override
	public ApprovalVO showPass() {
		try {
			LogController.addLog("查看所有通过审批的单据");
			return approvalShow.showPass();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.approvalblservice.ApprovalShowBLService#showFailure()
	 */
	@Override
	public ApprovalVO showFailure() {
		try {
			LogController.addLog("查看所有待审批失败的单据");
			return approvalShow.showFailure();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

}
