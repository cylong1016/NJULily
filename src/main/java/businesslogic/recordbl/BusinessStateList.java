package businesslogic.recordbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.BillType;
import vo.BusinessStateVO;
import businesslogic.inventorybl.InventoryInfo;
import businesslogic.purchasebl.PurchaseInfo;
import businesslogic.recordbl.info.InventoryInfo_Record;
import businesslogic.recordbl.info.PurchaseInfo_Record;
import businesslogic.recordbl.info.SaleInfo_Record;
import businesslogic.salebl.SaleInfo;

/**
 * 查看经营情况表（统计显示一段时间内的经营收支状况和利润。
 * 经营收入显示为折让后，并显示出折让了多少。
 * 显示信息：
 * 	1. 收入类：销售收入、商品类收入（商品报溢收入 成本调价收入 代金券与实际收款差额收入）。
 * 收入类显示折让后总收入，并显示折让了多少。
 * 2. 支出类：销售成本、商品类支出（商品报损 商品赠出）。
 * 支出类显示总支出。
 * 3. 利润：折让后总收入-总支出。）
 * 各报表能够导出。

 * @author Zing
 * @version Nov 30, 2014 4:30:38 PM
 */

public class BusinessStateList {
	
	/** 商品类收入（折让后的总收入）*/
	private double totalIncome;
	/** 销售收入 */
	private double saleIncome;
	/** 商品报溢收入 */
	private double overflowIncome;
	/** 成本调价收入 */
	private double costIncome;
	/** 代金券与实际收款差额收入 */
	private double voucherIncome;
	/** 折让 */
	private double allowance;
	/** （也就是总支出）*/
	private double totalExpen;
	/** 销售成本*/
	private double saleCost;
	/** 商品报损*/
	private double lossExpen;
	/** 赠送支出*/
	private double giftExpen;
	/** 利润 */
	private double profit;	
	
	private ArrayList<String> IDs;
	
	SaleInfo_Record saleInfo;
	
	PurchaseInfo_Record purchaseInfo;
	
	InventoryInfo_Record inventoryInfo;
	ArrayList<String> saleIDs = new ArrayList<String>();
	ArrayList<String> purIDs = new ArrayList<String>();
	ArrayList<String> inventoryIDs = new ArrayList<String>();
	
	/**
	 * 得到时间区间的ID们，形式为yyyyMMdd
	 * @param IDs
	 */
	public BusinessStateList(ArrayList<String> IDs) {
		this.IDs = IDs;
		saleInfo = new SaleInfo();
		purchaseInfo = new PurchaseInfo();
		inventoryInfo = new InventoryInfo();
	}

	/**
	 * 得到最终的经营情况VO
	 * @return
	 * @author Zing
	 * @version Dec 4, 2014 8:23:53 PM
	 * @throws RemoteException 
	 */
	public BusinessStateVO getBusinessState() throws RemoteException {
		
		for (String ID : IDs) {
			getSaleIDs(ID);
			getPurchaseIDs(ID);
			getInventoryIDs(ID);
		}
		for (String ID : saleIDs) {
			accountSale(ID);
		}
		for (String ID : purIDs) {
			accountPur(ID);
		}
		for (String ID : inventoryIDs) {
			accountInventory(ID);
		}
		totalIncome = saleIncome + overflowIncome + costIncome + voucherIncome - allowance;
		totalExpen = saleCost + lossExpen + giftExpen;
		profit = totalIncome - totalExpen;
		BusinessStateVO vo = new BusinessStateVO(saleIncome, totalIncome, overflowIncome, costIncome, voucherIncome, allowance, saleCost, totalExpen, lossExpen, giftExpen, profit);
		return vo;
	}

	/* 以下三个方法是为了获得所有存在的销售单、销售退货单、进货单、进货退货单、赠送单、报损单、报溢单、报警单的ID */
	private void getSaleIDs(String ID) throws RemoteException {
		ArrayList<String> saleID = saleInfo.getID(ID, null, null, null);
		saleIDs.addAll(saleID);
	}
	
	private void getPurchaseIDs(String ID) throws RemoteException {
		ArrayList<String> purchaseID = purchaseInfo.getID(ID, null, null, null);
		purIDs.addAll(purchaseID);
	}
	
	private void getInventoryIDs(String ID) throws RemoteException {
		ArrayList<String> inventoryID = inventoryInfo.getID(ID, null, null, null);
		inventoryIDs.addAll(inventoryID);
	}
	/* 以上三个方法*/

	private void accountSale(String ID) throws RemoteException {
		allowance += saleInfo.getAllowance(ID);
		double beforePrice = saleInfo.getBeforePrice(ID);
		saleIncome += beforePrice;
		double voucher = saleInfo.getVoucher(ID);
		// TODO 成本调价QvQ
		if (beforePrice < voucher) {
			voucherIncome += (voucher - beforePrice);
		}
		
	}

	/**
	 * 对进货方面的数据进行计算
	 * @param iD
	 * @author Zing
	 * @version Dec 4, 2014 11:37:14 PM
	 * @throws RemoteException 
	 */
	private void accountPur(String ID) throws RemoteException {
		saleCost += purchaseInfo.getTotalPrice(ID);
	}
	
	/**
	 * 对库存进行计算
	 * @param ID
	 * @author Zing
	 * @version Dec 4, 2014 11:36:50 PM
	 * @throws RemoteException 
	 */
	private void accountInventory(String ID) throws RemoteException {
		BillType type = inventoryInfo.getType(ID);
		switch (type) {
		case GIFT:
			giftExpen += inventoryInfo.getTotalPrice(ID);
			break;
		case OVERFLOW:
			overflowIncome += inventoryInfo.getTotalPrice(ID);
			break;
		case LOSS:
			lossExpen += inventoryInfo.getTotalPrice(ID);
			break;
		default:
			break;
		}
	}
}
