package businesslogic.purchasebl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.PurchasePO;
import vo.PurchaseVO;
import vo.commodity.CommodityItemVO;
import blservice.purchaseblservice.PurInputInfo;
import businesslogic.clientbl.ClientInfo;
import businesslogic.common.ChangeCommodityItems;
import businesslogic.purchasebl.info.ClientInfo_Purchase;
import config.RMIConfig;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.Storage;
import dataservice.purchasedataservice.PurchaseDataService;

public class Purchase {

	private PurchaseList list;

	private PurchasePO po;

	private String ID;

	private BillType type;

	public Purchase() {
		this.list = new PurchaseList();
	}

	public PurchaseDataService getPurData() {
		try {
			return (PurchaseDataService)Naming.lookup(RMIConfig.PREFIX + PurchaseDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getPurchaseID() throws RemoteException {
		this.type = BillType.PURCHASE;
		PurchaseDataService purData = getPurData();
		this.ID = purData.getPurchaseID();
		return ID;
	}

	public String getPurBackID() throws RemoteException {
		this.type = BillType.PURCHASEBACK;
		PurchaseDataService purData = getPurData();
		this.ID = purData.getPurchaseBackID();
		return ID;
	}

	public void addCommodities(CommodityItemVO itemVO) throws RemoteException {
		PurchaseListItem item = new PurchaseListItem(itemVO.ID, itemVO.number, itemVO.price, itemVO.remark);
		list.add(item);
	}

	public PurchaseVO submit(PurInputInfo info) throws RemoteException {
		setInputInfo(info);
		po = buildPur();
		getPurData().insert(po);
		return poToVO(po);
	}

	public PurchaseVO save(PurInputInfo info) throws RemoteException {
		setInputInfo(info);
		po = buildPur();
		// TODO 保存为草稿
		return poToVO(po);
	}

	private PurchasePO buildPur() throws RemoteException {
		double sumPrice = list.getBeforePrice();
		ClientInfo_Purchase info = new ClientInfo();
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

	public PurchaseVO poToVO(PurchasePO po) throws RemoteException {
		String ID = po.getID();
		String clientID = po.getClientID();
		String client = po.getClient();
		String user = po.getUser();
		Storage storage = po.getStorage();
		ArrayList<CommodityItemVO> commodities = ChangeCommodityItems.itemPOToVO(po.getCommodities());
		double sumPrice = po.getBeforePrice();
		BillType type = po.getType();
		BillState state = po.getState();
		PurchaseVO vo = new PurchaseVO(type, ID, clientID, client, user, storage, commodities, sumPrice, state);
		return vo;

	}

}
