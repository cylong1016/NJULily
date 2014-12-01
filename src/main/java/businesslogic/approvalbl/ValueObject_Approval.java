package businesslogic.approvalbl;

import java.util.ArrayList;

import vo.ValueObject;

public interface ValueObject_Approval<VO extends ValueObject> {
	
	/**
	 * 查找需要审批的单子
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 12:18:38 AM
	 */
	public ArrayList<VO> findApproval();
}
