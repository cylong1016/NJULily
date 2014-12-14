package businesslogic.inventorybl;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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

	private ArrayList<String> IDs;
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
		this.IDs = getID();
		this.saleInfo = new SaleInfo(IDs);
		this.purchaseInfo = new PurchaseInfo(IDs);
	}

	public int getSaleNumber() throws RemoteException {
		saleNumber = saleInfo.getNumber();
		return saleNumber;
	}

	public int getPurNumber() throws RemoteException {
		purNumber = purchaseInfo.getNumber();
		return purNumber;
	}

	public double getSaleMoney() throws RemoteException {
		saleMoney = saleInfo.getMoney();
		return saleMoney;
	}

	public double getPurMoney() throws RemoteException {
		purMoney = purchaseInfo.getMoney();
		return purMoney;
	}

	/**
	 * 得到所有的日期区间内的ID
	 * @return
	 * @author Zing
	 * @version Nov 30, 2014 1:50:47 PM
	 */
	private ArrayList<String> getID() {
		ArrayList<String> IDs = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			Date begin = sdf.parse(beginDate);
			Date end = sdf.parse(endDate);
			double between = (end.getTime() - begin.getTime()) / 1000;
			double day = between / 24 / 3600;
			for(int i = 0; i < day; i++) {
				Calendar cd = Calendar.getInstance();
				cd.setTime(sdf.parse(beginDate));
				cd.add(Calendar.DATE, i);
				String ID = sdf.format(cd.getTime());
				IDs.add(ID);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return IDs;
	}

}
