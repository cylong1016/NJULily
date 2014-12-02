package businesslogic.approvalbl;

import java.util.ArrayList;

import message.ResultMessage;
import vo.ValueObject;

public interface ValueObject_Approval<VO extends ValueObject> {
	
	/**
	 * 查找需要审批的单子
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 12:18:38 AM
	 */
	public ArrayList<VO> findApproval();
	
	/**
	 * 更改一个在进行审批的单子
	 * @param vo
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 2:20:52 PM
	 */
	public ResultMessage update(VO vo);
}
