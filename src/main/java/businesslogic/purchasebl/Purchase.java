package businesslogic.purchasebl;

import java.util.ArrayList;

import message.ResultMessage;
import po.PurchasePO;
import server.data.purchasedata.PurchaseData;
import vo.PurchaseVO;
import vo.commodity.CommodityItemVO;
import blservice.purchaseblservice.PurInputInfo;
import businesslogic.clientbl.ClientInfo;
import businesslogic.common.ChangeCommodityItems;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.Storage;
import dataservice.purchasedataservice.PurchaseDataService;

public class Purchase {
	
	private PurchaseList list;
	
	private PurchasePO po;
	
	private String ID;
	
	private BillType type;
	
	ChangeCommodityItems changeItems;
	
	public Purchase(){
		this.list = new PurchaseList();
		changeItems = new ChangeCommodityItems();
	}
	
	public PurchaseDataService getPurData(){
//		try {
//			DataFactoryService factory = (DataFactoryService)Naming.lookup(RMI.URL);
//			PurchaseDataService purData = factory.getPurchaseData();
//			return purData;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
		// TODO 本地新建
		return new PurchaseData();
	}
	
	public ArrayList<PurchaseVO> show(BillType type) {
		ArrayList<PurchaseVO> VOs = new ArrayList<PurchaseVO>();
		ArrayList<PurchasePO> POs = getPurData().show();
		for (int i = 0; i < POs.size(); i++) {
			PurchaseVO vo = poToVO(POs.get(i));
			VOs.add(vo);
		}
		return VOs;
	}

	public String getID(BillType type) {
		this.type = type;
		PurchaseDataService purData = getPurData();
		this.ID = purData.getID();
		return ID;
		
	}

	public void addCommodities(CommodityItemVO itemVO) {
		PurchaseListItem item = new PurchaseListItem(itemVO.ID, itemVO.number, itemVO.price, itemVO.remark);
		list.add(item);
	}

	public ResultMessage submit(PurInputInfo info) {
		setInputInfo(info);
		po = buildPur();
		return getPurData().insert(po);
	}

	public ResultMessage save(PurInputInfo info) {
		setInputInfo(info);
		// TODO 保存为草稿
		return null;
	}

	private PurchasePO buildPur() {
		double sumPrice = list.getBeforePrice();
		businesslogic.purchasebl.ClientInfo_Purchase info = new ClientInfo();
		String clientName = info.getName(list.getClientID());
		Storage storage = list.getStorage();
		po = new PurchasePO(ID, list.getClientID(), clientName, "user", storage, list.getCommodities(), sumPrice, list.getRemark(), type);	
		return po;
	}
	
	private void setInputInfo(PurInputInfo info){
		list.setClientID(info.clientID);
		list.setStorage(info.storage);
		list.setRemark(info.remark);
	}

	public PurchaseVO poToVO(PurchasePO po){
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
