package businesslogic.salebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.approvalbl.info.SaleInfo_Approval;
import businesslogic.clientbl.ClientInfo;
import businesslogic.commoditybl.CommodityInfo;
import businesslogic.salebl.info.ClientInfo_Sale;
import businesslogic.salebl.info.CommodityInfo_Sale;
import po.CommodityItemPO;
import po.SalesPO;
import vo.commodity.CommodityItemVO;
import vo.sale.SalesVO;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataservice.saledataservice.SaleDataService;

/**
 * 这个类实现对销售单有更改的接口
 * @author Zing
 * @version Dec 6, 2014 4:41:05 PM
 */
public class SaleOperate implements SaleInfo_Approval {

	private Sale sale;
	private SaleDataService saleData;

	public SaleOperate() {
		sale = new Sale();
		saleData = sale.getSaleData();
	}

	/**
	 * 更新销售单
	 * @throws RemoteException
	 */
	public ResultMessage update(SalesVO vo) throws RemoteException {
		SalesPO po = SaleTrans.VOtoPO(vo);
		return saleData.update(po);
	}

	/**
	 * 通过销售单／销售退货单
	 * 销售单：减少商品库存数量，增加客户应收金额
	 * 销售退货单：增加商品库存数量，减少客户应收金额
	 * @throws RemoteException
	 */
	public ResultMessage pass(SalesVO vo) throws RemoteException {
		SalesPO po = saleData.find(vo.ID);
		// 更改商品库存数量、最近售价
		CommodityInfo_Sale commodityInfo = new CommodityInfo();
		ArrayList<CommodityItemPO> commodities = po.getCommodities();
		// 检查现在的商品数量是否够，如果不够，就直接返回商品不足，并将这个单子的状态设为审批失败
		if (vo.type == BillType.SALE) {
			for(CommodityItemPO commodity : commodities) {
				if (!commodityInfo.checkNumber(commodity.getID(), commodity.getNumber())) {
					po.setState(BillState.FAILURE);
					saleData.update(po);
					return ResultMessage.COMMODITY_LACK;
				}
			}
		}

		for(CommodityItemPO commodity : commodities) {
			commodityInfo.changeCommodityInfo(commodity.getID(), commodity.getNumber(), commodity.getPrice(), po.getType());
		}
		// 更改客户的应收金额
		ClientInfo_Sale clientInfo = new ClientInfo();
		if (po.getType() == BillType.SALE) {
			clientInfo.changeReceivable(po.getClientID(), po.getAfterPrice());
		} else {
			clientInfo.changeReceivable(po.getClientID(), -po.getAfterPrice());
		}
		// 更新该单子的状态
		po.setState(BillState.SUCCESS);
		saleData.update(po);
		return ResultMessage.SUCCESS;
	}

	/**
	 * 红冲／红冲并复制
	 * @throws RemoteException
	 */
	public SalesVO addRed(SalesVO vo, boolean isCopy) throws RemoteException {
		SalesVO redVO = vo;
		// 取负
		ArrayList<CommodityItemVO> commodities = redVO.commodities;
		for(int i = 0; i < commodities.size(); i++) {
			int number = -commodities.get(i).number;
			commodities.get(i).number = number;
		}
		redVO.commodities = commodities;
		redVO.allowance = (-redVO.allowance);
		redVO.voucher = (-redVO.voucher);
		// 先建立对应的PO
		SalesPO redPO = SaleTrans.VOtoPO(redVO);
		if (!isCopy) {
			// 入账，更改相应数据
			saleData.insert(redPO);
			pass(redVO);
		} else {
			// TODO 保存为草稿状态
		}
		return redVO;
	}

	@Override
	public void noPass(SalesVO vo) throws RemoteException {
		SalesPO po = SaleTrans.VOtoPO(vo);
		po.setState(BillState.FAILURE);
		saleData.update(po);
	}

}
