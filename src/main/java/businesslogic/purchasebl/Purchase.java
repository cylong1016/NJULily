package businesslogic.purchasebl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import po.PurchasePO;
import vo.PurchaseVO;
import vo.commodity.CommodityItemVO;
import blservice.purchaseblservice.PurInputInfo;
import businesslogic.clientbl.ClientInfo;
import businesslogic.purchasebl.info.ClientInfo_Purchase;
import businesslogic.userbl.UserInfo;
import config.RMIConfig;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.Storage;
import dataservice.purchasedataservice.PurchaseDataService;

public class Purchase {
	private  PurchaseDataService purchaseData;
	private PurchaseList list;
	private PurchasePO po;
	private String ID;
	private BillType type;
	
	public Purchase() {
		this.list = new PurchaseList();
		purchaseData = getPurData();
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
		this.ID = purchaseData.getPurchaseID();
		return ID;
	}

	public String getPurBackID() throws RemoteException {
		this.type = BillType.PURCHASEBACK;
		this.ID = purchaseData.getPurchaseBackID();
		return ID;
	}

	public void addCommodities(CommodityItemVO itemVO) throws RemoteException {
		PurchaseListItem item = new PurchaseListItem(itemVO.ID, itemVO.number, itemVO.price, itemVO.remark);
		list.add(item);
	}

	public PurchaseVO submit(PurInputInfo info) throws RemoteException {
		setInputInfo(info);
		po = buildPur();
		purchaseData.insert(po);
		return PurchaseTrans.poToVO(po);
	}

	public PurchaseVO save(PurInputInfo info) throws RemoteException {
		setInputInfo(info);
		po = buildPur();
		po.setState(BillState.DRAFT);
		purchaseData.insert(po);
		return PurchaseTrans.poToVO(po);
	}

	private PurchasePO buildPur() throws RemoteException {
		double sumPrice = list.getBeforePrice();
		ClientInfo_Purchase clientInfo = new ClientInfo();
		String clientName = clientInfo.getName(list.getClientID());
		Storage storage = list.getStorage();
		String username = UserInfo.getUsername();
		po = new PurchasePO(ID, list.getClientID(), clientName, username, storage, list.getCommodities(), sumPrice, list.getRemark(), type);
		return po;
	}

	private void setInputInfo(PurInputInfo info) {
		list.setClientID(info.clientID);
		list.setStorage(info.storage);
		list.setRemark(info.remark);
	}

}
