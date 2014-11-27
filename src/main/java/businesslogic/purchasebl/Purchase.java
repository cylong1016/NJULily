package businesslogic.purchasebl;

import java.rmi.Naming;
import java.util.ArrayList;

import po.PurchasePO;
import message.ResultMessage;
import vo.PurchaseVO;
import dataenum.BillType;
import dataenum.Storage;
import dataservice.DataFactoryService;
import dataservice.PurchaseDataService;

public class Purchase {
	
	private PurchaseList list;
	
	private PurchasePO po;
	
	public Purchase(){
		list = new PurchaseList();
	}

	public void addCommodities(String name, int num, double price,
			String remark) {
		PurchaseListItem item = new PurchaseListItem(name, num, price, remark);
		list.add(item);
	}

	public ResultMessage addPur(String ID, String client, String user,
			Storage storage, double sumPrice, String remark) {
		try {
			DataFactoryService factory = (DataFactoryService)Naming.lookup("rmi://127.0.0.1:8888/factory");
			PurchaseDataService purData = (PurchaseDataService)factory.getPurchaseData();
			double beforePrice = list.getBeforePrice();
			po = new PurchasePO(ID, client, user, storage, list.getCommodities(), beforePrice, BillType.PURCHASE);
			purData.insert(po);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return ResultMessage.SUCCESS;
	}

	public ResultMessage addPurBack(String ID, String client, String user,
			Storage storage, double sumPrice, String remark) {
		try {
			DataFactoryService factory = (DataFactoryService)Naming.lookup("rmi://127.0.0.1:8888/factory");
			PurchaseDataService purData = (PurchaseDataService)factory.getPurchaseData();
			double beforePrice = list.getBeforePrice();
			po = new PurchasePO(ID, client, user, storage, list.getCommodities(), beforePrice, BillType.PURCHASEBACK);
			purData.insert(po);
		} catch (Exception e) {
			e.printStackTrace();
		} 		
		return ResultMessage.SUCCESS;
	}

	public ResultMessage submit() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<PurchaseVO> show() {
		// TODO Auto-generated method stub
		return null;
	}

}
