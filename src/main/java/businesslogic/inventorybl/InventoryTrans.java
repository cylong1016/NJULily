package businesslogic.inventorybl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CommodityItemPO;
import po.InventoryBillPO;
import vo.InventoryBillVO;
import vo.commodity.CommodityItemVO;
import businesslogic.common.ChangeCommodityItems;
import dataenum.BillState;
import dataenum.BillType;

public class InventoryTrans {

	static public InventoryBillPO VOtoPO(InventoryBillVO vo) {
		String ID = vo.ID;
		BillType billType = vo.billType;
		String remark = vo.remark;
		ArrayList<CommodityItemPO> commodities = ChangeCommodityItems.itemsVOtoPO(vo.commodities);
		InventoryBillPO po = new InventoryBillPO(ID, billType, commodities, remark);
		return po;
	}
	
	/**
	 * 单子的po到vo的转换
	 * @param po
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 6:11:52 PM
	 * @throws RemoteException 
	 */
	static public InventoryBillVO poToVo(InventoryBillPO po) throws RemoteException {
		String ID = po.getID();
		BillType billType = po.getBillType();
		ArrayList<CommodityItemVO> commodities = ChangeCommodityItems.itemPOToVO(po.getCommodities());
		String remark = po.getRemark();
		BillState state = po.getState();
		InventoryBillVO vo = new InventoryBillVO(ID, billType, commodities, remark, state);
		return vo;
	}
}
