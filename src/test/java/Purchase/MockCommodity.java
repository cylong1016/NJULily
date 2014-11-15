package Purchase;

import businesslogic.commoditybl.Commodity;

public class MockCommodity extends Commodity{
	String ID;
	String type;
	
	public MockCommodity(String ID, String type){
		this.ID = ID;
		this.type = type;
	}
	

}
