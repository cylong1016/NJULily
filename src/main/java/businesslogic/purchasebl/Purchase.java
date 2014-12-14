package businesslogic.purchasebl;

import java.util.ArrayList;

import po.PurchasePO;
import server.data.purchasedata.PurchaseData;
import vo.PurchaseVO;
import vo.commodity.CommodityItemVO;
import blservice.purchaseblservice.PurInputInfo;
import blservice.purchaseblservice.PurchaseBLService;
import businesslogic.clientbl.ClientInfo;
import businesslogic.common.ChangeCommodityItems;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.Storage;
import dataservice.purchasedataservice.PurchaseDataService;

public class Purchase implements PurchaseBLService {

	private PurchaseList list;

	private PurchasePO po;

	private String ID;

	private BillType type;

	ChangeCommodityItems changeItems;

	public Purchase() {
		this.list = new PurchaseList();
		changeItems = new ChangeCommodityItems();
	}

	public PurchaseDataService getPurData() {
//		try {
//			DataFactoryService factory = (DataFactoryService)Naming.lookup(RMI.URL);
//			PurchaseDataService purData = factory.getPurchaseData();
//			return purData;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
		return new PurchaseData();
	}


	public String getPurchaseID() {
		this.type = BillType.PURCHASE;
		PurchaseDataService purData = getPurData();
		this.ID = purData.getPurchaseID();
		return ID;
	}
	
	public String  getPurBackID() {
		this.type = BillType.PURCHASEBACK;
		PurchaseDataService purData = getPurData();
		this.ID = purData.getPurchaseBackID();
		return ID;
	}

	public void addCommodities(CommodityItemVO itemVO) {
		PurchaseListItem item = new PurchaseListItem(itemVO.ID, itemVO.number, itemVO.price, itemVO.remark);
		list.add(item);
	}

	public PurchaseVO submit(PurInputInfo info) {
		setInputInfo(info);
		po = buildPur();
		getPurData().insert(po);
		return poToVO(po);
	}

	public PurchaseVO save(PurInputInfo info) {
		setInputInfo(info);
		po = buildPur();
		// TODO 保存为草稿
		return poToVO(po);
	}

	private PurchasePO buildPur() {
		double sumPrice = list.getBeforePrice();
		businesslogic.purchasebl.info.ClientInfo_Purchase info = new ClientInfo();
		String clientName = info.getName(list.getClientID());
		Storage storage = list.getStorage();
		po = new PurchasePO(ID, list.getClientID(), clientName, "user", storage, list.getCommodities(), sumPrice, list.getRemark(), type);
		return po;
	}

	private void setInputInfo(PurInputInfo info) {
		list.setClientID(info.clientID);
		list.setStorage(info.storage);
		list.setRemark(info.remark);
	}

	public PurchaseVO poToVO(PurchasePO po) {
		String ID = po.getID();
		String clientID = po.getClientID();
		String client = po.getClient();
		String user = po.getUser();
		Storage storage = po.getStorage();
		ArrayList<CommodityItemVO> commodities = changeItems.itemPOToVO(po.getCommodities());
		double sumPrice = po.getBeforePrice();
		BillType type = po.getType();
		BillState state = po.getState();
		PurchaseVO vo = new PurchaseVO(type, ID, clientID, client, user, storage, commodities, sumPrice, state);
		return vo;

	}

}
