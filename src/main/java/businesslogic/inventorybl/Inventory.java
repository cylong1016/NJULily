package businesslogic.inventorybl;

import java.rmi.Naming;
import java.util.ArrayList;

import config.RMI;
import businesslogic.approvalbl.WaitApproval;
import po.InventoryBillPO;
import po.InventoryCheckPO;
import po.InventoryViewPO;
import vo.InventoryBillVO;
import vo.InventoryCheckVO;
import dataservice.DataFactoryService;
import dataservice.InventoryDataService;
import message.ResultMessage;

public class Inventory extends WaitApproval{
	
	private GiftList list;
	
	public Inventory() {
		
	}
	
	public InventoryDataService getInventoryData(){
		try {
			DataFactoryService factory = (DataFactoryService)Naming.lookup(RMI.URL);
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
	
	public InventoryCheckVO checkRecord() {
		InventoryDataService inventoryData = getInventoryData();
		CheckList checkList = new CheckList(inventoryData.returnNumber());
		InventoryCheckPO po = new InventoryCheckPO(checkList.getItemsPO(), checkList.getToday(), checkList.getLot());
		inventoryData.insert(po);
		InventoryCheckVO vo = new InventoryCheckVO(checkList.getItemsVO(), checkList.getToday(), checkList.getLot());
		return vo;
	}
	
	public void buildGift(){
		list = new GiftList();
	}
	
	public void addCommodity(String ID, int number) {
		GiftListItem item = new GiftListItem(ID, number);
		list.addItem(item);
	}
	
	public InventoryBillPO getGiftRecord(){
		InventoryBillPO po = new InventoryBillPO(list.getCommodityPOs(), list.getRemark());
		return po;
	}
	
	public InventoryBillVO submit(String remark){
		list.setRemark(remark);
		InventoryDataService inventoryData = getInventoryData();
		getApprovalData().insert(getGiftRecord());
		return null;
	}
}
