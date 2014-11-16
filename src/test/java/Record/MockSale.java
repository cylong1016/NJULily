package Record;

import businesslogic.salebl.Sale;

public class MockSale extends Sale{
	double income;
	
	public MockSale(double income){
	this.income = income;
	}
	
	double getIncome(){
		return income;
	}
}
