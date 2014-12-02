package server.data.saledata;

import java.text.SimpleDateFormat;
import java.util.Date;

import po.SalesPO;
import server.common.ParseXML;
import server.data.CommonData;
import dataenum.BillType;
import dataservice.TableInfoService;
import dataservice.saledataservice.SaleDataService;

/**
 * @see dataservice.saledataservice.SaleDataService
 * @author cylong
 * @version 2014年11月27日 下午7:53:50
 */
public class SaleData extends CommonData<SalesPO> implements SaleDataService {

	/** XSD */
	private String saleID;
	/** XSTHD */
	private String salebackID;

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
	 * 根据单据类型获得编号前缀
	 * @param type 单据类型
	 * @return ID前缀
	 * @author cylong
	 * @version 2014年12月2日 下午4:27:44
	 */
	protected String getPreID(BillType type) {
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
	public TableInfoService<SalesPO> getInfo() {
		return new SaleInfo();
	}

}
