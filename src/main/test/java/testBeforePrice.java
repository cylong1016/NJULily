
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import businesslogic.salebl.SaleList;


public class testBeforePrice {

	@Test
	public void test() {
		MockSaleItem item1 = new MockSaleItem("aa", 5, 20, null);
		MockSaleItem item2 = new MockSaleItem("bb", 10, 10, null);
		
		SaleList list = new SaleList();
		list.add(item1);
		list.add(item2);
	
		double before = list.getBeforePrice();
		
		assertEquals(before, 200, 0.01);
		
	}

}
