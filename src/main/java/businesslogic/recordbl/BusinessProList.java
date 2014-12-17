package businesslogic.recordbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import businesslogic.accountbillbl.AccountBillInfo;
import businesslogic.cashbillbl.CashBillInfo;
import businesslogic.common.DateOperate;
import businesslogic.inventorybl.InventoryInfo;
import businesslogic.purchasebl.PurchaseInfo;
import businesslogic.recordbl.info.ValueObjectInfo_Record;
import businesslogic.salebl.SaleInfo;
import vo.ValueObject;
import dataenum.BillType;
import dataenum.Storage;

/**
 *  * 经营历程表
 * 查看一段时间里的所有单据，单据分为：
 * 1. 销售类单据（销售出货单，销售退货单）
 * 2. 进货类单据（进货单，进货退货单） 
 * 3. 财务类单据（付款单，收款单，现金费用单）
 * 4. 库存类单据（报溢单，报损单，赠送单）。
 * 筛选条件为：时间区间，单据类型，客户，业务员，仓库。
 * 显示出符合条件的单据后，可以对单据进行查看操作，但是不可修改和删除。
 * @author Zing
 * @version Nov 30, 2014 3:14:33 PM
 */
public class BusinessProList {
	
	private Date begin;
	private Date end;
	
	public BillType billType;
	public String clientName;
	public String salesman;
	public Storage storage;
	public ValueObjectInfo_Record<?> info;
	ArrayList<ValueObject> VOs;
	
	public BusinessProList(String beginDate, String endDate) {
		this.begin = DateOperate.changeBeginDate(beginDate);
		this.end = DateOperate.changeEndDate(endDate);
		this.VOs = new ArrayList<ValueObject>();
	}
	
	public void setInfo(BillType billType, String clientName, String salesman, Storage storage) {
		this.billType = billType;
		this.clientName = clientName;
		this.salesman = salesman;
		this.storage = storage;
	}

	public ArrayList<ValueObject> getBusinessPro() throws RemoteException{
		switch (billType) {
		case SALE:
		case SALEBACK:
			info = new SaleInfo(begin, end);
			break;
		case PURCHASE:
		case PURCHASEBACK:
			info = new PurchaseInfo(begin, end);
			break;
		case GIFT:
		case OVERFLOW:
		case LOSS:
			info = new InventoryInfo(begin, end);
			break;
		case PAY:
		case EXPENSE:
			info = new AccountBillInfo(begin, end);
			break;
		case CASH:
			info = new CashBillInfo(begin, end);
			break;
		default:
			break;
		}
		ArrayList<String> billIDs = info.getID(clientName, salesman, storage);
		for (String billID : billIDs) {
			VOs.add(info.find(billID));
		}
		return VOs;
	}
}
