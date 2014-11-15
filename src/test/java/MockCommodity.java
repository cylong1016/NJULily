import businesslogic.commoditybl.Commodity;


public class MockCommodity extends Commodity{
	String ID;
	String type;
	
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
