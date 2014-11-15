package Inventory;
import businesslogic.commoditybl.Commodity;


public class MockCommodity extends Commodity{
	private String ID;
	private String type;
	
	public MockCommodity(String ID, String type){
		this.ID = ID;
		this.type = type;
	}
	
	public String getID(String name){
		return ID;
	}
	
	public String getType(String name){
		return type;
	}
}
