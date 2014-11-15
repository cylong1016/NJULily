package Purchase;

import static org.junit.Assert.*;

import org.junit.Test;

import businesslogic.purchasebl.PurchaseList;

public class testType {

	@Test
	public void test() {
		MockCommodity commodity1 = new MockCommodity("a1", "SQR");
		MockPurchaseItem purchaseItem = new MockPurchaseItem("a", 12, 10, null, commodity1);
		MockCommodity commodity2 = new MockCommodity("a2", "SWQ");
		MockPurchaseItem purchaseItem2 = new MockPurchaseItem("b",10, 10, null, commodity2);
		
		PurchaseList list = new PurchaseList();
		list.add(purchaseItem);
		list.add(purchaseItem2);
		
		assertEquals("a1", list.getCommodities().get(0).getID());
	}

}
