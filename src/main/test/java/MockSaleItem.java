import businesslogic.salebl.SaleListItem;

public class MockSaleItem extends SaleListItem{
	
	String name;
	int number;
	double price;
	double total;
	String remark;

	public MockSaleItem(String name, int number, double price, String remark) {
		super(name, number, price, remark);
		this.name = name;
		this.number = number;
		this.price = price;
		this.total = number * price;
		this.remark = remark;		
	}
	
	public double getTotal(){
		return total;
	}
	
	
}
