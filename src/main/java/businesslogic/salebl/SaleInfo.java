package businesslogic.salebl;

import java.util.ArrayList;

import businesslogic.approvalbl.ValueObject_Approval;
import businesslogic.common.Info;
import businesslogic.inventorybl.info.SaleInfo_Inventory;
import businesslogic.recordbl.info.SaleInfo_Record;
import businesslogic.recordbl.info.ValueObjectInfo_Record;
import po.CommodityItemPO;
import po.SalesPO;
import server.data.saledata.SaleData;
import vo.SalesVO;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.Storage;
import dataservice.saledataservice.SaleDataService;

public class SaleInfo extends Info<SaleDataService> implements SaleInfo_Inventory, SaleInfo_Record, ValueObjectInfo_Record<SalesVO>, ValueObject_Approval<SalesVO>{
	
	private Sale sale;
	
	private String ID;

	public SaleInfo() {
		sale = new Sale();
	}
	
	protected  SaleDataService getData() {
		return sale.getSaleData();
	}
	
	
	/**
	 * 以下是其他包中的SaleInfo接口的方法
	 */
	
	public ArrayList<Double> getMoney(String begin, String end) {
		// TODO 需要根据日期查询ID的方法，返回我一个arrylistID。或者我自己查，那就提供一个返回所有PO的方法
		//		SaleDataService saleData = getData();
		return null;
	}

	public ArrayList<Integer> getNumber(String begin, String end) {
		return null;
	}

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
		SalesVO vo = sale.poToVo(getData().find(ID));
		return vo;
	}

	public String getCommodityID(String ID, String commodityName) {
		this.ID = ID;
		ArrayList<CommodityItemPO> POs= getData().find(ID).getCommodities();
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
		ArrayList<CommodityItemPO> commodityPo = getData().find(this.ID).getCommodities();
		for (int i = 0; i < commodityPo.size(); i++) {
			if (commodityPo.get(i).getID().equals(ID)) {
				return commodityPo.get(i);
			}
		}
		return null;
	}

	public String getName(String ID) {
		return findCommodityItemPO(ID).getName();
	}

	public String getType(String ID) {
		return findCommodityItemPO(ID).getType();
	}

	public int getNumber(String ID) {
		return findCommodityItemPO(ID).getNumber();
	}

	public double getPrice(String ID) {
		return findCommodityItemPO(ID).getPrice();
	}
	
	// 以上都是对销售单中商品列表的某个商品的查询（根据ID）
	
	/**
	 * 查找指定销售单的折扣后价格（不包括代金券）
	 */
	public double getBeforePrice(String ID) {
		SalesPO po = getData().find(ID);
		return po.getBeforePrice();
	}

	/**
	 * 查找指定销售单的代金券
	 */
	public double getVoucher(String ID) {
		return getData().find(ID).getVoucher();
	}

	/**
	 * 查找指定销售单的折扣
	 */
	public double getAllowance(String ID) {
		return getData().find(ID).getVoucher();
	}

	/**
	 * 查找需要审批的单子
	 */
	public ArrayList<SalesVO> findApproval() {
		ArrayList<SalesPO> POs = getData().show();
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

}
