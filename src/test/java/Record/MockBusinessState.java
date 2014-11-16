package Record;

import java.util.ArrayList;

import businesslogic.recordbl.BussinessStateList;

public class MockBusinessState extends BussinessStateList{
	ArrayList<MockSale> sales;
	double total;
	public MockBusinessState(){
		sales = new ArrayList<MockSale>();
	}
	
	public void add(MockSale sale){
		sales.add(sale);
		total += sale.income;
	}
	
	public double getTotal(){
		return total;
	}
}
