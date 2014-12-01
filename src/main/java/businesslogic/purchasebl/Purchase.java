package businesslogic.purchasebl;

import java.rmi.Naming;
import java.util.ArrayList;

import config.RMI;
import blservice.purchaseblservice.PurInputInfo;
import businesslogic.clientbl.Client;
import businesslogic.recordbl.info.PurchaseInfo_Record;
import businesslogic.recordbl.info.ValueObjectInfo_Record;
import businesslogic.salebl.POToVO;
import po.PurchasePO;
import message.ResultMessage;
import vo.CommodityItemVO;
import vo.PurchaseVO;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.Storage;
import dataservice.PurchaseDataService;
import dataservice.commondata.DataFactoryService;

public class Purchase extends POToVO implements ValueObjectInfo_Record<PurchaseVO>, PurchaseInfo_Record{
	
	private PurchaseList list;
	
	private PurchasePO po;
	
	private String ID;
	
	private BillType type;
	
	public Purchase(){
		this.list = new PurchaseList();
	}
	
	public PurchaseDataService getPurData(){
		try {
			DataFactoryService factory = (DataFactoryService)Naming.lookup(RMI.URL);
			PurchaseDataService purData = (PurchaseDataService)factory.getPurchaseData();
			return purData;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
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
		businesslogic.purchasebl.ClientInfo_Purchase info = new Client();
		String clientName = info.getName(list.getClientID());
		Storage storage = list.getStorage();
		po = new PurchasePO(ID, clientName, "user", storage, list.getCommodities(), sumPrice, type);	
		return po;
	}
	
	private void setInputInfo(PurInputInfo info){
		list.setClientID(info.clientID);
		list.setStorage(info.storage);
		list.setRemark(info.remark);
	}

	private PurchaseVO poToVO(PurchasePO po){
		String ID = po.getID();
		String client = po.getClient();
		String user = po.getUser();
		Storage storage = po.getStorage();
		ArrayList<CommodityItemVO> commodities = itemPOToVO(po.getCommodities());
		double sumPrice = po.getSumPrice();
		BillType type = po.getType();
		BillState state = po.getState();
		PurchaseVO vo = new PurchaseVO(type, ID, client, user, storage, commodities, sumPrice, state);
		return vo;
		
	}

	public String getID(String ID, String clientName, String salesman,
			Storage storage) {
		return null;
	}

}
