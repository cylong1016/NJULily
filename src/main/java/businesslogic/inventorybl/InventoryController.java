package businesslogic.inventorybl;

import java.util.ArrayList;

import dataenum.BillType;
import vo.InventoryBillVO;
import vo.InventoryCheckVO;
import vo.InventoryViewVO;
import message.ResultMessage;
import blservice.inventoryblservice.InventoryBLService;

public class InventoryController implements InventoryBLService{
	
	private Inventory inventory;
	
	public InventoryController() {
		inventory = new Inventory();
	}
	public InventoryViewVO viewInventory(String beginDate, String endDate) {
		return inventory.viewInventory(beginDate, endDate);
	}
	public InventoryCheckVO checkRecord() {
		return inventory.checkRecord();
	}

	public void buildBill(BillType type) {
		inventory.buildBill(type);
	}
	public void addCommodity(String ID, int number) {
		inventory.addCommodity(ID, number);	
	}
	
	public ResultMessage submit(String remark) {
		return inventory.submit(remark);
	}
	public ResultMessage save(String remark) {
		return inventory.save(remark);
	}
	public ArrayList<InventoryBillVO> show(BillType type) {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<InventoryBillVO> show() {
		// TODO Auto-generated method stub
		return null;
	}
}
