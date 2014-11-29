package businesslogic.purchasebl;

import java.rmi.Naming;
import java.util.ArrayList;

import config.RMI;
import blservice.purchaseblservice.PurInputInfo;
import businesslogic.accountbillbl.ClientInfo;
import businesslogic.clientbl.Client;
import businesslogic.commoditybl.Commodity;
import businesslogic.salebl.CommodityInfo_Sale;
import po.CommodityItemPO;
import po.CommodityPO;
import po.PurchasePO;
import message.ResultMessage;
import vo.CommodityItemVO;
import vo.PurchaseVO;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.Storage;
import dataservice.DataFactoryService;
import dataservice.PurchaseDataService;

public class Purchase {
	
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
	
	public ArrayList<PurchaseVO> show() {
		PurchaseDataService purchaseData = getPurData();
		// TODO 等着getAllBill的方法
		return null;
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
		businesslogic.purchasebl.ClientInfo info = new Client();
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
		PurchaseVO vo = new PurchaseVO(ID, client, user, storage, commodities, sumPrice, state);
		return vo;
		
	}
	
	private ArrayList<CommodityItemVO> itemPOToVO(ArrayList<CommodityItemPO> itemsPO){
		ArrayList<CommodityItemVO> itemsVO = new ArrayList<CommodityItemVO>();
		for(int i = 0; i < itemsPO.size(); i++) {
			CommodityItemPO po = itemsPO.get(i);
			String ID = po.getID();
			int number = po.getNumber();
			double price = po.getPrice();
			String remark = po.getRemark();
			CommodityInfo_Sale info = new Commodity();
			String name = info.getName(ID);
			String type = info.getType(ID);
			CommodityItemVO vo = new CommodityItemVO(ID, number, price, remark, name, type);
			itemsVO.add(vo);
		}
		return itemsVO;
	}


}
