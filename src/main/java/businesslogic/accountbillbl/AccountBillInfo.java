package businesslogic.accountbillbl;

import java.util.ArrayList;

import message.ResultMessage;
import po.AccountBillItemPO;
import po.AccountBillPO;
import vo.AccountBillItemVO;
import vo.AccountBillVO;
import businesslogic.approvalbl.info.AccountBill_Approval;
import businesslogic.approvalbl.info.ValueObject_Approval;
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
public class AccountBillInfo extends Info<AccountBillPO> implements ValueObjectInfo_Record<AccountBillVO>, ValueObject_Approval<AccountBillVO>, AccountBill_Approval{

	private AccountBill accountBill;

	public AccountBillInfo() {
		accountBill = new AccountBill();
	}

	/**
	 * @see dataservice.accountbilldataservice.AccountBillDataService
	 * @see businesslogic.common.Info#getData()
	 */
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

	/**
	 * 返回需要进行审核的单子（包括付款单x和收款单）
	 */
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

	public ResultMessage update(AccountBillVO vo) {
		String ID = vo.ID;
		String clientID = vo.clientID;
		String userID = vo.userID;
		BillType type = vo.type;
		ArrayList<AccountBillItemPO> bills = itemsVOtoPO(vo.bills);
		AccountBillPO po = new AccountBillPO(ID, clientID, userID, bills, type);
		return accountBill.getAccountBillData().update(po);
	}
	
	private ArrayList<AccountBillItemPO> itemsVOtoPO(ArrayList<AccountBillItemVO> VOs) {
		ArrayList<AccountBillItemPO> POs = new ArrayList<AccountBillItemPO>();
		for (AccountBillItemVO vo : VOs) {
			String accountID = vo.accountID;
			double money = vo.money;
			String remark = vo.remark;
			AccountBillItemPO po = new AccountBillItemPO(accountID, money, remark);
			POs.add(po);
		}
		return POs;
	}

	// TODO
	public void pass(AccountBillVO vo) {
		AccountBillPO po = accountBill.getAccountBillData().find(vo.ID);
		po.setState(BillState.SUCCESS);
		accountBill.getAccountBillData().update(po);
		
	}

}
