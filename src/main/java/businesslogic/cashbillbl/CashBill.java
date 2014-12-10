package businesslogic.cashbillbl;

import java.util.ArrayList;

import message.ResultMessage;
import po.CashBillPO;
import po.CashItemPO;
import server.data.cashbilldata.CashBillData;
import vo.CashBillVO;
import vo.CashItemVO;
import blservice.cashbillblservice.CashBillBLService;
import dataenum.BillState;
import dataenum.BillType;
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
public class CashBill implements CashBillBLService {

	private String ID;

	private ArrayList<CashBillItem> items;

	private CashBillPO po;

	public CashBill() {
		items = new ArrayList<CashBillItem>();
	}

	public CashBillDataService getCashBillData() {
//		try {
//			DataFactoryService factory = (DataFactoryService)Naming.lookup(RMI.URL);
//			CashBillDataService cashBillData = (CashBillDataService)factory.getCashBillData();
//			return cashBillData;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
		return new CashBillData();
	}

	public String getID(BillType type) {
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

	public ResultMessage submit(String account) {
		addCashBill(account);
		getCashBillData().insert(po);
		return ResultMessage.SUCCESS;
	}

	public ResultMessage save(String account) {
		// TODO 存在本地
		return null;
	}

	/**
	 * 返回所有的现金费用单
	 * @param billType
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 1:56:03 PM
	 */
	public ArrayList<CashBillVO> show(BillType billType) {
		ArrayList<CashBillVO> VOs = new ArrayList<CashBillVO>();
		ArrayList<CashBillPO> POs = getCashBillData().show();
		for(int i = 0; i < POs.size(); i++) {
			CashBillVO vo = POToVO(POs.get(i));
			VOs.add(vo);
		}
		return VOs;
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
