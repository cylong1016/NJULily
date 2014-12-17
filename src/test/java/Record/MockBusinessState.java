package Record;

import java.util.ArrayList;

import businesslogic.recordbl.BusinessStateList;

public class MockBusinessState extends BusinessStateList{
	

	/**
	 * @param beginDate
	 * @param endDate
	 * @author cylong
	 * @version 2014年12月18日  上午12:23:50
	 */
	public MockBusinessState(String beginDate, String endDate) {
		super(beginDate, endDate);
	}

	ArrayList<MockSale> sales;
	double total;
	
	public void add(MockSale sale){
		sales.add(sale);
		total += sale.income;
	}
	
	public double getTotal(){
		return total;
	}
}
