package businesslogic.accountbillbl;

import java.util.ArrayList;

import vo.AccountBillVO;
import businesslogic.recordbl.info.ValueObjectInfo_Record;
import dataenum.BillType;
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
	 * @see businesslogic.recordbl.info.ValueObjectInfo_Record#show(dataenum.BillType)
	 */
	@Override
	public ArrayList<AccountBillVO> show(BillType billType) {
		return accountBill.show(billType);
	}

	/**
	 * @see businesslogic.recordbl.info.ValueObjectInfo_Record#getID(java.lang.String, java.lang.String,
	 *      java.lang.String, dataenum.Storage)
	 */
	@Override
	public String getID(String ID, String clientName, String salesman, Storage storage) {
		// TODO cylong求告知这个方法是干什么的
		return null;
	}
}
