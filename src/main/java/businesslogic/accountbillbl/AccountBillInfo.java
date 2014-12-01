package businesslogic.accountbillbl;

import java.util.ArrayList;

import vo.AccountBillVO;
import businesslogic.recordbl.info.ValueObjectInfo_Record;
import dataenum.Storage;

/**
 * @author cylong
 * @version 2014年12月1日 下午3:02:45
 */
public class AccountBillInfo implements ValueObjectInfo_Record<AccountBillVO> {

	private AccountBill accountBill;

	public AccountBillInfo() {
		accountBill = new AccountBill();
	}

	/**
	 * @see businesslogic.recordbl.info.ValueObjectInfo_Record#find(java.lang.String)
	 */
	@Override
	public AccountBillVO find(String ID) {
		return accountBill.find(ID);
	}

	/**
	 * @see businesslogic.recordbl.info.ValueObjectInfo_Record#getID(java.lang.String, java.lang.String,
	 *      java.lang.String, dataenum.Storage)
	 */
	@Override
	public ArrayList<String> getID(String ID, String clientName, String salesman, Storage storage) {
		// TODO ArrayList<String> getID(String ID, String clientName, String salesman, Storage storage)
		return null;
	}

}
