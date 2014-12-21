package businesslogic.salebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CommodityItemPO;
import po.SalesPO;
import vo.commodity.CommodityItemVO;
import vo.sale.SalesVO;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.Storage;
import businesslogic.common.ChangeCommodityItems;

public class SaleTrans {

	/**
	 * 将销售（销售退货）单的PO转化成VO
	 * @param po
	 * @return SalesVO
	 * @author cylong
	 * @version 2014年11月28日 下午9:12:11
	 * @throws RemoteException
	 */
	public static SalesVO poToVo(SalesPO po) throws RemoteException {
		String ID = po.getID();
		String clientID = po.getClientID();
		String client = po.getClient();
		Storage storage = po.getStorage();
		String salesman = po.getSalesman();
		String user = po.getUser();
		String remark = po.getRemark();
		double beforePrice = po.getBeforePrice();
		double allowance = po.getAllowance();
		double voucher = po.getVoucher();
		double afterPrice = po.getAfterPrice();
		BillType type = po.getType();
		BillState state = po.getState();
		ArrayList<CommodityItemVO> commodities = ChangeCommodityItems.itemPOToVO(po.getCommodities());
		SalesVO vo = new SalesVO(ID, clientID, client, storage, user, salesman, commodities, remark, beforePrice, allowance, voucher, afterPrice, type, state);
		return vo;
	}
	
public static SalesPO VOtoPO(SalesVO vo) {
	String ID = vo.ID;
	String clientID = vo.clientID;
	String client = vo.client;
	String salesman = vo.salesman;
	String user = vo.user;
	Storage storage = vo.storage;
	double beforePrice = vo.beforePrice;
	double allowance = vo.allowance;
	double voucher = vo.voucher;
	String remark = vo.remark;
	double afterPrice = vo.afterPrice;
	BillType type = vo.type;
	ArrayList<CommodityItemPO> commodities = ChangeCommodityItems.itemsVOtoPO(vo.commodities);
	SalesPO po = new SalesPO(ID, clientID, client, salesman, user, storage, commodities, beforePrice, allowance, voucher, remark, afterPrice, type);
	return po;
	}
}
