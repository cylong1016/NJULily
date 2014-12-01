package server.data.accountbilldata;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import po.AccountBillPO;
import server.common.Common;
import server.common.ParseXML;
import server.data.CommonData;
import dataenum.BillType;
import dataservice.accountbilldataservice.AccountBillDataService;
import dataservice.accountbilldataservice.AccountBillInfoService;

/**
 * @author cylong
 * @version 2014年11月30日 下午10:50:32
 */
public class AccountBillData extends CommonData<AccountBillPO> implements AccountBillDataService {

	/** 付款单或付款单最大ID */
	private int maxID;
	/** 当天日期 */
	private String currentDate;

	/**
	 * @see dataservice.DataService#init()
	 */
	@Override
	public void init() {
		parsexml = new ParseXML("AccountBillData");
		maxID = 0; // 默认的最大ID为0
		String dateFormat = parsexml.getValue("dateFormat");
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		currentDate = sdf.format(new Date());
	}

	/**
	 * @see dataservice.accountbilldataservice.AccountBillDataService#getID(dataenum.BillType)
	 */
	@Override
	public String getID(BillType type) {
		for(int i = poList.size() - 1; i >= 0; i--) {
			AccountBillPO po = poList.get(i);
			int maxID = Integer.parseInt(po.getID().split("-")[2]);
			if (po.getType().equals(type)) {
				this.maxID = maxID;
			}

			// 从后往前找，越往前ID越小
			if (this.maxID > 0) {
				switch(type) {
				case EXPENSE:
					return "SKD-" + currentDate + "-" + Common.intToString(this.maxID + 1, IDMaxBit);
				case PAY:
					return "FKD-" + currentDate + "-" + Common.intToString(this.maxID + 1, IDMaxBit);
				default:
					return null;
				}
			}
		}

		// 不包含该类型的账单的时候
		switch(type) {
		case EXPENSE:
			return "SKD-" + currentDate + "-" + Common.intToString(this.maxID + 1, IDMaxBit);
		case PAY:
			return "FKD-" + currentDate + "-" + Common.intToString(this.maxID + 1, IDMaxBit);
		default:
			return null;
		}
	}

	/**
	 * 默认得到收款单ID
	 * @deprecated cylong的失误不要在意！
	 * @see server.data.CommonData#getID()
	 */
	@Override
	public String getID() {
		return getID(BillType.EXPENSE);
	}

	/**
	 * @see dataservice.accountbilldataservice.AccountBillDataService#show(dataenum.BillType)
	 */
	@Override
	public ArrayList<AccountBillPO> show(BillType type) {
		ArrayList<AccountBillPO> bills = new ArrayList<AccountBillPO>();
		for(AccountBillPO po : poList.getInList()) {
			if (po.getType().equals(type)) {
				bills.add(po);
			}
		}
		return bills;
	}

	/**
	 * @see dataservice.accountbilldataservice.AccountBillDataService#getInfo()
	 */
	@Override
	public AccountBillInfoService getInfo() {
		return new AccountBillInfo();
	}

}
