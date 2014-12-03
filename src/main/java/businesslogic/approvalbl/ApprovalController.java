package businesslogic.approvalbl;

import java.util.ArrayList;

import dataenum.BillType;
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

	public ResultMessage updateBill(ValueObject vo, BillType billType) {
		return approval.updateBill(vo, billType);
	}

	public ResultMessage passBill(ArrayList<ValueObject> VOs, ArrayList<BillType> billTypes) {
		return approval.passBill(VOs, billTypes);
	}

}
