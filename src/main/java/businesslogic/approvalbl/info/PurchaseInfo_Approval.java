package businesslogic.approvalbl.info;

import vo.PurchaseVO;
import message.ResultMessage;

public interface PurchaseInfo_Approval {
	/**
	 * 更改一个在进行审批的单子
	 * @param vo
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 2:20:52 PM
	 */
	public ResultMessage update(PurchaseVO vo);

	/**
	 * 通过该进货／进货退货单，更改相应数据
	 * @param vo
	 * @author Zing
	 * @version Dec 3, 2014 3:47:40 PM
	 */
	public ResultMessage pass(PurchaseVO vo);

	public PurchaseVO addRed(PurchaseVO vo, boolean isCopy);
}
