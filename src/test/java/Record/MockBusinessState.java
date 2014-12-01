package Record;

import java.util.ArrayList;

import businesslogic.recordbl.BusinessStateList;

public class MockBusinessState extends BusinessStateList{
	/**
	 * @param IDs
	 * @author cylong
	 * @version 2014年12月2日  上午4:19:56
	 */
	public MockBusinessState(ArrayList<String> IDs) {
		super(IDs);
		sales = new ArrayList<MockSale>();
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
