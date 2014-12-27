package businesslogic.purchasebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.BillState;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataservice.purchasedataservice.PurchaseDataService;
import businesslogic.approvalbl.info.PurchaseInfo_Approval;
import businesslogic.clientbl.ClientInfo;
import businesslogic.commoditybl.CommodityInfo;
import businesslogic.purchasebl.info.ClientInfo_Purchase;
import businesslogic.purchasebl.info.CommodityInfo_Purchase;
import po.CommodityItemPO;
import po.PurchasePO;
import vo.PurchaseVO;
import vo.commodity.CommodityItemVO;

public class PurchaseOperate implements PurchaseInfo_Approval{
	
	private Purchase purchase;
	private PurchaseDataService purchaseData;
	
	public PurchaseOperate() {
		purchase = new Purchase();
		purchaseData = purchase.getPurData();
	}
	
	public ResultMessage update(PurchaseVO vo) throws RemoteException {
		PurchasePO po = PurchaseTrans.VOtoPO(vo);
		return purchaseData.update(po);
	}
	
	public ResultMessage pass(PurchaseVO vo) throws RemoteException {
		PurchasePO po = purchaseData.find(vo.ID);
		// 更改商品的数据
		CommodityInfo_Purchase commodityInfo = new CommodityInfo();
		ArrayList<CommodityItemPO> commodities = po.getCommodities();
		// 如果商品总数不够的话 
		if (po.getType() == BillType.PURCHASEBACK) {
			for (CommodityItemPO commodity : commodities) {
				if (!commodityInfo.checkNumber(commodity.getID(), commodity.getNumber())) {
					po.setState(BillState.FAILURE);
					purchaseData.update(po);
					return ResultMessage.COMMODITY_LACK;
				}
			}
		}
		for (CommodityItemPO commodity : commodities) {
			commodityInfo.changeCommodityInfo(commodity.getID(), commodity.getNumber(), commodity.getPrice(), po.getType());
		}
		// 更改客户的应付金额
		ClientInfo_Purchase clientInfo = new ClientInfo();
		if (po.getType() == BillType.PURCHASE) {
			clientInfo.changePayable(po.getClientID(), po.getBeforePrice());
		} else {
			clientInfo.changePayable(po.getClientID(), -po.getBeforePrice());
		}
		// 更新该进货／进货退货单状态
		po.setState(BillState.SUCCESS);
		purchaseData.update(po);
		return ResultMessage.SUCCESS;
	}


	public PurchaseVO addRed(PurchaseVO vo, boolean isCopy) throws RemoteException {
		PurchaseVO redVO = vo;
		// 取负
		ArrayList<CommodityItemVO> commodities = redVO.commodities;
		for (int i = 0; i < commodities.size(); i++) {
			int number = -commodities.get(i).number;
			commodities.get(i).number = number;
		}
		redVO.commodities = commodities;
		// 先建立对应的PO
		PurchasePO redPO = PurchaseTrans.VOtoPO(redVO);
		if (!isCopy) {
			purchaseData.insert(redPO);
			pass(redVO);
		}
		else {
			// TODO 保存为草稿 
		}
		return null;
	}

	@Override
	public void noPass(PurchaseVO vo) throws RemoteException {
		PurchasePO po = PurchaseTrans.VOtoPO(vo);
		po.setState(BillState.FAILURE);
		purchaseData.insert(po);
	}

}
