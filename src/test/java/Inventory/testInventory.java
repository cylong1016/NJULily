package Inventory;

import org.junit.Test;

public class testInventory {

	@Test
	public void test() {
		MockAlarmList mal1 = new MockAlarmList("0001", new MockCommodity("a1", "SQQ"),10); 
		MockAlarmList mal2 = new MockAlarmList("0002", new MockCommodity("a3", "S12Q"),21); 
		
		MockOverList mol = new MockOverList("001", new MockCommodity("a21", "SQQa"),11);
		
		MockLossList mll = new MockLossList("002", new MockCommodity("asdaw", "Sqweq"),7);
		
		MockGiftCommodityItem mgmi1 =  new MockGiftCommodityItem(new MockCommodity("asdaw", "S12q"),20);
		MockGiftCommodityItem mgmi2 =  new MockGiftCommodityItem(new MockCommodity("a", "S1q"),10);
		
		MockGiftlist mgl = new MockGiftlist();
		mgl.add("00001", "2014-12-11", "wanglaowu", mgmi1);
		mgl.add("00001", "2014-12-11", "wanglaowu", mgmi2);
		
		MockInventory mi = new MockInventory();
		mi.add(new MockCommodity("asdaw", "S12q"));
		mi.add(new MockCommodity("a1", "SQQ"));
		
		MockCheckList mcl = new MockCheckList("0123");
		
		MockViewListItem mvli = new MockViewListItem();
		mvli.add(mal1);
		mvli.add(mal2);
		mvli.add(mol);
		mvli.add(mll);
		mvli.add(mgl);
		mvli.add(mcl);
		
		MockViewList mvl = new MockViewList(mvli);
		
	}

}
