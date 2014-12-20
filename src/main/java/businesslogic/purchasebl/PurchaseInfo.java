package businesslogic.purchasebl;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import po.CommodityItemPO;
import po.PurchasePO;
import vo.PurchaseVO;
import businesslogic.approvalbl.info.ValueObject_Approval;
import businesslogic.common.DateOperate;
import businesslogic.common.Info;
import businesslogic.inventorybl.info.PurchaseInfo_Inventory;
import businesslogic.recordbl.info.PurchaseInfo_Record;
import businesslogic.recordbl.info.ValueObjectInfo_Record;
import config.RMIConfig;
import dataenum.BillType;
import dataenum.Storage;
import dataservice.TableInfoService;
import dataservice.purchasedataservice.PurchaseDataService;
import dataservice.purchasedataservice.PurchaseInfoService;
import dataservice.saledataservice.SaleInfoService;

public class PurchaseInfo extends Info<PurchasePO> implements ValueObjectInfo_Record<PurchaseVO>, PurchaseInfo_Record, ValueObject_Approval<PurchaseVO>, PurchaseInfo_Inventory{
	
	private Purchase purchase;
	private PurchaseDataService purchaseData;
	ArrayList<String> purIDs;
	ArrayList<String> backIDs;
	
	public PurchaseInfo() {
		purchase = new Purchase();
		this.purchaseData = purchase.getPurData();
	}
	
	public PurchaseInfo(Date begin, Date end) {
		purchase = new Purchase();
		this.purchaseData = purchase.getPurData();
		purIDs = new ArrayList<String>();
		backIDs = new ArrayList<String>();
		setIDsByDate(begin, end);	
	}
	
	private void setIDsByDate(Date beginDate, Date endDate){
		try {
			SaleInfoService saleInfo = (SaleInfoService)Naming.lookup(RMIConfig.PREFIX+SaleInfoService.NAME);
			ArrayList<String> IDs = saleInfo.getAllID(BillType.PURCHASE);
			purIDs.addAll(DateOperate.findFitDate(IDs, beginDate, endDate));
			ArrayList<String> bIDs = saleInfo.getAllID(BillType.PURCHASEBACK);
			backIDs.addAll(DateOperate.findFitDate(bIDs, beginDate, endDate));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public TableInfoService<PurchasePO> getData() {
		try {
			return (PurchaseInfoService)Naming.lookup(RMIConfig.PREFIX + PurchaseInfoService.NAME);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public ArrayList<String> getID(String clientName, String salesman, Storage storage) throws RemoteException {
		ArrayList<String> IDs = new ArrayList<String>();
		IDs = getID(purIDs, clientName, salesman, storage);
		IDs.addAll(getID(backIDs, clientName, salesman, storage));
		return IDs;
	}

	public PurchaseVO find(String ID) throws RemoteException {
		return PurchaseTrans.poToVO(purchaseData.find(ID));
	}
	
	public double getMoney() throws RemoteException {
		if (purIDs.isEmpty() && backIDs.isEmpty()) {
			return 0;
		}
		double purMoney = 0;
		for (String id : purIDs) {
			purMoney += getBeforePrice(id);
		}
		for (String id : backIDs) {
			purMoney -= getBeforePrice(id);
		}
		return purMoney;
	}

	public int getNumber() throws RemoteException {
		if (purIDs.isEmpty() && backIDs.isEmpty()) {
			return 0;
		}
		int purNumber = 0;
		for (String id : purIDs) {
			purNumber += getAllCommoditiesNumber(id);
		}
		for (String id : backIDs) {
			purNumber -= getAllCommoditiesNumber(id);
		}
		return purNumber;
	}
	
	/**
	 * 得到一个进货单中的所有商品的数量
	 * @param ID
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 5:15:27 PM
	 * @throws RemoteException 
	 */
	private int getAllCommoditiesNumber(String ID) throws RemoteException {
		ArrayList<CommodityItemPO> POs = purchaseData.find(ID).getCommodities();
		int number = 0;
		for (CommodityItemPO po : POs) {
			number += po.getNumber();
		}
		return number;
	}
	/**
	 * 根据ID查找特定进货单/进货退货单的总价
	 * @param ID
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 5:17:15 PM
	 * @throws RemoteException 
	 */
	private double getBeforePrice(String ID) throws RemoteException {
		return purchaseData.find(ID).getBeforePrice();
	}


	public double getTotalPrice(String ID) throws RemoteException {
		PurchasePO po = purchaseData.find(ID);
		switch (purchaseData.find(ID).getType()) {
		case PURCHASE:
			return po.getBeforePrice();
		case PURCHASEBACK:
			return -po.getBeforePrice();
		default:
			break;
		}
		return 0;
	}
	
	public ArrayList<PurchaseVO> findApproval() throws RemoteException {
		PurchaseShow show = new PurchaseShow();
		ArrayList<PurchaseVO> VOs = show.showPurchaseApproving();
		VOs.addAll(show.showPurchaseBackApproving());
		return VOs;
	}

	@Override
	public ArrayList<PurchaseVO> showPass() throws RemoteException {
		PurchaseShow show = new PurchaseShow();
		ArrayList<PurchaseVO> VOs = show.showPurchasePass();
		VOs.addAll(show.showPurchaseBackPass());
		return VOs;
	}

	@Override
	public ArrayList<PurchaseVO> showFailure() throws RemoteException {
		PurchaseShow show = new PurchaseShow();
		ArrayList<PurchaseVO> VOs = show.showPurchaseFailure();
		VOs.addAll(show.showPurchaseBackFailure());
		return VOs;
	}
}
