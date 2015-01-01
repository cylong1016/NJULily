package businesslogic.cashbillbl;

import java.rmi.RemoteException;

import dataenum.ResultMessage;
import log.LogMsgController;
import vo.CashBillVO;
import blservice.cashbillblservice.CashBillBLService;

/**
 * @see blservice.cashbillblservice.CashBillBLService
 * @author cylong
 * @version 2014年12月14日 下午3:17:46
 */
public class CashBillController implements CashBillBLService {

	private CashBill cashBill;

	/**
	 * @author cylong
	 * @version 2014年12月14日 下午3:20:27
	 */
	public CashBillController() {
		cashBill = new CashBill();
	}

	/**
	 * @see blservice.cashbillblservice.CashBillBLService#getID()
	 */
	@Override
	public String getID() {
		try {
			return cashBill.getID();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.cashbillblservice.CashBillBLService#addBillItem(java.lang.String, double,
	 *      java.lang.String)
	 */
	@Override
	public void addBillItem(String name, double money, String remark) {
		cashBill.addBillItem(name, money, remark);
	}

	/**
	 * @see blservice.cashbillblservice.CashBillBLService#submit(java.lang.String)
	 */
	@Override
	public CashBillVO submit(String account) {
		try {
			CashBillVO vo = cashBill.submit(account);
			if (vo == null) {
				return null;
			}
			LogMsgController.addLog("提交现金费用单 " + vo.toString());
			return vo;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see blservice.cashbillblservice.CashBillBLService#save(java.lang.String)
	 */
	@Override
	public CashBillVO save(String account) {
		try {
			CashBillVO vo = cashBill.save(account);
			if (vo == null) {
				return null;
			}
			LogMsgController.addLog("保存现金费用单为草稿状态 " + vo.toString());
			return vo;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ResultMessage updateDraft(CashBillVO vo) {
		try {
			ResultMessage res = cashBill.updateDraft(vo);
			if (res == ResultMessage.SUCCESS) {
				LogMsgController.addLog("修改现金费用单的草稿状态 " + vo.toString());
			}
			return res;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ResultMessage submitDraft(String ID) {
		try {
			ResultMessage res = cashBill.submitDraft(ID);
			if (res == ResultMessage.SUCCESS) {
				LogMsgController.addLog("提交草稿状态的现金费用单： " + ID);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
