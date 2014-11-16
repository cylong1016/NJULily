package Sale;
import businesslogic.salebl.SaleListItem;

public class MockSaleItem extends SaleListItem{
	
	String name;
	int number;
	double price;
	double total;
	String remark;
	String ID;
	String type;
	

	public MockSaleItem(String name, int number, double price, String remark, MockCommodity commodity) {
//		super(name, number, price, remark);
		this.name = name;
		this.number = number;
		this.price = price;
		this.total = number * price;
		this.remark = remark;	
		this.type = commodity.type;
		this.ID = commodity.ID;
	}
	
	public double getTotal(){
		return total;
	}
	
}
