package businesslogic.recordbl;

import java.util.ArrayList;

import vo.BusinessStateVO;
import businesslogic.inventorybl.Inventory;
import businesslogic.purchasebl.Purchase;
import businesslogic.recordbl.info.InventoryInfo_Record;
import businesslogic.recordbl.info.PurchaseInfo_Record;
import businesslogic.recordbl.info.SaleInfo_Record;
import businesslogic.salebl.Sale;

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
	SaleInfo_Record saleInfo;
	
	PurchaseInfo_Record purchaseInfo;
	
	InventoryInfo_Record inventoryInfo;
	
	public BusinessStateList() {
		saleInfo = new Sale();
		purchaseInfo = new Purchase();
		inventoryInfo = new Inventory();
	}

	public BusinessStateVO getBusinessState(ArrayList<String> ID) {
		saleInfo.get
		return null;
	}
	
	
}
