package server.data.cashbilldata;

import java.text.SimpleDateFormat;
import java.util.Date;

import po.CashBillPO;
import server.common.ParseXML;
import server.data.CommonData;
import dataservice.TableInfoService;
import dataservice.cashbilldataservice.CashBillDataService;

/**
 * @see dataservice.cashbilldataservice.CashBillDataService
 * @author cylong
 * @version 2014年12月1日 下午4:19:54
 */
public class CashBillData extends CommonData<CashBillPO> implements CashBillDataService {

	/** 当天日期 */
	private String currentDate;
	/** 文件中记录的日期 */
	private String dateRecord;

	/**
	 * @see dataservice.DataService#init()
	 */
	@Override
	public void init() {
		parsexml = new ParseXML("CashBillData");
		prefix = parsexml.getValue("prefix");
		dateRecord = parsexml.getValue("dateRecord");
		String dateFormat = parsexml.getValue("dateFormat");
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		currentDate = sdf.format(new Date());
	}

	/**
	 * 超过一天最大ID数量时候返回null
	 * @see server.data.CommonData#getID()
	 */
	@Override
	public String getID() {
		if (currentDate.equals(dateRecord)) {
			maxID = Integer.parseInt(parsexml.getValue("maxID"));
		} else {	// 过了一天
			parsexml.setValue("dateRecord", currentDate);
			maxID = 0;	// 初始化最大ID
		}
		String ID = super.getID();
		if (ID.length() > IDMaxBit) {	// 超过一天单据的最大数量
			return null;
		}
		return prefix + "-" + currentDate + "-" + ID;
	}

	/**
	 * @see dataservice.cashbilldataservice.CashBillDataService#getInfo()
	 */
	@Override
	public TableInfoService<CashBillPO> getInfo() {
		return new CashBillInfo();
	}

}
