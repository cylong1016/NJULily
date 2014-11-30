package businesslogic.recordbl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import blservice.recordblservice.RecordInputInfo;
import message.ResultMessage;
import vo.SaleDetailVO;
import vo.ValueObject;

public class Record {
	
	/** 起始时间 */
	public String beginDate;
	/** 结束时间 */
	public String endDate;
	
	SaleDetailList saleDetailList;
	
	BussinessProList bussinessProList;
	
	BussinessStateList bussinessStateList;
	
	public Record() {
	}
	
	public ArrayList<SaleDetailVO> saleDetail(RecordInputInfo info) {
		this.beginDate = info.beginDate;
		this.endDate = info.endDate;
		saleDetailList = new SaleDetailList(info);
		if () {
			
		}
		saleDetailList.getSaleDetail(getID());
		return null;
	}

	public ArrayList<ValueObject> bussinessPro(RecordInputInfo info) {
		return null;
	}

	public ResultMessage red(ValueObject valueRecord) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage copyRed(ValueObject valueRecord) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage businessState(RecordInputInfo info) {
		// TODO Auto-generated method stub
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
