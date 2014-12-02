package server.data.purchasedata;

import java.text.SimpleDateFormat;
import java.util.Date;

import po.PurchasePO;
import server.common.ParseXML;
import server.data.CommonData;
import dataenum.BillType;
import dataservice.TableInfoService;
import dataservice.purchasedataservice.PurchaseDataService;

/**
 * @see dataservice.purchasedataservice.PurchaseDataService
 * @author cylong
 * @version 2014年12月1日 下午4:18:52
 */
public class PurchaseData extends CommonData<PurchasePO> implements PurchaseDataService {

	/** JHD */
	private String purchaseID;
	/** JHTHD */
	private String purchasebackID;

	/**
	 * @see dataservice.DataService#init()
	 */
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

	/**
	 * 根据单据类型获得编号前缀
	 * @param type 单据类型
	 * @return ID前缀
	 * @author cylong
	 * @version 2014年12月2日 下午4:27:44
	 */
	protected String getPreID(BillType type) {
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
	public TableInfoService<PurchasePO> getInfo() {
		return new PurchaseInfo();
	}

}
