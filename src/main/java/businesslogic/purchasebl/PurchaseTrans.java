package businesslogic.purchasebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

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
}
