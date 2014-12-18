package businesslogic.inventorybl;

import java.rmi.RemoteException;
import java.util.Date;

import businesslogic.common.DateOperate;
import businesslogic.inventorybl.info.PurchaseInfo_Inventory;
import businesslogic.inventorybl.info.SaleInfo_Inventory;
import businesslogic.purchasebl.PurchaseInfo;
import businesslogic.salebl.SaleInfo;

/**
 * 库存查看
 * 设定一个时间段，查看此时间段内的
 * 出/入库数量/金额，销售/进货的数量/金额（可以不显示销售/进货的数量/金额）。
 * 库存数量要有合计，这一点统一于普适需求。
 * @author Zing
 * @version Nov 28, 201412:27:57 AM
 */
public class ViewList {

	private String beginDate;

	private String endDate;

	/** 出库数量（也就是销售数量） */
	private int saleNumber;
	/** 入库数量（也就是进货数量） */
	private int purNumber;
	/** 出库金额（也就是销售金额） */
	private double saleMoney;
	/** 入库金额（也就是进货金额） */
	private double purMoney;

	private SaleInfo_Inventory saleInfo;
	private PurchaseInfo_Inventory purchaseInfo;

	public ViewList() {
	}

	public ViewList(String beginDate, String endDate) throws RemoteException {
		this.beginDate = beginDate;
		this.endDate = endDate;
		setDate();
	}

	private void setDate() throws RemoteException {	
		Date begin = DateOperate.changeBeginDate(beginDate);
		Date end = DateOperate.changeEndDate(endDate);
		this.saleInfo = new SaleInfo(begin, end);
		this.purchaseInfo = new PurchaseInfo(begin, end);
		setAllData();
	}
	
	private void setAllData() throws RemoteException {
		saleNumber = saleInfo.getNumber();
		purNumber = purchaseInfo.getNumber();
		saleMoney = saleInfo.getMoney();
		purMoney = purchaseInfo.getMoney();
	}

	public int getSaleNumber() throws RemoteException {
		return saleNumber;
	}

	public int getPurNumber() throws RemoteException {
		return purNumber;
	}

	public double getSaleMoney() throws RemoteException {
		return saleMoney;
	}

	public double getPurMoney() throws RemoteException {
		return purMoney;
	}
}
