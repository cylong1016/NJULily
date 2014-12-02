package businesslogic.purchasebl;

import java.util.ArrayList;

import message.ResultMessage;
import po.CommodityItemPO;
import po.PurchasePO;
import businesslogic.approvalbl.ValueObject_Approval;
import businesslogic.common.Info;
import businesslogic.recordbl.info.PurchaseInfo_Record;
import businesslogic.recordbl.info.ValueObjectInfo_Record;
import vo.PurchaseVO;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.Storage;
import dataservice.TableInfoService;
import dataservice.purchasedataservice.PurchaseDataService;

public class PurchaseInfo extends Info<PurchasePO> implements ValueObjectInfo_Record<PurchaseVO>, PurchaseInfo_Record, ValueObject_Approval<PurchaseVO>{
	
	private Purchase purchase;
	
	public PurchaseInfo() {
		purchase = new Purchase();
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
}
