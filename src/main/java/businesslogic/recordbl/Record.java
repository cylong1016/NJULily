package businesslogic.recordbl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import blservice.recordblservice.RecordInputInfo;
import message.ResultMessage;
import vo.BusinessStateVO;
import vo.SaleDetailVO;
import vo.ValueObject;

public class Record {
	
	/** 起始时间 */
	public String beginDate;
	/** 结束时间 */
	public String endDate;
	
	SaleDetailList saleDetailList;
	
	BusinessProList bussinessProList;
	
	BusinessStateList bussinessStateList;
	
	public Record() {
	}
	
	/**
	 * 得到销售明细表
	 * @param info
	 * @return
	 * @author Zing
	 * @version Nov 30, 2014 2:21:46 PM
	 */
	public ArrayList<SaleDetailVO> saleDetail(RecordInputInfo info) {
		this.beginDate = info.beginDate;
		this.endDate = info.endDate;
		saleDetailList = new SaleDetailList(info.commodityName, info.clientName, info.salesman, info.storage);
		return saleDetailList.getSaleDetail(getID());
	}

	public ArrayList<ValueObject> bussinessPro(RecordInputInfo info) {
		this.beginDate = info.beginDate;
		this.endDate = info.endDate;
		bussinessProList = new BusinessProList(info.billType, info.clientName, info.salesman, info.storage);
		return bussinessProList.getBusinessPro(getID());
	}

	public ResultMessage red(ValueObject valueRecord) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage copyRed(ValueObject valueRecord) {
		// TODO Auto-generated method stub
		return null;
	}

	public BusinessStateVO businessState(RecordInputInfo info) {	
		this.beginDate = info.beginDate;
		this.endDate = info.endDate;
		bussinessStateList = new BusinessStateList(getID());
		
		return null;
	}

	public ResultMessage earning() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage expense() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 得到所有的日期区间内的ID
	 * @return
	 * @author Zing
	 * @version Nov 30, 2014 1:50:47 PM
	 */
	private ArrayList<String> getID() {
		ArrayList<String> IDs = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			Date begin = sdf.parse(beginDate);
			Date end = sdf.parse(endDate);
			double between = (end.getTime() - begin.getTime())/1000;
			double day = between/24/3600;
			for (int i = 0; i < day; i++) {
				Calendar cd = Calendar.getInstance();
				cd.setTime(sdf.parse(beginDate));
				cd.add(Calendar.DATE, i);
				String ID = sdf.format(cd.getTime());
				IDs.add(ID);
			}		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//XSD-yyyyMMdd
		return IDs;
	}

}
