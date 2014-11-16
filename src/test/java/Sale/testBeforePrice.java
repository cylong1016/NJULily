package Sale;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import businesslogic.salebl.SaleList;


public class testBeforePrice {

	@Test
	public void test() {
		MockCommodity commodity1 = new MockCommodity("a1", "SQQ");
		MockCommodity commodity2 = new MockCommodity("a2", "RRE");
		MockSaleItem item1 = new MockSaleItem("aa", 5, 20, null, commodity1);
		MockSaleItem item2 = new MockSaleItem("bb", 10, 10, null, commodity2);
				
		SaleList list = new SaleList();
		list.add(item1);
		list.add(item2);
	
		double before = list.getBeforePrice();
		
		assertEquals(before, 200.0, 0.01);
		
	}

}
