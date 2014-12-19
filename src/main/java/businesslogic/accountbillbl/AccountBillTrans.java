package businesslogic.accountbillbl;

import java.util.ArrayList;

import po.AccountBillItemPO;
import po.AccountBillPO;
import vo.AccountBillItemVO;
import vo.AccountBillVO;
import dataenum.BillState;
import dataenum.BillType;

public class AccountBillTrans {

	/**
	 * 将收款单（付款单）的PO集合转化成VO集合
	 * @param billsPO
	 * @return ArrayList<AccountBillVO>
	 * @author cylong
	 * @version 2014年12月1日 下午3:45:32
	 */
	static public ArrayList<AccountBillVO> billsPOToBillsVO(ArrayList<AccountBillPO> billsPO) {
		ArrayList<AccountBillVO> billsVO = new ArrayList<AccountBillVO>();
		for(AccountBillPO po : billsPO) {
			AccountBillVO vo = poToVO(po);
			billsVO.add(vo);
		}
		return billsVO;
	}

	/**
	 * 将AccountBillPO转化成AccountBillVO
	 * @param po AccountBillPO
	 * @return AccountBillVO
	 * @author cylong
	 * @version 2014年12月1日 下午3:40:52
	 */
	static public AccountBillVO poToVO(AccountBillPO po) {
		String ID = po.getID();
		String clientID = po.getClientID();
		String clientName = po.getClientName();
		String username = po.getUsername();
		ArrayList<AccountBillItemVO> bills = toItemVOList(po.getBills());
		BillState state = po.getState();
		BillType type = po.getType();
		AccountBillVO vo = new AccountBillVO(ID, clientID, clientName, username, bills, state, type);
		return vo;
	}

	/**
	 * itemPOList转化成itemVOList
	 * @return itemVOList
	 * @author cylong
	 * @version 2014年12月1日 上午1:13:19
	 */
	static public ArrayList<AccountBillItemVO> toItemVOList(ArrayList<AccountBillItemPO> itemPOList) {
		ArrayList<AccountBillItemVO> itemVOList = new ArrayList<AccountBillItemVO>();
		for(AccountBillItemPO po : itemPOList) {
			String accountName = po.getAccountName();
			double money = po.getMoney();
			String remark = po.getRemark();
			AccountBillItemVO vo = new AccountBillItemVO(accountName, money, remark);
			itemVOList.add(vo);
		}
		return itemVOList;
	}
}
