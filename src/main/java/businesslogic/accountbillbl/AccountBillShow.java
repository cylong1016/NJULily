package businesslogic.accountbillbl;

import java.util.ArrayList;

import dataenum.BillState;
import dataenum.BillType;
import dataservice.accountbilldataservice.AccountBillDataService;
import po.AccountBillPO;
import vo.AccountBillVO;
import blservice.accountbillblservice.AccountBillShowBLService;

public class AccountBillShow implements AccountBillShowBLService{
	
	private AccountBillDataService accountBillData;
	private AccountBill accountBill;
	
	public AccountBillShow() {
		accountBill = new AccountBill();
		accountBillData = accountBill.getAccountBillData();
	}

	@Override
	public ArrayList<AccountBillVO> showPay() {
		return showChoose(BillType.PAY);
	}

	@Override
	public ArrayList<AccountBillVO> showExpense() {
		return showChoose(BillType.EXPENSE);
	}

	@Override
	public ArrayList<AccountBillVO> showPayApproving() {
		return showChoose(BillType.PAY, BillState.APPROVALING);
	}

	@Override
	public ArrayList<AccountBillVO> showExpenseApproving() {
		return showChoose(BillType.EXPENSE, BillState.APPROVALING);
	}

	@Override
	public ArrayList<AccountBillVO> showPayPass() {
		return showChoose(BillType.PAY, BillState.SUCCESS);
	}

	@Override
	public ArrayList<AccountBillVO> showExpensePass() {
		return showChoose(BillType.EXPENSE, BillState.SUCCESS);
	}

	@Override
	public ArrayList<AccountBillVO> showPayFailure() {
		return showChoose(BillType.PAY, BillState.FAILURE);
	}

	@Override
	public ArrayList<AccountBillVO> showExpenseFailure() {
		return showChoose(BillType.EXPENSE, BillState.FAILURE);
	}
	
	/**
	 * @return 全部的收款单和付款单
	 * @author cylong
	 * @version 2014年12月1日 下午3:21:44
	 */
	private ArrayList<AccountBillVO> show() {
		ArrayList<AccountBillPO> billsPO = accountBillData.show();
		ArrayList<AccountBillVO> billsVO = accountBill.billsPOToBillsVO(billsPO);
		return billsVO;
	}
	
	/**
	 * 根据选择的类型显示
	 * @param type
	 * @return
	 * @author Zing
	 * @version Dec 12, 2014 2:17:03 AM
	 */
	private ArrayList<AccountBillVO> showChoose(BillType type) {
		ArrayList<AccountBillVO> choose = new ArrayList<AccountBillVO>();
		for (AccountBillVO vo : show()) {
			if (vo.type == type) {
				choose.add(vo);
			}
		}
		return choose;
	}
	
	/**
	 * 根据选择的类型和状态显示
	 * @param type
	 * @param state
	 * @return
	 * @author Zing
	 * @version Dec 12, 2014 2:17:17 AM
	 */
	private ArrayList<AccountBillVO> showChoose(BillType type, BillState state) {
		ArrayList<AccountBillVO> choose = new ArrayList<AccountBillVO>();
		for (AccountBillVO vo : show()) {
			if (vo.type == type && vo.state == state) {
				choose.add(vo);
			}
		}
		return choose;
	}


}
