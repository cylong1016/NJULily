package businesslogic.accountbillbl;

import java.util.ArrayList;

import po.AccountBillPO;
import vo.AccountBillVO;
import businesslogic.approvalbl.ValueObject_Approval;
import businesslogic.common.Info;
import businesslogic.recordbl.info.ValueObjectInfo_Record;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.Storage;
import dataservice.TableInfoService;

/**
 * @author cylong
 * @version 2014年12月1日 下午3:02:45
 */
public class AccountBillInfo extends Info<AccountBillPO> implements ValueObjectInfo_Record<AccountBillVO>, ValueObject_Approval<AccountBillVO> {

	private AccountBill accountBill;

	public AccountBillInfo() {
		accountBill = new AccountBill();
	}

	@Override
	protected TableInfoService<AccountBillPO> getData() {
		return accountBill.getAccountBillData().getInfo();
	}

	/**
	 * @see businesslogic.recordbl.info.ValueObjectInfo_Record#find(java.lang.String)
	 */
	public AccountBillVO find(String ID) {
		return accountBill.find(ID);
	}

	/**
	 * @see businesslogic.recordbl.info.ValueObjectInfo_Record#getID(java.lang.String, java.lang.String,
	 *      java.lang.String, dataenum.Storage)
	 */
	public ArrayList<String> getID(String ID, String clientName, String salesman, Storage storage) {
		ArrayList<String> IDs = new ArrayList<String>();
		IDs = getID(ID, clientName, salesman, storage, BillType.PAY);
		IDs.addAll(getID(ID, clientName, salesman, storage, BillType.EXPENSE));
		return IDs;
	}

	public ArrayList<AccountBillVO> findApproval() {
		ArrayList<AccountBillPO> POs = getData().show();
		ArrayList<AccountBillPO> approvalPO = new ArrayList<AccountBillPO>();
		for(AccountBillPO po : POs) {
			if (po.getState() == BillState.APPROVALING) {
				approvalPO.add(po);
			}
		}
		ArrayList<AccountBillVO> VOs = new ArrayList<AccountBillVO>();
		for(AccountBillPO po : approvalPO) {
			AccountBillVO vo = accountBill.poToVO(po);
			VOs.add(vo);
		}
		return VOs;
	}

}
