package businesslogic.cashbillbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import log.LogController;
import vo.CashBillVO;
import blservice.cashbillblservice.CashBillShowBLService;

/**
 * @see blservice.cashbillblservice.CashBillShowBLService
 * @author cylong
 * @version 2014年12月14日 下午3:22:14
 */
public class CashBillShowController implements CashBillShowBLService {

	private CashBillShow cashBillShow;

	public CashBillShowController() {
		cashBillShow = new CashBillShow();
	}

	/**
	 * @see blservice.cashbillblservice.CashBillShowBLService#show()
	 */
	@Override
	public ArrayList<CashBillVO> show() {
		try {
			return cashBillShow.show();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.cashbillblservice.CashBillShowBLService#showApproving()
	 */
	@Override
	public ArrayList<CashBillVO> showApproving() {
		try {
			LogController.addLog("查看所有等待审批的现金费用单");
			return cashBillShow.showApproving();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.cashbillblservice.CashBillShowBLService#showPass()
	 */
	@Override
	public ArrayList<CashBillVO> showPass() {
		try {
			LogController.addLog("查看所有通过审批的现金费用单");
			return cashBillShow.showPass();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.cashbillblservice.CashBillShowBLService#showFailure()
	 */
	@Override
	public ArrayList<CashBillVO> showFailure() {
		try {
			LogController.addLog("查看所有审批失败的现金费用单");
			return cashBillShow.showFailure();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.cashbillblservice.CashBillShowBLService#showDraft()
	 */
	@Override
	public ArrayList<CashBillVO> showDraft() {
		try {
			LogController.addLog("查看所有草稿状态的现金费用单");
			return cashBillShow.showDraft();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

}
