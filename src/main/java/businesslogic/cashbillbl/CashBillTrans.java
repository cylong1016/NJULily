package businesslogic.cashbillbl;

import java.util.ArrayList;

import po.CashBillPO;
import po.CashItemPO;
import vo.CashBillVO;
import vo.CashItemVO;
import dataenum.BillState;

public class CashBillTrans {

	static public ArrayList<CashBillVO> billsPOToBillsVO(ArrayList<CashBillPO> billsPO) {
		ArrayList<CashBillVO> billsVO = new ArrayList<CashBillVO>();
		for(CashBillPO po : billsPO) {
			System.out.println(po.getID());
			CashBillVO vo = POToVO(po);
			billsVO.add(vo);
		}
		return billsVO;
	}

	static public CashBillVO POToVO(CashBillPO po) {
		String ID = po.getID();
		String user = po.getUser();
		String account = po.getAccount();
		ArrayList<CashItemVO> bills = itemsPOToVO(po.getBills());
		double total = po.getTotal();
		BillState state = po.getState();
		CashBillVO vo = new CashBillVO(ID, user, account, bills, total, state);
		return vo;
	}

	static public ArrayList<CashItemVO> itemsPOToVO(ArrayList<CashItemPO> bills) {
		ArrayList<CashItemVO> VOs = new ArrayList<CashItemVO>();
		for(int i = 0; i < bills.size(); i++) {
			CashItemPO po = bills.get(i);
			CashItemVO vo = new CashItemVO(po.getName(), po.getMoney(), po.getRemark());
			VOs.add(vo);
		}
		return VOs;
	}
	
	static public CashBillPO VOtoPO(CashBillVO vo) {
		String ID = vo.ID;
		String user = vo.user;
		String account = vo.account;
		double total = vo.total;
		ArrayList<CashItemPO> bills = itemsVOtoPO(vo.bills);
		CashBillPO po = new CashBillPO(ID, user, account, bills, total);
		return po;
	}

	private static ArrayList<CashItemPO> itemsVOtoPO(ArrayList<CashItemVO> VOs) {
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
}
