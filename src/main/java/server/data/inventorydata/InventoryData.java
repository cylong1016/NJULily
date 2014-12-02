package server.data.inventorydata;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import po.InventoryBillPO;
import server.common.ParseXML;
import server.data.CommonData;
import dataenum.BillType;
import dataservice.TableInfoService;
import dataservice.inventorydataservice.InventoryDataService;

/**
 * dataservice.inventorydataservice.InventoryDataService
 * @author cylong
 * @version 2014年12月1日 下午4:20:49
 */
public class InventoryData extends CommonData<InventoryBillPO> implements InventoryDataService {

	/** BYD */
	private String overflowID;
	/** BSD */
	private String lossID;
	/** BJD */
	private String alarmID;
	/** ZSD */
	private String giftID;

	/**
	 * @see dataservice.DataService#init()
	 */
	@Override
	public void init() {
		parsexml = new ParseXML("InventoryData");
		overflowID = parsexml.getValue("overflowID");
		lossID = parsexml.getValue("lossID");
		alarmID = parsexml.getValue("alarmID");
		giftID = parsexml.getValue("giftID");
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
	 * @version 2014年12月2日 下午5:50:25
	 */
	@Override
	protected String getPreID(BillType type) {
		switch(type) {
		case OVERFLOW:
			return overflowID + "-" + currentDate + "-";
		case LOSS:
			return lossID + "-" + currentDate + "-";
		case ALARM:
			return alarmID + "-" + currentDate + "-";
		case GIFT:
			return giftID + "-" + currentDate + "-";
		default:
			return null;
		}
	}

	/**
	 * @see dataservice.inventorydataservice.InventoryDataService#returnNumber()
	 */
	@Override
	public String returnNumber() {
		// TODO 返回一个盘点的批号
		return null;
	}

	public ArrayList<InventoryBillPO> show(BillType type) {
		ArrayList<InventoryBillPO> typePOs = new ArrayList<InventoryBillPO>();
		for(InventoryBillPO po : poList.getInList()) {
			if (po.getBillType().equals(type)) {
				typePOs.add(po);
			}
		}
		return typePOs;
	}

	/**
	 * @see dataservice.inventorydataservice.InventoryDataService#getInfo()
	 */
	@Override
	public TableInfoService<InventoryBillPO> getInfo() {
		return new InventoryInfo();
	}

}
