package businesslogic.approvalbl.info;

import java.rmi.RemoteException;

import vo.sale.SalesVO;
import message.ResultMessage;

public interface SaleInfo_Approval {
	/**
	 * 更改一个在进行审批的单子
	 * @param vo
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 2:20:52 PM
	 * @throws RemoteException 
	 */
	public ResultMessage update(SalesVO vo) throws RemoteException;
	
	/**
	 * 通过销售单（销售退货单）的审批，更改相应商品数量、客户应收应付
	 * @param vo
	 * @author Zing
	 * @version Dec 3, 2014 2:04:30 PM
	 * @throws RemoteException 
	 */
	public ResultMessage pass(SalesVO vo) throws RemoteException;

	/**
	 * 添加红冲
	 * @param vo
	 * @author Zing
	 * @version Dec 5, 2014 1:32:53 AM
	 * @throws RemoteException 
	 */
	public SalesVO addRed(SalesVO vo, boolean isCopy) throws RemoteException;
}
