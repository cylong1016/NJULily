package businesslogic.recordbl;

import java.util.ArrayList;

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
	public double totalIncome;
	/** 销售收入*/
	public double saleIncome;
	/** 商品报溢收入*/
	public double overflowIncome;
	/** 成本调价收入*/
	public double costIncome;
	/** 进货退货差价*/
	public double purAndBackIncome;
	/** 代金券与实际收款差额收入*/
	public double voucherIncome;
	/** 折让*/
	public double allowance;
	
	/** （也就是总支出）*/
	public double totalExpen;
	/** 销售成本*/
	public double saleCost;
	/** 商品报损*/
	public double lossExpen;
	/** 赠送支出*/
	public double giftExpen;
	/** 利润 */
	public double profit;	
	
	private ArrayList<String> IDs;
	
	SaleInfo_Record saleInfo;
	
	PurchaseInfo_Record purchaseInfo;
	
	InventoryInfo_Record inventoryInfo;
	
	
	public BusinessStateList(ArrayList<String> IDs) {
		this.IDs = IDs;
		saleInfo = new SaleInfo();
		purchaseInfo = new PurchaseInfo();
		inventoryInfo = new InventoryInfo();
	}

	public BusinessStateVO getBusinessState() {
		for (int i = 0; i < IDs.size(); i++) {
			getIncome(IDs.get(i));
			getExpen(IDs.get(i));
		}
		profit = totalIncome - totalExpen;
		return null;
	}


	private void getIncome(String ID) {
		saleIncome += saleInfo.getBeforePrice(ID);
		allowance += saleInfo.getAllowance(ID);
	}
	
	private void getExpen(String ID) {
		// TODO Auto-generated method stub
		
	}
	
}
