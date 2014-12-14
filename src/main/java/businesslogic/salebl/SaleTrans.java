package businesslogic.salebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.SalesPO;
import vo.commodity.CommodityItemVO;
import vo.sale.SalesVO;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.Storage;
import businesslogic.common.ChangeCommodityItems;

public class SaleTrans {

	public ChangeCommodityItems changeItems;

	/**
	 * 将销售（销售退货）单的PO转化成VO
	 * @param po
	 * @return SalesVO
	 * @author cylong
	 * @version 2014年11月28日  下午9:12:11
	 * @throws RemoteException 
	 */
	public SalesVO poToVo(SalesPO po) throws RemoteException {
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
		ArrayList<CommodityItemVO> commodities = changeItems.itemPOToVO(po.getCommodities());
		SalesVO vo = new SalesVO(ID, clientID, client, storage, user, salesman, commodities, remark, beforePrice, allowance, voucher, afterPrice, type, state);
		return vo;
	}
}
