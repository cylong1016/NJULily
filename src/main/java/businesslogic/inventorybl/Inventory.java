package businesslogic.inventorybl;

import java.rmi.Naming;
import java.util.ArrayList;

import po.InventoryCheckPO;
import vo.InventoryCheckVO;
import dataservice.DataFactoryService;
import dataservice.InventoryDataService;
import message.ResultMessage;

public class Inventory {
	
	public Inventory() {
		
	}
	
	public InventoryDataService getInventoryData(){
		try {
			DataFactoryService factory = (DataFactoryService)Naming.lookup("rmi://127.0.0.1:8888/factory");
			InventoryDataService inventoryData = (InventoryDataService)factory.getInventoryData();
			return inventoryData;		
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}
	
	public ResultMessage viewInventory(String beginDate, String endDate) {
		ViewList viewList = new ViewList(beginDate, endDate);
		
		return null;
	}
	
	public ArrayList<InventoryCheckVO> checkRecord() {
		InventoryDataService inventoryData = getInventoryData();
		CheckList checkList = new CheckList(inventoryData.returnNumber());
		InventoryCheckPO po = new InventoryCheckPO(checkList.getItems(), checkList.getToday(), checkList.getLot());
		inventoryData.insert(po);
		
		return null;
	}
}
