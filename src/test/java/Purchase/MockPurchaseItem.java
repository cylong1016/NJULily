package Purchase;
import businesslogic.purchasebl.PurchaseListItem;


public class MockPurchaseItem extends PurchaseListItem{
	String ID;
	String type;
	String name;
	int number;
	double price;
	double total;
	String remark;

	public MockPurchaseItem(String name, int number, double price, String remark, MockCommodity commodity) {
		this.name = name;
		this.number = number;
		this.price = price;
		this.total = number * price;
		this.remark = remark;
		this.ID = commodity.ID;
		this.type = commodity.type;
	}
	
	public double getTotal(){
		return total;
	}
	
	public String getType() {
		return type;
	}
	
	public String getID(){
		return ID;
	}
}
