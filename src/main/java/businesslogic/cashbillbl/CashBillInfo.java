package businesslogic.cashbillbl;

import java.util.ArrayList;

import message.ResultMessage;
import po.CashBillPO;
import po.CashItemPO;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.Storage;
import dataservice.TableInfoService;
import dataservice.cashbilldataservice.CashBillDataService;
import vo.CashBillVO;
import vo.CashItemVO;
import businesslogic.accountbl.AccountInfo;
import businesslogic.approvalbl.info.CashBillInfo_Approval;
import businesslogic.approvalbl.info.ValueObject_Approval;
import businesslogic.common.Info;
import businesslogic.recordbl.info.ValueObjectInfo_Record;

public class CashBillInfo extends Info<CashBillPO> implements ValueObjectInfo_Record<CashBillVO>, ValueObject_Approval<CashBillVO>, CashBillInfo_Approval{
	
	private CashBill cashBill;
	
	public CashBillInfo() {
		cashBill = new CashBill();
	}
	
	public TableInfoService<CashBillPO> getData() {
		return cashBill.getCashBillData().getInfo();
	}
	
	private CashBillDataService getCashBillData() {
		return cashBill.getCashBillData();
	}
	
	public ArrayList<String> getID(String ID, String clientName, String salesman, Storage storage) {
		ArrayList<String> IDs = new ArrayList<String>();
		IDs = getID(ID, clientName, salesman, storage, BillType.CASH);
		return IDs;
	}

	public CashBillVO find(String ID) {
		return cashBill.POToVO(getCashBillData().find(ID));
	}

	public ResultMessage update(CashBillVO vo) {
		String ID = vo.ID;
		String user = vo.user;
		String account = vo.account;
		double total = vo.total;
		ArrayList<CashItemPO> bills = itemsVOtoPO(vo.bills);
		CashBillPO po = new CashBillPO(ID, user, account, bills, total);
		return getCashBillData().update(po);
	}
	
	private ArrayList<CashItemPO> itemsVOtoPO(ArrayList<CashItemVO> VOs) {
		ArrayList<CashItemPO> POs = new ArrayList<CashItemPO>();
		for (CashItemVO vo : VOs) {
			String name = vo.name;
			double money = vo.money;
			String remark = vo.remark;
			CashItemPO po = new CashItemPO(name, money, remark);
			POs.add(po);
		}
		return POs;
	}

	public void pass(CashBillVO vo) {
		CashBillPO po = getCashBillData().find(vo.ID);
		// 更新该现金费用单的状态
		po.setState(BillState.SUCCESS);
		getCashBillData().update(po);
		AccountInfo_CashBill info = new AccountInfo();
		ArrayList<CashItemPO> items = po.getBills();
		double money = 0;
		for (CashItemPO item : items) {
			money += item.getMoney();
		}
		// 更改对应账户的余额
		info.changeMoney(po.getAccount(), money);
	}

	public CashBillVO addRed(CashBillVO vo, boolean isCopy) {
		CashBillVO redVO = vo;
		ArrayList<CashItemVO> bills = redVO.bills;
		for (int i = 0; i < bills.size(); i++) {
			double money = -bills.get(i).money;
			bills.get(i).money = money;
		}
		redVO.bills = bills;
		CashBillPO redPO = new CashBillPO(redVO.ID, redVO.user, redVO.account, itemsVOtoPO(redVO.bills), redVO.total);
		if (!isCopy) {
			getCashBillData().insert(redPO);
			pass(redVO);
		}
		else {
			// TODO 保存为草稿
		}
		return redVO;
	}
	
	public ArrayList<CashBillVO> findApproval() {
		CashBillShow show = new CashBillShow();
		return show.showApproving();
	}

	@Override
	public ArrayList<CashBillVO> showPass() {
		CashBillShow show = new CashBillShow();
		return show.showPass();
	}

	@Override
	public ArrayList<CashBillVO> showFailure() {
		CashBillShow show = new CashBillShow();
		return show.showFailure();
	}
}
