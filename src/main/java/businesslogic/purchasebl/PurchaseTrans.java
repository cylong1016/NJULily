package businesslogic.purchasebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CommodityItemPO;
import po.PurchasePO;
import vo.PurchaseVO;
import vo.commodity.CommodityItemVO;
import businesslogic.common.ChangeCommodityItems;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.Storage;

public class PurchaseTrans {

	static public PurchaseVO poToVO(PurchasePO po) throws RemoteException {
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
	
	static public PurchasePO VOtoPO(PurchaseVO vo) {
		String ID = vo.ID;
		String clientID = vo.clientID;
		String client = vo.client;
		String user = vo.user;
		Storage storage = vo.storage;
		String remark = vo.remark;
		double beforePrice = vo.beforePrice;
		BillType type = vo.type;
		ArrayList<CommodityItemPO> commodities = ChangeCommodityItems.itemsVOtoPO(vo.commodities);
		PurchasePO po = new PurchasePO(ID, clientID, client, user, storage, commodities, beforePrice, remark, type);
		return po;
	}
}
