package blservice.cashbillblservice;

import java.util.ArrayList;

import vo.CashBillVO;

public interface CashBillShowBLService {
	
	/**
	 * 查看所有的现金费用单
	 * @return
	 * @author Zing
	 * @version Dec 12, 2014 3:22:21 PM
	 */
	public ArrayList<CashBillVO> show();
	
	/**
	 * 查看需要审批的现金单
	 * @return
	 * @author Zing
	 * @version Dec 12, 2014 3:21:56 PM
	 */
	public ArrayList<CashBillVO> showApproving();
	
	/**
	 * 查看通过审批的现金费用单
	 * @return
	 * @author Zing
	 * @version Dec 12, 2014 3:22:24 PM
	 */
	public ArrayList<CashBillVO> showPass();
	
	/**
	 * 查看审批失败的现金费用单
	 * @return
	 * @author Zing
	 * @version Dec 12, 2014 3:22:27 PM
	 */
	public ArrayList<CashBillVO> showFailure();
	
	/**
	 * 查看草稿现金费用单
	 * @return
	 * @author Zing
	 * @version Dec 12, 2014 3:22:29 PM
	 */
	public ArrayList<CashBillVO> showDraft();
}
