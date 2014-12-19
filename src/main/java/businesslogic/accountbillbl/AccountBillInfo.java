package businesslogic.accountbillbl;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import message.ResultMessage;
import po.AccountBillItemPO;
import po.AccountBillPO;
import vo.AccountBillItemVO;
import vo.AccountBillVO;
import businesslogic.accountbillbl.info.AccountInfo_AccountBill;
import businesslogic.accountbillbl.info.ClientInfo_AccountBill;
import businesslogic.accountbl.AccountInfo;
import businesslogic.approvalbl.info.AccountBill_Approval;
import businesslogic.approvalbl.info.ValueObject_Approval;
import businesslogic.clientbl.ClientInfo;
import businesslogic.common.DateOperate;
import businesslogic.common.Info;
import businesslogic.recordbl.info.ValueObjectInfo_Record;
import config.RMIConfig;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.Storage;
import dataservice.TableInfoService;
import dataservice.accountbilldataservice.AccountBillDataService;
import dataservice.accountbilldataservice.AccountBillInfoService;
import dataservice.saledataservice.SaleInfoService;

/**
 * @author cylong
 * @version 2014年12月1日 下午3:02:45
 */
public class AccountBillInfo extends Info<AccountBillPO> implements ValueObjectInfo_Record<AccountBillVO>, ValueObject_Approval<AccountBillVO>, AccountBill_Approval {

	private AccountBill accountBill;
	private AccountBillDataService accountBillData;
	private ArrayList<String> payIDs;
	private ArrayList<String> expenIDs;
	
	public AccountBillInfo() {
		accountBill = new AccountBill();
		this.accountBillData = accountBill.getAccountBillData();
	}

	public AccountBillInfo(Date begin, Date end) {
		accountBill = new AccountBill();
		this.accountBillData = accountBill.getAccountBillData();
		payIDs = new ArrayList<String>();
		expenIDs = new ArrayList<String>();
		setIDsByDate(begin, end);
	}
	
	private void setIDsByDate(Date beginDate, Date endDate){
		try {
			SaleInfoService saleInfo = (SaleInfoService)Naming.lookup(RMIConfig.PREFIX+SaleInfoService.NAME);
			ArrayList<String> IDs = saleInfo.getAllID(BillType.PAY);
			payIDs.addAll(DateOperate.findFitDate(IDs, beginDate, endDate));
			ArrayList<String> bIDs = saleInfo.getAllID(BillType.EXPENSE);
			expenIDs.addAll(DateOperate.findFitDate(bIDs, beginDate, endDate));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see businesslogic.common.Info#getData()
	 */
	@Override
	protected TableInfoService<AccountBillPO> getData() {
		try {
			return (AccountBillInfoService)Naming.lookup(RMIConfig.PREFIX + AccountBillInfoService.NAME);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @throws RemoteException
	 * @see businesslogic.recordbl.info.ValueObjectInfo_Record#find(java.lang.String)
	 */
	public AccountBillVO find(String ID) throws RemoteException {
		return accountBill.find(ID);
	}

	/**
	 * @throws RemoteException
	 * @see businesslogic.recordbl.info.ValueObjectInfo_Record#getID(java.lang.String, java.lang.String,
	 *      java.lang.String, dataenum.Storage)
	 */
	public ArrayList<String> getID(String clientName, String salesman, Storage storage) throws RemoteException {
		ArrayList<String> IDs = new ArrayList<String>();
		IDs = getID(payIDs, clientName, salesman, storage);
		IDs.addAll(getID(expenIDs, clientName, salesman, storage));
		return IDs;
	}

	public ResultMessage update(AccountBillVO vo) throws RemoteException {
		String ID = vo.ID;
		String clientID = vo.clientID;
		String clientName = vo.clientName;
		String username = vo.username;
		BillType type = vo.type;
		ArrayList<AccountBillItemPO> bills = itemsVOtoPO(vo.bills);
		AccountBillPO po = new AccountBillPO(ID, clientID, clientName, username, bills, type);
		return accountBillData.update(po);
	}

	private ArrayList<AccountBillItemPO> itemsVOtoPO(ArrayList<AccountBillItemVO> VOs) {
		ArrayList<AccountBillItemPO> POs = new ArrayList<AccountBillItemPO>();
		for(AccountBillItemVO vo : VOs) {
			String accountName = vo.accountName;
			double money = vo.money;
			String remark = vo.remark;
			AccountBillItemPO po = new AccountBillItemPO(accountName, money, remark);
			POs.add(po);
		}
		return POs;
	}

	/**
	 * 收款单／付款单通过审批，更改账户信息、客户应收／应付数据
	 * @throws RemoteException
	 */
	public void pass(AccountBillVO vo) throws RemoteException {
		AccountBillPO po = accountBillData.find(vo.ID);
		// 更改该收款单／付款单的状态
		po.setState(BillState.SUCCESS);
		accountBillData.update(po);
		// 更改银行账户的数据
		ArrayList<AccountBillItemPO> billItemPOs = po.getBills();
		AccountInfo_AccountBill accountInfo = new AccountInfo();
		for(AccountBillItemPO billItem : billItemPOs) {
			switch(vo.type) {
			case PAY:
				accountInfo.changeMoney(billItem.getAccountName(), billItem.getMoney());
				break;
			case EXPENSE:
				accountInfo.changeMoney(billItem.getAccountName(), -billItem.getMoney());
				break;
			default:
				break;
			}
		}
		ClientInfo_AccountBill clientInfo = new ClientInfo();
		switch(vo.type) {
		case PAY:
			clientInfo.changeReceivable(vo.clientID, vo.sumMoney);
			break;
		case EXPENSE:
			clientInfo.changePayable(vo.clientID, vo.sumMoney);
			break;
		default:
			break;
		}
	}

	public AccountBillVO addRed(AccountBillVO vo, boolean isCopy) throws RemoteException {
		AccountBillVO redVO = vo;
		ArrayList<AccountBillItemVO> bills = redVO.bills;
		for(int i = 0; i < bills.size(); i++) {
			double money = -bills.get(i).money;
			bills.get(i).money = money;
		}
		redVO.bills = bills;
		AccountBillPO redPO =
								new AccountBillPO(redVO.ID, redVO.clientID, redVO.clientName, redVO.username, itemsVOtoPO(redVO.bills), redVO.type);
		if (!isCopy) {
			accountBillData.insert(redPO);
			pass(redVO);
		} else {
			// TODO 保存为草稿
		}
		return redVO;
	}

	/**
	 * 返回需要进行审核的单子（包括付款单x和收款单）
	 * @throws RemoteException
	 */
	public ArrayList<AccountBillVO> findApproval() throws RemoteException {
		AccountBillShow show = new AccountBillShow();
		ArrayList<AccountBillVO> VOs = show.showPayApproving();
		VOs.addAll(show.showExpenseApproving());
		return VOs;
	}

	@Override
	public ArrayList<AccountBillVO> showPass() throws RemoteException {
		AccountBillShow show = new AccountBillShow();
		ArrayList<AccountBillVO> VOs = show.showPayPass();
		VOs.addAll(show.showExpensePass());
		return VOs;
	}

	@Override
	public ArrayList<AccountBillVO> showFailure() throws RemoteException {
		AccountBillShow show = new AccountBillShow();
		ArrayList<AccountBillVO> VOs = show.showPayFailure();
		VOs.addAll(show.showExpenseFailure());
		return VOs;
	}

}
