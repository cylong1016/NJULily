package businesslogic.purchasebl;

import java.util.ArrayList;

import po.PurchasePO;
import po.SalesPO;
import server.data.purchasedata.PurchaseData;
import businesslogic.approvalbl.ValueObject_Approval;
import businesslogic.common.Info;
import businesslogic.recordbl.info.PurchaseInfo_Record;
import businesslogic.recordbl.info.ValueObjectInfo_Record;
import vo.PurchaseVO;
import vo.SalesVO;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.Storage;
import dataservice.purchasedataservice.PurchaseDataService;

public class PurchaseInfo extends Info<PurchaseDataService> implements ValueObjectInfo_Record<PurchaseVO>, PurchaseInfo_Record, ValueObject_Approval<PurchaseVO>{
	
	private Purchase purchase;
	
	public PurchaseInfo() {
		purchase = new Purchase();
	}
	
	public PurchaseDataService getData() {
		return purchase.getPurData();
	}
	
	
	public ArrayList<String> getID(String ID, String clientName, String salesman, Storage storage) {
		ArrayList<String> IDs = new ArrayList<String>();
		IDs = getID(ID, clientName, salesman, storage, BillType.PURCHASE);
		IDs.addAll(getID(ID, clientName, salesman, storage, BillType.PURCHASEBACK));
		return IDs;
	}

	public PurchaseVO find(String ID) {
		return purchase.poToVO(getData().find(ID));
	}

	
	public ArrayList<PurchaseVO> findApproval() {
		ArrayList<PurchasePO> POs = getData().show();
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
}
