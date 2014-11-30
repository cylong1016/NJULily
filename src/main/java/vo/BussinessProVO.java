package vo;

import java.util.ArrayList;

/**
 * 经营历程表
 * 查看一段时间里的所有单据，单据分为：
 * 1. 销售类单据（销售出货单，销售退货单）
 * 2. 进货类单据（进货单，进货退货单） 
 * 3. 财务类单据（付款单，收款单，现金费用单）
 * 4. 库存类单据（报溢单，报损单，赠送单）。
 * 筛选条件为：时间区间，单据类型，客户，业务员，仓库。
 * 显示出符合条件的单据后，可以对单据进行查看操作，但是不可修改和删除。
 * @author Zing
 * @version 2014年11月2日下午3:45:41
 */
public class BussinessProVO {
	
	public ArrayList<SalesVO> sale;
	
	public ArrayList<PurchaseVO> purchase;
	
	public ArrayList<AccountBillVO> accountBill;
	
	public ArrayList<CashBillVO> cashBill;
	
	public ArrayList<InventoryBillVO> inventoryBill;
	
	public BussinessProVO(ArrayList<SalesVO> sale, ArrayList<PurchaseVO> purchase, ArrayList<AccountBillVO> accountBill, 
			ArrayList<CashBillVO> cashBill, ArrayList<InventoryBillVO> inventoryBill) {
		this.sale = sale;
		this.purchase = purchase;
		this.accountBill = accountBill;
		this.cashBill = cashBill;
		this.inventoryBill = inventoryBill;
	}

}
