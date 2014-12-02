package businesslogic.purchasebl;

import java.util.ArrayList;

import message.ResultMessage;
import po.CommodityItemPO;
import po.PurchasePO;
import businesslogic.approvalbl.ValueObject_Approval;
import businesslogic.common.Info;
import businesslogic.inventorybl.info.PurchaseInfo_Inventory;
import businesslogic.recordbl.info.PurchaseInfo_Record;
import businesslogic.recordbl.info.ValueObjectInfo_Record;
import vo.PurchaseVO;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.Storage;
import dataservice.TableInfoService;
import dataservice.purchasedataservice.PurchaseDataService;

public class PurchaseInfo extends Info<PurchasePO> implements ValueObjectInfo_Record<PurchaseVO>, PurchaseInfo_Record, ValueObject_Approval<PurchaseVO>, PurchaseInfo_Inventory{
	
	private Purchase purchase;
	
	ArrayList<String> purIDs;
	ArrayList<String> backIDs;
	
	public PurchaseInfo() {
		purchase = new Purchase();
	}
	
	public PurchaseInfo(ArrayList<String> IDs) {
		purchase = new Purchase();
		this.purIDs = new ArrayList<String>();
		this.backIDs = new ArrayList<String>();
		for (String id : IDs) {
			purIDs.addAll(getID(id, null, null, null, BillType.PURCHASE));
			backIDs.addAll(getID(id, null, null, null, BillType.PURCHASEBACK));
		}
	}
	
	public TableInfoService<PurchasePO> getData() {
		return purchase.getPurData().getInfo();
	}
	
	private PurchaseDataService getPurchaseData() {
		return purchase.getPurData();
	}
	
	
	public ArrayList<String> getID(String ID, String clientName, String salesman, Storage storage) {
		ArrayList<String> IDs = new ArrayList<String>();
		IDs = getID(ID, clientName, salesman, storage, BillType.PURCHASE);
		IDs.addAll(getID(ID, clientName, salesman, storage, BillType.PURCHASEBACK));
		return IDs;
	}

	public PurchaseVO find(String ID) {
		return purchase.poToVO(getPurchaseData().find(ID));
	}

	
	public ArrayList<PurchaseVO> findApproval() {
		ArrayList<PurchasePO> POs = getPurchaseData().show();
		ArrayList<PurchasePO> approvalPO = new ArrayList<PurchasePO>();
		for (PurchasePO po : POs) {
			if (po.getState() == BillState.APPROVALING) {
				approvalPO.add(po);
			}
		}
		ArrayList<PurchaseVO> VOs = new ArrayList<PurchaseVO>();
		for (PurchasePO po : approvalPO) {
			PurchaseVO vo = purchase.poToVO(po);
			VOs.add(vo);
		}
		return VOs;
	}

	public ResultMessage update(PurchaseVO vo) {
		String ID = vo.ID;
		String client = vo.client;
		String user = vo.user;
		Storage storage = vo.storage;
		String remark = vo.remark;
		double beforePrice = vo.beforePrice;
		BillType type = vo.type;
		ArrayList<CommodityItemPO> commodities = purchase.itemsVOtoPO(vo.commodities);
		PurchasePO po = new PurchasePO(ID, client, user, storage, commodities, beforePrice, remark, type);
		return getPurchaseData().update(po);
	}

	
	public double getMoney() {
		if (purIDs.isEmpty() && backIDs.isEmpty()) {
			return 0;
		}
		double purMoney = 0;
		for (String id : purIDs) {
			purMoney += getBeforePrice(id);
		}
		for (String id : backIDs) {
			purMoney -= getBeforePrice(id);
		}
		return purMoney;
	}

	public int getNumber() {
		if (purIDs.isEmpty() && backIDs.isEmpty()) {
			return 0;
		}
		int purNumber = 0;
		for (String id : purIDs) {
			purNumber += getAllCommoditiesNumber(id);
		}
		for (String id : backIDs) {
			purNumber -= getAllCommoditiesNumber(id);
		}
		return purNumber;
	}
	
	/**
	 * 得到一个进货单中的所有商品的数量
	 * @param ID
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 5:15:27 PM
	 */
	private int getAllCommoditiesNumber(String ID) {
		ArrayList<CommodityItemPO> POs = getPurchaseData().find(ID).getCommodities();
		int number = 0;
		for (CommodityItemPO po : POs) {
			number += po.getNumber();
		}
		return number;
	}
	/**
	 * 根据ID查找特定进货单/进货退货单的总价
	 * @param ID
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 5:17:15 PM
	 */
	private double getBeforePrice(String ID) {
		return getPurchaseData().find(ID).getBeforePrice();
	}
}
