package businesslogic.approvalbl.info;

import vo.AccountBillVO;
import message.ResultMessage;

public interface AccountBill_Approval {
	
	/**
	 * 更改一个在进行审批的单子
	 * @param vo
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 2:20:52 PM
	 */
	public ResultMessage update(AccountBillVO vo);
	
	/**
	 * 通过付款／收款单
	 * @param vo
	 * @author Zing
	 * @version Dec 3, 2014 12:41:08 AM
	 */
	public void pass(AccountBillVO vo);

	public AccountBillVO addRed(AccountBillVO vo, boolean isCopy);
}
