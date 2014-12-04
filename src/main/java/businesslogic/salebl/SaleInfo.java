package businesslogic.salebl;

import java.util.ArrayList;

import message.ResultMessage;
import businesslogic.approvalbl.info.SaleInfo_Approval;
import businesslogic.approvalbl.info.ValueObject_Approval;
import businesslogic.clientbl.ClientInfo;
import businesslogic.commoditybl.CommodityInfo;
import businesslogic.common.Info;
import businesslogic.inventorybl.info.SaleInfo_Inventory;
import businesslogic.recordbl.info.SaleInfo_Record;
import businesslogic.recordbl.info.ValueObjectInfo_Record;
import po.CommodityItemPO;
import po.SalesPO;
import vo.CommodityItemVO;
import vo.SalesVO;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.Storage;
import dataservice.TableInfoService;
import dataservice.saledataservice.SaleDataService;

public class SaleInfo extends Info<SalesPO> implements SaleInfo_Inventory, SaleInfo_Record, ValueObjectInfo_Record<SalesVO>, ValueObject_Approval<SalesVO>, SaleInfo_Approval{
	
	private Sale sale;
	
	private String ID;
	
	private ArrayList<String> saleIDs;
	
	private ArrayList<String> backIDs;

	public SaleInfo() {
		sale = new Sale();
	}
	
	public SaleInfo(ArrayList<String> IDs) {
		sale = new Sale();
		saleIDs = new ArrayList<String>();
		backIDs = new ArrayList<String>();
		for (String id : IDs) {
			saleIDs.addAll(getID(id, null, null, null, BillType.SALE));
			backIDs.addAll(getID(id, null, null, null, BillType.SALEBACK));
		}
	}
	
	protected  TableInfoService<SalesPO> getData() {
		return sale.getSaleData().getInfo();
	}
	
	private SaleDataService getSaleData() {
		return sale.getSaleData();
	}
	
	
	/**
	 * 以下是其他包中的SaleInfo接口的方法
	 */

	/**
	 * 根据查找条件查找销售单，返回销售单的ID集合
	 * String ID 的格式为 yyyyMMdd
	 */
	public ArrayList<String> getID(String ID, String clientName, String salesman, Storage storage) {
		ArrayList<String> IDs = new ArrayList<String>();
		IDs = getID(ID, clientName, salesman, storage, BillType.SALE);
		IDs.addAll(getID(ID, clientName, salesman, storage, BillType.SALEBACK));
		return IDs;
	}
	
	public SalesVO find(String ID) {
		SalesVO vo = sale.poToVo(getSaleData().find(ID));
		return vo;
	}

	public String getCommodityID(String ID, String commodityName) {
		this.ID = ID;
		ArrayList<CommodityItemPO> POs= getSaleData().find(ID).getCommodities();
		for (int i = 0; i < POs.size(); i++) {
			if (POs.get(i).getName().equals(commodityName)) {
				return POs.get(i).getID();
			}
		}
		return null;
	}
	
	/**
	 * 为了找到特定销售单中的商品
	 * @param ID 商品的ID
	 * @return
	 * @author Zing
	 * @version Dec 1, 2014 9:04:04 AM
	 */
	private CommodityItemPO findCommodityItemPO(String ID) {
		ArrayList<CommodityItemPO> commodityPo = getSaleData().find(this.ID).getCommodities();
		for (int i = 0; i < commodityPo.size(); i++) {
			if (commodityPo.get(i).getID().equals(ID)) {
				return commodityPo.get(i);
			}
		}
		return null;
	}

	public String getCommodityName(String ID) {
		return findCommodityItemPO(ID).getName();
	}

	public String getCommodityType(String ID) {
		return findCommodityItemPO(ID).getType();
	}

	public int getCommodityNumber(String ID) {
		return findCommodityItemPO(ID).getNumber();
	}

	public double getCommodityPrice(String ID) {
		return findCommodityItemPO(ID).getPrice();
	}
	
	// 以上都是对销售单中商品列表的某个商品的查询（根据ID）
	
	/**
	 * 查找指定销售单（销售退货单）的折扣后价格（不包括代金券）
	 */
	public double getBeforePrice(String ID) {
		SalesPO po = getSaleData().find(ID);
		return po.getBeforePrice();
	}

	/**
	 * 查找指定销售单的代金券
	 */
	public double getVoucher(String ID) {
		return getSaleData().find(ID).getVoucher();
	}

