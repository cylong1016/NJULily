package businesslogic.recordbl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import dataenum.Storage;
import vo.SaleDetailVO;
import blservice.recordblservice.RecordInputInfo;
import businesslogic.recordbl.info.SaleInfo_Record;
import businesslogic.salebl.Sale;

public class SaleDetailList {

	/** 客户名 */
	public String clientName;
	/** 业务员 */
	public String salesman;
	/** 仓库 */
	public Storage storage;
	/** 商品名 */
	public String commodityName;
	
	public String saleID;
	
	public SaleInfo_Record info;
	
	public SaleDetailList(RecordInputInfo info) {
		this.clientName = info.clientName;
		this.salesman = info.salesman;
		this.storage = info.storage;
		this.commodityName = info.commodityName;
	}
	
	public ArrayList<SaleDetailVO> getSaleDetail(ArrayList<String> IDs) {
		info = new Sale();
		for (int i = 0; i < IDs.size(); i++) {
			String ID = info.getSaleDetailVO(IDs.get(i), clientName, salesman, storage, commodityName);
			
		}
		return null;
	}
	
//	private ArrayList<String> getID() {
//		ArrayList<String> IDs = new ArrayList<String>();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//		try {
//			Date begin = sdf.parse(beginDate);
//			Date end = sdf.parse(endDate);
//			double between = (end.getTime() - begin.getTime())/1000;
//			double day = between/24/3600;
//			for (int i = 0; i < day; i++) {
//				Calendar cd = Calendar.getInstance();
//				cd.setTime(sdf.parse(beginDate));
//				cd.add(Calendar.DATE, i);
//				String ID = sdf.format(cd.getTime());
//				IDs.add(ID);
//			}		
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		//XSD-yyyyMMdd
//		return IDs;
//	}
	private ArrayList<SaleDetailVO> find() {
		
		return null;
	}

}
