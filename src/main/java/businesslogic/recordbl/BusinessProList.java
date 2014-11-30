package businesslogic.recordbl;

import java.util.ArrayList;

import businesslogic.accountbillbl.AccountBill;
import businesslogic.cashbillbl.CashBill;
import businesslogic.inventorybl.Inventory;
import businesslogic.purchasebl.Purchase;
import businesslogic.recordbl.info.ValueObjectInfo_Record;
import businesslogic.salebl.Sale;
import vo.SaleDetailVO;
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
	
	public BillType billType;
	
	public String clientName;
	
	public String salesman;
	
	public Storage storage;
	
	public ValueObjectInfo_Record info;
		
	public BusinessProList(BillType billType, String clientName, String salesman, Storage storage) {
		this.billType = billType;
		this.clientName = clientName;
		this.salesman = salesman;
		this.storage = storage;
	}
	
	// TODO 这里是不是可以用抽象工厂？
	public ArrayList<ValueObject> getBusinessPro(ArrayList<String> IDs){
		switch (billType) {
		case SALE:
		case SALEBACK:
			info = new Sale();
			break;
		case PURCHASE:
		case PURCHASEBACK:
			info = new Purchase();
			break;
		case GIFT:
		case OVERFLOW:
		case LOSS:
			info = new Inventory();
			break;
		case PAY:
		case EXPENSE:
			info = new AccountBill();
			break;
		case CASH:
			info = new CashBill();
			break;
		default:
			break;
		}
		ArrayList<ValueObject> VOs = new ArrayList<ValueObject>();
		for (int i = 0; i < IDs.size(); i++) {
			String ID = info.getID(ID, clientName, salesman, storage)
		}
		return VOs;
		return null;
	}

	
	
	
	

}
