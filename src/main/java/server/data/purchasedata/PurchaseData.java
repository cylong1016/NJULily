package server.data.purchasedata;

import java.text.SimpleDateFormat;
import java.util.Date;

import po.PurchasePO;
import server.common.ParseXML;
import server.data.CommonData;
import dataenum.BillType;
import dataservice.purchasedataservice.PurchaseDataService;
import dataservice.purchasedataservice.PurchaseInfoService;

/**
 * @see dataservice.purchasedataservice.PurchaseDataService
 * @author cylong
 * @version 2014年12月1日 下午4:18:52
 */
public class PurchaseData extends CommonData<PurchasePO> implements PurchaseDataService {

	/** 当天日期 */
	private String currentDate;
	/** JHD */
	private String purchaseID;
	/** JHTHD */
	private String purchasebackID;
	/** 文件中记录的日期 */
	private String dateRecord;

	@Override
	public void init() {
		parsexml = new ParseXML("PurchaseData");
		purchaseID = parsexml.getValue("purchaseID");
		purchasebackID = parsexml.getValue("purchasebackID");
		dateRecord = parsexml.getValue("dateRecord");
		String dateFormat = parsexml.getValue("dateFormat");
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		currentDate = sdf.format(new Date());
	}

	@Override
	public String getID(BillType type) {
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
		return getPreID(type) + ID;
	}

	/**
	 * 根据单据类型获得编号前缀
	 * @param type 单据类型
	 * @return ID前缀
	 * @author cylong
	 * @version 2014年12月2日 下午4:27:44
	 */
	private String getPreID(BillType type) {
		switch(type) {
		case PURCHASE:
			return purchaseID + "-" + currentDate + "-";
		case PURCHASEBACK:
			return purchasebackID + "-" + currentDate + "-";
		default:
			return null;
		}
	}

	/**
	 * @see dataservice.purchasedataservice.PurchaseDataService#getInfo()
	 */
	@Override
	public PurchaseInfoService getInfo() {
		return new PurchaseInfo();
	}

}
