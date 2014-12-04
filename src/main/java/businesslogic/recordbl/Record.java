package businesslogic.recordbl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import dataenum.BillType;
import blservice.recordblservice.RecordInputInfo;
import message.ResultMessage;
import vo.AccountBillVO;
import vo.BusinessStateVO;
import vo.CashBillVO;
import vo.InventoryBillVO;
import vo.PurchaseVO;
import vo.SaleDetailVO;
import vo.SalesVO;
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
	 * @return 每一条销售明细列表（商品）
	 * @author Zing
	 * @version Nov 30, 2014 2:21:46 PM
	 */
	public ArrayList<SaleDetailVO> saleDetail(RecordInputInfo info) {
		this.beginDate = info.beginDate;
		this.endDate = info.endDate;
		saleDetailList = new SaleDetailList(info.commodityName, info.clientName, info.salesman, info.storage);
		return saleDetailList.getSaleDetail(getID());
	}

	/**
	 * 根据时间区间、单据类型、客户名、业务员名、仓库，查找相应的经营历程表
	 * @param info
	 * @return 单据列表
	 * @author Zing
	 * @version Dec 4, 2014 8:21:03 PM
	 */
	public ArrayList<ValueObject> bussinessPro(RecordInputInfo info) {
		this.beginDate = info.beginDate;
		this.endDate = info.endDate;
		bussinessProList = new BusinessProList(info.billType, info.clientName, info.salesman, info.storage);
		return bussinessProList.getBusinessPro(getID());
	}

	/**
	 * 红冲（新建一张相应的单据，只是数据取负，相当于删除）
	 * @param valueRecord
	 * @return
	 * @author Zing
	 * @version Dec 4, 2014 8:21:06 PM
	 */
	public ValueObject red(ValueObject vo, BillType type) {
		boolean  isCopy = false;
		return buildRed(vo, type, isCopy);
	}

	/**
	 * 红冲并复制（新建一张相应的单据，数据取负，但是只是作为草稿，可以进行修改）
	 * @param valueRecord
	 * @return
	 * @author Zing
	 * @version Dec 4, 2014 8:21:09 PM
	 */
	public ValueObject copyRed(ValueObject vo, BillType type) {
		boolean isCopy = true;
		return buildRed(vo, type, isCopy);
	}

	/**
	 * 根据时间区间查看经营情况表
	 * @param info
	 * @return
	 * @author Zing
	 * @version Dec 4, 2014 8:21:12 PM
	 */
	public BusinessStateVO businessState(String beginDate, String endDate) {	
		this.beginDate = beginDate;
		this.endDate = endDate;
		bussinessStateList = new BusinessStateList(getID());	
		return bussinessStateList.getBusinessState();
	}
	
	private ValueObject buildRed(ValueObject vo, BillType type, boolean isCopy) {
		Red red = new Red(isCopy);
		switch (type) {
		case SALE:
		case SALEBACK:
			return red.addRed((SalesVO)vo);
		case PURCHASE:
		case PURCHASEBACK:
			return red.addRed((PurchaseVO)vo);
		case GIFT:
		case OVERFLOW:
		case LOSS:
			return red.addRed((InventoryBillVO)vo);
		case PAY:
		case EXPENSE:
			return red.addRed((AccountBillVO)vo);
		case CASH:
			return red.addRed((CashBillVO)vo);
		default:
			break;
		}
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
		return IDs;
	}

}
