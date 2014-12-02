package server.data.saledata;

import java.text.SimpleDateFormat;
import java.util.Date;

import po.SalesPO;
import server.common.ParseXML;
import server.data.CommonData;
import dataenum.BillType;
import dataservice.saledataservice.SaleDataService;
import dataservice.saledataservice.SaleInfoService;

/**
 * @see dataservice.saledataservice.SaleDataService
 * @author cylong
 * @version 2014年11月27日 下午7:53:50
 */
public class SaleData extends CommonData<SalesPO> implements SaleDataService {

	/** 当天日期 */
	private String currentDate;
	/** XSD */
	private String saleID;
	/** XSTHD */
	private String salebackID;
	/** 文件中记录的日期 */
	private String dateRecord;

	/**
	 * @see dataservice.DataService#init()
	 */
	@Override
	public void init() {
		parsexml = new ParseXML("SaleData");
		saleID = parsexml.getValue("saleID");
		salebackID = parsexml.getValue("salebackID");
		dateRecord = parsexml.getValue("dateRecord");
		String dateFormat = parsexml.getValue("dateFormat");
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		currentDate = sdf.format(new Date());
	}

	/**
	 * @see dataservice.saledataservice.SaleDataService#getID(dataenum.BillType)
	 */
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
		case SALE:
			return saleID + "-" + currentDate + "-";
		case SALEBACK:
			return salebackID + "-" + currentDate + "-";
		default:
			return null;
		}
	}

	/**
	 * @see dataservice.saledataservice.SaleDataService#getInfo()
	 */
	@Override
	public SaleInfoService getInfo() {
		return new SaleInfo();
	}

}
