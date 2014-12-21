package businesslogic.approvalbl.info;

import java.rmi.RemoteException;

import vo.InventoryBillVO;
import message.ResultMessage;

public interface InventoryInfo_Approval {

	/**
	 * 更改一个在进行审批的单子
	 * @param vo
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 2:20:52 PM
	 */
	public ResultMessage update(InventoryBillVO vo) throws RemoteException;

	/**
	 * 库存单据通过审批，更改相应数据
	 * @param vo
	 * @author Zing
	 * @version Dec 3, 2014 4:47:13 PM
	 * @throws RemoteException
	 */
	public void pass(InventoryBillVO vo) throws RemoteException;

	public InventoryBillVO addRed(InventoryBillVO vo, boolean isCopy) throws RemoteException;

	public void noPass(InventoryBillVO vo) throws RemoteException;
}
