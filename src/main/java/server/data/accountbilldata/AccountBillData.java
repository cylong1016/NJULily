package server.data.accountbilldata;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import po.AccountBillPO;
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

	/** 当天日期 */
	private String currentDate;
	/** SKD */
	private String expenseID;
	/** FKD */
	private String payID;
	/** 文件中记录的日期 */
	private String dateRecord;

	/**
	 * @see dataservice.DataService#init()
	 */
	@Override
	public void init() {
		parsexml = new ParseXML("AccountBillData");
		expenseID = parsexml.getValue("expenseID");
		payID = parsexml.getValue("payID");
		dateRecord = parsexml.getValue("dateRecord");
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
		if (currentDate.equals(dateRecord)) {
			maxID = Integer.parseInt(parsexml.getValue("maxID"));
		} else {	// 过了一天
			parsexml.setValue("dateRecord", currentDate);
			maxID = 0;	// 初始化最大ID
		}
		return getPreID(type) + super.getID();
	}

	/**
	 * 根据单据类型获得编号前缀
	 * @param type 单据类型
	 * @return ID前缀
	 * @author cylong
	 * @version 2014年12月2日 上午5:36:32
	 */
	private String getPreID(BillType type) {
		switch(type) {
		case EXPENSE:
			return expenseID + "-" + currentDate + "-";
		case PAY:
			return payID + "-" + currentDate + "-";
		default:
			return null;
		}
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
