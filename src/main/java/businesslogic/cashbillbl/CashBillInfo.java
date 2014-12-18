package businesslogic.cashbillbl;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import message.ResultMessage;
import po.CashBillPO;
import po.CashItemPO;
import vo.CashBillVO;
import vo.CashItemVO;
import businesslogic.accountbl.AccountInfo;
import businesslogic.approvalbl.info.CashBillInfo_Approval;
import businesslogic.approvalbl.info.ValueObject_Approval;
import businesslogic.cashbillbl.info.AccountInfo_CashBill;
import businesslogic.common.DateOperate;
import businesslogic.common.Info;
import businesslogic.recordbl.info.ValueObjectInfo_Record;
import config.RMIConfig;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.Storage;
import dataservice.TableInfoService;
import dataservice.cashbilldataservice.CashBillDataService;
import dataservice.cashbilldataservice.CashBillInfoService;

public class CashBillInfo extends Info<CashBillPO> implements ValueObjectInfo_Record<CashBillVO>, ValueObject_Approval<CashBillVO>, CashBillInfo_Approval {

	private CashBill cashBill;
	private CashBillDataService cashBillData;
	private ArrayList<String> cashIDs;

	public CashBillInfo() {
		cashBill = new CashBill();
		cashBillData = cashBill.getCashBillData();
	}

	public CashBillInfo(Date begin, Date end) {
		cashBill = new CashBill();
		cashBillData = cashBill.getCashBillData();
		cashIDs = new ArrayList<String>();
		setIDsByDate(begin, end);
	}

	/**
	 * 找到符合条件的ID
	 */
	private void setIDsByDate(Date beginDate, Date endDate){
		try {
			ArrayList<String> IDs = getData().getAllID(BillType.CASH);
			cashIDs = DateOperate.findFitDate(IDs, beginDate, endDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public TableInfoService<CashBillPO> getData() {
		try {
			return (CashBillInfoService)Naming.lookup(RMIConfig.PREFIX + CashBillInfoService.NAME);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}

	public ArrayList<String> getID(String clientName, String salesman, Storage storage) throws RemoteException {
		ArrayList<String> IDs = new ArrayList<String>();
		IDs = getID(cashIDs, clientName, salesman, storage);
		return IDs;
	}

	public CashBillVO find(String ID) throws RemoteException {
		return CashBillTrans.POToVO(cashBillData.find(ID));
	}

	public ResultMessage update(CashBillVO vo) throws RemoteException {
		String ID = vo.ID;
		String user = vo.user;
		String account = vo.account;
		double total = vo.total;
		ArrayList<CashItemPO> bills = itemsVOtoPO(vo.bills);
		CashBillPO po = new CashBillPO(ID, user, account, bills, total);
		return cashBillData.update(po);
	}

	private ArrayList<CashItemPO> itemsVOtoPO(ArrayList<CashItemVO> VOs) {
		ArrayList<CashItemPO> POs = new ArrayList<CashItemPO>();
		for(CashItemVO vo : VOs) {
			String name = vo.name;
			double money = vo.money;
			String remark = vo.remark;
			CashItemPO po = new CashItemPO(name, money, remark);
			POs.add(po);
		}
		return POs;
	}

	public void pass(CashBillVO vo) throws RemoteException {
		CashBillPO po = cashBillData.find(vo.ID);
		// 更新该现金费用单的状态
		po.setState(BillState.SUCCESS);
		cashBillData.update(po);
		AccountInfo_CashBill info = new AccountInfo();
		ArrayList<CashItemPO> items = po.getBills();
		double money = 0;
		for(CashItemPO item : items) {
			money += item.getMoney();
		}
		// 更改对应账户的余额
		info.changeMoney(po.getAccount(), money);
	}

	public CashBillVO addRed(CashBillVO vo, boolean isCopy) throws RemoteException {
		CashBillVO redVO = vo;
		ArrayList<CashItemVO> bills = redVO.bills;
		for(int i = 0; i < bills.size(); i++) {
			double money = -bills.get(i).money;
			bills.get(i).money = money;
		}
		redVO.bills = bills;
		CashBillPO redPO = new CashBillPO(redVO.ID, redVO.user, redVO.account, itemsVOtoPO(redVO.bills), redVO.total);
		if (!isCopy) {
			cashBillData.insert(redPO);
			pass(redVO);
		} else {
			// TODO 保存为草稿
		}
		return redVO;
	}

	public ArrayList<CashBillVO> findApproval() throws RemoteException {
		CashBillShow show = new CashBillShow();
		return show.showApproving();
	}

	@Override
	public ArrayList<CashBillVO> showPass() throws RemoteException {
		CashBillShow show = new CashBillShow();
		return show.showPass();
	}

	/**
	 * @throws RemoteException
	 * @see businesslogic.approvalbl.info.ValueObject_Approval#showFailure()
	 */
	@Override
	public ArrayList<CashBillVO> showFailure() throws RemoteException {
		CashBillShow show = new CashBillShow();
		return show.showFailure();
	}
}
