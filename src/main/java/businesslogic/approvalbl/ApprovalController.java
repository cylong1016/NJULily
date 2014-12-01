package businesslogic.approvalbl;

import java.util.ArrayList;

import message.ResultMessage;
import vo.ApprovalVO;
import vo.ValueObject;
import blservice.approvalblservice.ApprovalBLService;

public class ApprovalController implements ApprovalBLService{
	
	Approval approval;
	
	public ApprovalController() {
		approval = new Approval();
	}

	public ApprovalVO show() {
		return approval.show();
	}

	public ResultMessage updateBill(ArrayList<ValueObject> VOs) {
		return approval.updateBill(VOs);
	}

	public ResultMessage passBill(ArrayList<ApprovalVO> VOs) {
		return approval.passBill(VOs);
	}

}
