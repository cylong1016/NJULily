import businesslogic.purchasebl.PurchaseListItem;


public class MockPurchaseItem extends PurchaseListItem{

	String name;
	int number;
	double price;
	double total;
	String remark;

	public MockPurchaseItem(String name, int number, double price, String remark) {
		//super(name, number, price, remark);
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
