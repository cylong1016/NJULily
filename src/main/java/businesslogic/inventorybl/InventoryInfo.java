package businesslogic.inventorybl;

import java.util.ArrayList;

import message.ResultMessage;
import po.CommodityItemPO;
import po.InventoryBillPO;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.Storage;
import dataservice.TableInfoService;
import dataservice.inventorydataservice.InventoryDataService;
import vo.InventoryBillVO;
import vo.commodity.CommodityItemVO;
import businesslogic.approvalbl.info.InventoryInfo_Approval;
import businesslogic.approvalbl.info.ValueObject_Approval;
import businesslogic.commoditybl.CommodityInfo;
import businesslogic.common.Info;
import businesslogic.inventorybl.info.CommodityInfo_Inventory;
import businesslogic.promotionbl.info.InventoryInfo_Promotion;
import businesslogic.recordbl.info.InventoryInfo_Record;
import businesslogic.recordbl.info.ValueObjectInfo_Record;

public class InventoryInfo extends Info<InventoryBillPO> implements InventoryInfo_Promotion, ValueObjectInfo_Record<InventoryBillVO>, InventoryInfo_Record, ValueObject_Approval<InventoryBillVO>, InventoryInfo_Approval{

	private Inventory inventory;
	
	public InventoryInfo() {
		inventory = new Inventory();
	}
	
	public TableInfoService<InventoryBillPO> getData() {
		return inventory.getInventoryData().getInfo();
	}
	
	private InventoryDataService getInventoryData() {
		return inventory.getInventoryData();
	}
	
	public ArrayList<InventoryBillVO> getGifts() {
		InventoryShow inventoryShow = new InventoryShow();
		return inventoryShow.showGiftsPass();
	}

	/**
	 * 返回的是所有的符合条件的库存账单的ID
	 */
	public ArrayList<String> getID(String ID, String clientName, String salesman, Storage storage) {
		ArrayList<String> IDs = new ArrayList<String>();
		IDs = getID(ID, clientName, salesman, storage, BillType.GIFT);
		IDs.addAll(getID(ID, clientName, salesman, storage, BillType.OVERFLOW));
		IDs.addAll(getID(ID, clientName, salesman, storage, BillType.LOSS));
		IDs.addAll(getID(ID, clientName, salesman, storage, BillType.ALARM));
		return IDs;
	}

	/**
	 * 根据单据ID，返回一个VO
	 */
	public InventoryBillVO find(String ID) {
		InventoryBillVO vo = inventory.poToVo(getInventoryData().find(ID));
		return vo;
	}

	public ResultMessage update(InventoryBillVO vo) {
		String ID = vo.ID;
		BillType billType = vo.billType;
		String remark = vo.remark;
		ArrayList<CommodityItemPO> commodities = inventory.changeItems.itemsVOtoPO(vo.commodities);
		InventoryBillPO po = new InventoryBillPO(ID, billType, commodities, remark);
		return getInventoryData().update(po);
	}

	/**
	 * 通过审批后，更改相应的商品信息
	 */
	public void pass(InventoryBillVO vo) {
		InventoryBillPO po = getInventoryData().find(vo.ID);
		// 更新单据状态
		po.setState(BillState.SUCCESS);
		getInventoryData().update(po);
		// 更改商品数量
		ArrayList<CommodityItemPO> commodities = po.getCommodities();
		CommodityInfo_Inventory info = new CommodityInfo();
		for(CommodityItemPO commodity : commodities) {
			info.changeNumber(commodity.getID(), commodity.getNumber(), po.getBillType());
		}
	}

	/**
	 * 根据单据ID，返回单据类型
	 */
	public BillType getType(String ID) {
		return getInventoryData().find(ID).getBillType();
	}

	/**
	 * 根据单据ID，返回单据总额数
	 */
	public double getTotalPrice(String ID) {
		InventoryBillPO po = getInventoryData().find(ID);
		double totalPrice = 0;
		for (CommodityItemPO commodityPO : po.getCommodities()) {
			totalPrice += commodityPO.getTotal();
		}
		return totalPrice;
	}

	public InventoryBillVO addRed(InventoryBillVO vo, boolean isCopy) {
		InventoryBillVO redVO = vo;
		// 取负
		ArrayList<CommodityItemVO> commodities = redVO.commodities;
		for (int i = 0; i < commodities.size(); i++) {
			int number = -commodities.get(i).number;
			commodities.get(i).number = number;
		}
		redVO.commodities = commodities;
		// 先建立对应的PO
		InventoryBillPO redPO = new InventoryBillPO(redVO.ID, redVO.billType, inventory.changeItems.itemsVOtoPO(redVO.commodities), redVO.remark);
		if (!isCopy) {
			getInventoryData().insert(redPO);
			pass(redVO);
		}
		else {
			// TODO 保存为草稿
		}
		return null;
	}
	
	/**
	 * 返回需要审批的VO
	 */
	public ArrayList<InventoryBillVO> findApproval() {
		InventoryShow show = new InventoryShow();
		ArrayList<InventoryBillVO> VOs = show.showGiftsApproving();
		VOs.addAll(show.showOverFlowApproving());
		VOs.addAll(show.showLossApproving());
		VOs.addAll(show.showAlarmApproving());
		return VOs;
	}

	@Override
	public ArrayList<InventoryBillVO> showPass() {
		InventoryShow show = new InventoryShow();
		ArrayList<InventoryBillVO> VOs = show.showGiftsPass();
		VOs.addAll(show.showOverFlowPass());
		VOs.addAll(show.showLossPass());
		VOs.addAll(show.showAlarmPass());
		return VOs;
	}

	@Override
	public ArrayList<InventoryBillVO> showFailure() {
		InventoryShow show = new InventoryShow();
		ArrayList<InventoryBillVO> VOs = show.showGiftsFailure();
		VOs.addAll(show.showOverFlowFailure());
		VOs.addAll(show.showLossFailure());
		VOs.addAll(show.showAlarmFailure());
		return VOs;
	}
}
