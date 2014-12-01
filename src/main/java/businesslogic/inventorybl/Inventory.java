package businesslogic.inventorybl;

import java.rmi.Naming;
import java.util.ArrayList;

import businesslogic.common.CommodityItemPOtoVO;
import businesslogic.promotionbl.InventoryInfo_Promotion;
import businesslogic.recordbl.info.InventoryInfo_Record;
import businesslogic.recordbl.info.ValueObjectInfo_Record;
import config.RMI;
import po.CommodityItemPO;
import po.InventoryBillPO;
import vo.CommodityItemVO;
import vo.InventoryBillVO;
import vo.InventoryCheckVO;
import vo.ValueObject;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.Storage;
import dataservice.InventoryDataService;
import dataservice.commondata.DataFactoryService;
import message.ResultMessage;

public class Inventory extends CommodityItemPOtoVO {
	
	private BillList list;
		
	private BillType type;
	
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
		// TODO 库存查看
	//	ViewList viewList = new ViewList(beginDate, endDate);
		
		return null;
	}
	
	public InventoryCheckVO checkRecord() {
		InventoryDataService inventoryData = getInventoryData();
		CheckList checkList = new CheckList(inventoryData.returnNumber());
	//	InventoryCheckPO po = new InventoryCheckPO(checkList.getItemsPO(), checkList.getToday(), checkList.getLot());
	//	TODO 库存盘点，盘点后是否要持久化对象？
	//	inventoryData.insert(po);
		InventoryCheckVO vo = new InventoryCheckVO(checkList.getItemsVO(), checkList.getToday(), checkList.getLot());
		return vo;
	}
	
	/**
	 * 最开始要创建单据的时候，确定单据类型
	 * @param type
	 * @author Zing
	 * @version Nov 29, 2014 4:34:53 PM
	 */
	public void buildBill(BillType type) {
		this.type = type;
		list = new BillList();
	}
	
	
	public ArrayList<InventoryBillVO> show(BillType type) {
		ArrayList<InventoryBillVO> VOs = new ArrayList<InventoryBillVO>();
		ArrayList<InventoryBillPO> POs = getInventoryData().find(type);
		for (int i = 0; i < POs.size(); i++) {
			InventoryBillPO po = POs.get(i);
			InventoryBillVO vo = poToVo(po);
			VOs.add(vo);
		}
		return VOs;
	}
	
	public InventoryBillVO poToVo(InventoryBillPO po) {
		String ID = po.getID();
		BillType billType = po.getBillType();
		ArrayList<CommodityItemVO> commodities = itemPOToVO(po.getCommodities());
		String remark = po.getRemark();
		BillState state = po.getState();
		InventoryBillVO vo = new InventoryBillVO(ID, billType, commodities, remark, state);
		return vo;
	}

	public void addCommodity(String ID, int number) {
		BillListItem item = new BillListItem(ID, number);
		list.addItem(item);
	}
	
	
	public ResultMessage submit(String remark){
		list.setRemark(remark);
		return 	getInventoryData().insert(getInventoryBill());
	}
	
	public ResultMessage save(String remark) {
		list.setRemark(remark);
		// 保存为草稿
		return null;
	}
	
	private InventoryBillPO getInventoryBill(){
		InventoryBillPO po = new InventoryBillPO(type, list.getCommodityPOs(), list.getRemark());
		return po;
	}
	
}
