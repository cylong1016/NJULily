package businesslogic.approvalbl.info;

import java.rmi.RemoteException;

import vo.AccountBillVO;
import message.ResultMessage;

public interface AccountBill_Approval {
	
	/**
	 * 更改一个在进行审批的单子
	 * @param vo
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 2:20:52 PM
	 * @throws RemoteException 
	 */
	public ResultMessage update(AccountBillVO vo) throws RemoteException;
	
	/**
	 * 通过付款／收款单
	 * @param vo
	 * @author Zing
	 * @version Dec 3, 2014 12:41:08 AM
	 * @throws RemoteException 
	 */
	public void pass(AccountBillVO vo) throws RemoteException;

	public AccountBillVO addRed(AccountBillVO vo, boolean isCopy) throws RemoteException;
}
