package businesslogic.cashbillbl;

import java.rmi.RemoteException;

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
			return cashBill.submit(account);
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
		return cashBill.save(account);
	}

}