	/**
	 * 查找指定销售单的折扣
	 */
	public double getAllowance(String ID) {
		return getSaleData().find(ID).getVoucher();
	}

	/**
	 * 查找需要审批的单子
	 */
	public ArrayList<SalesVO> findApproval() {
		ArrayList<SalesPO> POs = getSaleData().show();
		ArrayList<SalesPO> approvalPO = new ArrayList<SalesPO>();
		for (SalesPO po : POs) {
			if (po.getState() == BillState.APPROVALING) {
				approvalPO.add(po);
			}
		}
		ArrayList<SalesVO> VOs = new ArrayList<SalesVO>();
		for (SalesPO po : approvalPO) {
			SalesVO vo = sale.poToVo(po);
			VOs.add(vo);
		}
		return VOs;
	}

	/**
	 * 更新销售单
	 */
	public ResultMessage update(SalesVO vo) {
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
		ArrayList<CommodityItemPO> commodities = sale.itemsVOtoPO(vo.commodities);
		SalesPO po = new SalesPO(ID, clientID, client, salesman, user, storage, commodities, beforePrice, allowance, voucher, remark, afterPrice, type);
		return getSaleData().update(po);
	}

	public double getMoney() {
		if (saleIDs.isEmpty() && backIDs.isEmpty()) {
			return 0;
		}
		double saleMoney = 0;
		for (String id : saleIDs) {
			saleMoney += getBeforePrice(id);
		}
		for (String id : backIDs) {
			saleMoney -= getBeforePrice(id);
		}
		return saleMoney;
	}

	public int getNumber() {
		if (saleIDs.isEmpty() && backIDs.isEmpty()) {
			return 0;
		}
		int saleNumber = 0;
		for (String id : saleIDs) {
			saleNumber += getAllCommoditiesNumber(id);
		}
		for (String id : backIDs) {
			saleNumber -= getAllCommoditiesNumber(id);
		}
		return saleNumber;
	}
	
	/**
	 * 得到一个销售单中的所有商品的数量
	 * @param ID
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 5:15:27 PM
	 */
	private int getAllCommoditiesNumber(String ID) {
		ArrayList<CommodityItemPO> POs = getSaleData().find(ID).getCommodities();
		int number = 0;
		for (CommodityItemPO po : POs) {
			number += po.getNumber();
		}
		return number;
	}

	/**
	 * 通过销售单／销售退货单
	 * 销售单：减少商品库存数量，增加客户应收金额
	 * 销售退货单：增加商品库存数量，减少客户应收金额
	 */
	public void pass(SalesVO vo) {
		SalesPO po = getSaleData().find(ID);
		// 更新该单子的状态
		po.setState(BillState.SUCCESS);
		getSaleData().update(po);
		// 更改商品库存数量、最近售价
		CommodityInfo_Sale commodityInfo = new CommodityInfo();
		ArrayList<CommodityItemPO> commodities = po.getCommodities();
		for (CommodityItemPO commodity : commodities) {
			commodityInfo.changeCommodityInfo(commodity.getID(), commodity.getNumber(), commodity.getPrice(), po.getType());
		}
		// 更改客户的应收金额
		ClientInfo_Sale clientInfo = new ClientInfo();
		if (po.getType() == BillType.SALE) {
			clientInfo.changeReceivable(po.getClientID(), po.getAfterPrice());
		}
		else {
			clientInfo.changeReceivable(po.getClientID(), -po.getAfterPrice());
		}
	}

	/**
	 * 红冲／红冲并复制
	 */
	public SalesVO addRed(SalesVO vo, boolean isCopy) {
		SalesVO redVO = vo;
		// 取负
		ArrayList<CommodityItemVO> commodities = redVO.commodities;
		for (int i = 0; i < commodities.size(); i++) {
			int number = -commodities.get(i).number;
			commodities.get(i).number = number;
		}
		redVO.commodities = commodities;
		redVO.allowance = (-redVO.allowance);
		redVO.voucher = (-redVO.voucher);
		// 先建立对应的PO
		SalesPO redPO = new SalesPO(redVO.ID, redVO.clientID, redVO.client, redVO.salesman, redVO.user, redVO.storage, 
				sale.itemsVOtoPO(redVO.commodities), redVO.beforePrice, redVO.allowance, redVO.voucher, redVO.remark, redVO.afterPrice, redVO.type);
		if (!isCopy) {
			// 入账，更改相应数据
			getSaleData().insert(redPO);
			pass(redVO);		
		}
		else {
			// TODO 保存为草稿状态
		}
		return redVO;
	}
	

}
