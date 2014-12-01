package Record;

import static org.junit.Assert.*;

import org.junit.Test;

public class testBussinessState {

	@Test
	public void test() {
		MockSale sale1 = new MockSale(100);
		MockSale sale2 = new MockSale(200);
		
		
		MockBusinessState businessState = new MockBusinessState(null);
		businessState.add(sale1);
		businessState.add(sale2);
		
		assertEquals(300, businessState.getTotal(), 0.01);
	}

}
