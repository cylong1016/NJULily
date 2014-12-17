package businesslogic.recordbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.AccountBillVO;
import vo.BusinessStateVO;
import vo.CashBillVO;
import vo.InventoryBillVO;
import vo.PurchaseVO;
import vo.SaleDetailVO;
import vo.ValueObject;
import vo.sale.SalesVO;
import blservice.recordblservice.BusinessStateInputInfo;
import blservice.recordblservice.SaleDetailInputInfo;
import dataenum.BillType;

public class Record {
	
	SaleDetailList saleDetailList;
	BusinessProList businessProList;
	BusinessStateList businessStateList;
	
	public Record() {
	}
	
	/**
	 * 得到销售明细表
	 * @author Zing
	 * @version Nov 30, 2014 2:21:46 PM
	 * @throws RemoteException 
	 */
	public ArrayList<SaleDetailVO> saleDetail(SaleDetailInputInfo info) throws RemoteException {
		saleDetailList = new SaleDetailList(info.beginDate, info.endDate);
		saleDetailList.setInfo(info.commodityName, info.clientName, info.salesman, info.storage);
		return saleDetailList.getSaleDetail();
	}

	/**
	 * 根据时间区间、单据类型、客户名、业务员名、仓库，查找相应的经营历程表
	 * @param info
	 * @return 单据列表
	 * @author Zing
	 * @version Dec 4, 2014 8:21:03 PM
	 * @throws RemoteException 
	 */
	public ArrayList<ValueObject> bussinessPro(BusinessStateInputInfo info) throws RemoteException {
		businessProList = new BusinessProList(info.beginDate, info.endDate);
		businessProList.setInfo(info.billType, info.clientName, info.salesman, info.storage);
		return businessProList.getBusinessPro();
	}

	/**
	 * 红冲（新建一张相应的单据，只是数据取负，相当于删除）
	 * @param valueRecord
	 * @return
	 * @author Zing
	 * @version Dec 4, 2014 8:21:06 PM
	 * @throws RemoteException 
	 */
	public ValueObject red(ValueObject vo, BillType type) throws RemoteException {
		boolean  isCopy = false;
		return buildRed(vo, type, isCopy);
	}

	/**
	 * 红冲并复制（新建一张相应的单据，数据取负，但是只是作为草稿，可以进行修改）
	 * @param valueRecord
	 * @return
	 * @author Zing
	 * @version Dec 4, 2014 8:21:09 PM
	 * @throws RemoteException 
	 */
	public ValueObject copyRed(ValueObject vo, BillType type) throws RemoteException {
		boolean isCopy = true;
		return buildRed(vo, type, isCopy);
	}

	/**
	 * 根据时间区间查看经营情况表
	 * @param info
	 * @return
	 * @author Zing
	 * @version Dec 4, 2014 8:21:12 PM
	 * @throws RemoteException 
	 */
	public BusinessStateVO businessState(String beginDate, String endDate) throws RemoteException {	
		businessStateList = new BusinessStateList(beginDate, endDate);
		return businessStateList.getBusinessState();
	}
	
	private ValueObject buildRed(ValueObject vo, BillType type, boolean isCopy) throws RemoteException {
		Red red = new Red(isCopy);
		switch (type) {
		case SALE:
		case SALEBACK:
			return red.addRed((SalesVO)vo);
		case PURCHASE:
		case PURCHASEBACK:
			return red.addRed((PurchaseVO)vo);
		case GIFT:
		case OVERFLOW:
		case LOSS:
			return red.addRed((InventoryBillVO)vo);
		case PAY:
		case EXPENSE:
			return red.addRed((AccountBillVO)vo);
		case CASH:
			return red.addRed((CashBillVO)vo);
		default:
			break;
		}
		return null;
	}
}
