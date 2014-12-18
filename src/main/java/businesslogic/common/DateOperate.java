package businesslogic.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DateOperate {
	
	static final public String FORMAT = "yyyyMMdd";
	
	/**
	 * 将起始日期String转为Date
	 * @author Zing
	 * @version Dec 17, 2014 10:18:42 AM
	 */
	static public Date changeBeginDate(String beginDate) {
		try {
			if (beginDate == null) {
				Date begin = new SimpleDateFormat(FORMAT).parse("20000101");
				return begin;
			}
			String year = beginDate.substring(0, 4);
			if (Integer.parseInt(year) < 2000) {
				beginDate = beginDate.replace(year, "2000");
			}
			Date begin = new SimpleDateFormat("yyyyMMdd").parse(beginDate);
			return begin;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return  null;
	}
	
	/**
	 * 将结束日期String转为Date
	 * @author Zing
	 * @version Dec 17, 2014 10:19:16 AM
	 */
	static public Date changeEndDate(String endDate) {
		try {
			if (endDate == null) {
				Date end = new Date();
				return end;
			}
			Date end = new SimpleDateFormat("yyyyMMdd").parse(endDate);
			if (end.getTime() > new Date().getTime()) {
				end = new Date();
			}
			return end;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return  null;
	}
	
	/**
	 * 查找是否有合适的ID
	 * @author Zing
	 * @version Dec 17, 2014 10:39:49 AM
	 */
	static public ArrayList<String> findFitDate(ArrayList<String> IDs, Date beginDate, Date endDate) {
		ArrayList<String> resultIDs = new ArrayList<String>();
		for (String id : IDs) {
			System.out.println(id);
			String dateID = id.split("-")[1];
			Date date = null;
			try {
				date = new SimpleDateFormat("yyyyMMdd").parse(dateID);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if (date.getTime() >= beginDate.getTime() && date.getTime() <= endDate.getTime()) {
				resultIDs.add(id);
			}
		}
		return resultIDs;
	}
	
	/**
	 * 判断该ID是否在指定日期内
	 * @param ID
	 * @param begin
	 * @param end
	 * @return
	 * @author Zing
	 * @version Dec 18, 2014 7:29:28 PM
	 */
	static public boolean isIncluded(String ID, String begin, String end) {
		String dateID = ID.split("-")[1];
		Date beginDate = changeBeginDate(begin);
		Date endDate = changeEndDate(end);
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyyMMdd").parse(dateID);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (date.getTime() >= beginDate.getTime() && date.getTime() <= endDate.getTime()) {
			return true;
		}
		return false;
	}

}
