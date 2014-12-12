package blservice.approvalblservice;

import vo.ApprovalVO;

public interface ApprovalShowBLService {
	
	/**
	 * 查看等待审核的单据内容
	 */
	public ApprovalVO ShowApproving();
	
	/**
	 * 查看通过审核的单据内容
	 * @param record
	 * @return
	 */
	public ApprovalVO showPass();
	
	/**
	 * 查看未通过审核的单据
	 * @return
	 * @author Zing
	 * @version Dec 12, 2014 2:46:57 PM
	 */
	public ApprovalVO showFailure();
	
}
