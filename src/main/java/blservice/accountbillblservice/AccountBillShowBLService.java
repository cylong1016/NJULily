package blservice.accountbillblservice;

import java.util.ArrayList;

import vo.AccountBillVO;

public interface AccountBillShowBLService {
	
	/**
	 * 返回给界面层显示全部的付款／收款单
	 * @return 全部的付款／收款单的ArrayList
	 * @author cylong
	 * @version 2014年11月28日 下午4:14:35
	 */
	public ArrayList<AccountBillVO> showPay();
	public ArrayList<AccountBillVO> showExpense();

	/**
	 * 返回给界面层显示全部在审核的付款／收款单
	 * @return
	 * @author Zing
	 * @version Dec 12, 2014 1:58:50 AM
	 */
	public ArrayList<AccountBillVO> showPayApproving();
	public ArrayList<AccountBillVO> showExpenseApproving();
	
	/**
	 * 返回给界面层显示全部通过审核的付款／收款单
	 * @return
	 * @author Zing
	 * @version Dec 12, 2014 1:59:15 AM
	 */
	public ArrayList<AccountBillVO> showPayPass();
	public ArrayList<AccountBillVO> showExpensePass();
	
	/**
	 * 返回给界面层显示全部没有通过审批的付款／收款单
	 * @return
	 * @author Zing
	 * @version Dec 12, 2014 2:01:47 AM
	 */
	public ArrayList<AccountBillVO> showPayFailure();
	public ArrayList<AccountBillVO> showExpenseFailure();
	
	/**
	 * 返回给界面层显示全部草稿状态的付款／收款单
	 * @return
	 * @author Zing
	 * @version Dec 27, 2014 5:26:07 PM
	 */
	public ArrayList<AccountBillVO> showPayDraft();
	public ArrayList<AccountBillVO> showExpenseDraft();
}
