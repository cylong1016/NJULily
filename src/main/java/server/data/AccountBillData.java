package server.data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import po.AccountBillPO;
import server.common.Common;
import server.common.ParseXML;
import server.io.DefineList;
import dataenum.BillType;
import dataenum.Storage;
import dataservice.AccountBillDataService;
import dataservice.commondata.DataInfo;

/**
 * @author cylong
 * @version 2014年11月30日 下午10:50:32
 */
public class AccountBillData extends CommonData<AccountBillPO> implements AccountBillDataService, DataInfo {

	/** 付款单或付款单最大ID */
	private int maxID;
	/** 当天日期 */
	private String currentDate;
	private int maxBit = 5;	// 最大数量的位数

	/**
	 * @see dataservice.commondata.DataService#init()
	 */
	@Override
	public void init() {
		ParseXML parsexml = new ParseXML("AccountBillData");
		filePath = parsexml.getValue("path");
		poList = new DefineList<AccountBillPO>(filePath);
		initID = parsexml.getValue("initID");
		maxID = 0; // 默认的最大ID为0
		String dateFormat = parsexml.getValue("dateFormat");
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		currentDate = sdf.format(new Date());
	}

	/**
	 * @see dataservice.AccountBillDataService#getID(dataenum.BillType)
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
					return "SKD-" + currentDate + "-" + Common.intToString(this.maxID + 1, maxBit);
				case PAY:
					return "FKD-" + currentDate + "-" + Common.intToString(this.maxID + 1, maxBit);
				default:
					return null;
				}
			}
		}

		// 不包含该类型的账单的时候
		switch(type) {
		case EXPENSE:
			return "SKD-" + currentDate + "-" + Common.intToString(this.maxID + 1, maxBit);
		case PAY:
			return "FKD-" + currentDate + "-" + Common.intToString(this.maxID + 1, maxBit);
		default:
			return null;
		}
	}

	/**
	 * @deprecated 请用getID(BillType type)方法
	 */
	@Override
	public String getID() {
		return null;
	}

	/**
	 * @see dataservice.AccountBillDataService#show(dataenum.BillType)
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

}
