package businesslogic.cashbillbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CashBillPO;
import po.CashItemPO;
import vo.CashBillVO;
import vo.CashItemVO;
import config.RMIConfig;
import dataenum.BillState;
import dataservice.cashbilldataservice.CashBillDataService;

/**
 * 制定现金费用单
 * (管理报销等现金操作，单据中包含：
 * 单据编号（XJFYD-yyyyMMdd-xxxxx), 操作员（当前登录用户），银行账户，条目清单，总额。
 * 条目清单中包括：条目名，金额，备注。
 * 需要通过审批后才可将此单据入账。入账后将会减少该账户的余额。
 * @author Zing
 * @version Nov 27, 201411:13:32 PM
 */
public class CashBill {

	private String ID;

	private ArrayList<CashBillItem> items;

	private CashBillPO po;

	public CashBill() {
		items = new ArrayList<CashBillItem>();
	}

	public CashBillDataService getCashBillData() {
		try {
			return (CashBillDataService)Naming.lookup(RMIConfig.PREFIX + CashBillDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getID() throws RemoteException {
		CashBillDataService cashBillData = getCashBillData();
		this.ID = cashBillData.getID();
		return ID;
	}

	public void addBillItem(String name, double money, String remark) {
		CashBillItem item = new CashBillItem(name, money, remark);
		items.add(item);
	}

	public ArrayList<CashItemPO> getCashItemPO() {
		ArrayList<CashItemPO> pos = new ArrayList<CashItemPO>();
		for(int i = 0; i < items.size(); i++) {
			CashBillItem item = items.get(i);
			CashItemPO po = new CashItemPO(item.getName(), item.getMoney(), item.getRemark());
			pos.add(po);
		}
		return pos;
	}

	public double getSumMoney() {
		double sum = 0;
		for(int i = 0; i < items.size(); i++) {
			sum += items.get(i).getMoney();
		}
		return sum;
	}

	public CashBillPO addCashBill(String account) {
		po = new CashBillPO(ID, "user", account, getCashItemPO(), getSumMoney());
		return po;
	}

	public CashBillVO submit(String account) throws RemoteException {
		addCashBill(account);
		getCashBillData().insert(po);
		return POToVO(po);
	}

	public CashBillVO save(String account) {
		addCashBill(account);
		// TODO 存在本地
		return POToVO(po);
	}

	public CashBillVO POToVO(CashBillPO po) {
		String ID = po.getID();
		String user = po.getUser();
		String account = po.getAccount();
		ArrayList<CashItemVO> bills = itemsPOToVO(po.getBills());
		double total = po.getTotal();
		BillState state = po.getState();
		CashBillVO vo = new CashBillVO(ID, user, account, bills, total, state);
		return vo;
	}

	private ArrayList<CashItemVO> itemsPOToVO(ArrayList<CashItemPO> bills) {
		ArrayList<CashItemVO> VOs = new ArrayList<CashItemVO>();
		for(int i = 0; i < bills.size(); i++) {
			CashItemPO po = bills.get(i);
			CashItemVO vo = new CashItemVO(po.getName(), po.getMoney(), po.getRemark());
			VOs.add(vo);
		}
		return VOs;
	}

}
