package businesslogic.salebl;

import java.util.ArrayList;

import businesslogic.inventorybl.info.SaleInfo_Inventory;
import businesslogic.recordbl.info.SaleInfo_Record;
import businesslogic.recordbl.info.ValueObjectInfo_Record;
import po.CommodityItemPO;
import po.SalesPO;
import vo.SalesVO;
import dataenum.BillType;
import dataenum.Storage;
import dataservice.SaleDataService;

public class SaleInfo  implements SaleInfo_Inventory, SaleInfo_Record, ValueObjectInfo_Record<SalesVO>{
	
	private Sale sale;
	
	private String ID;

	public SaleInfo() {
		sale = new Sale();
	}
	
	public SaleDataService getSaleData() {
		return sale.getSaleData();
	}
	
	
	
	/**
	 * 以下是其他包中的SaleInfo接口的方法
	 */
	
	public ArrayList<Double> getMoney(String begin, String end) {
		// TODO 需要根据日期查询ID的方法，返回我一个arrylistID。或者我自己查，那就提供一个返回所有PO的方法
		//		SaleDataService saleData = getSaleData();
		return null;
	}

	public ArrayList<Integer> getNumber(String begin, String end) {
		return null;
	}

	/**
	 * 根据查找条件查找销售单，返回销售单的ID
	 * String ID 的格式为 yyyyMMdd
	 */
	public String getID(String ID, String clientName, String salesman, Storage storage) {
		SaleDataService saleData = getSaleData();
		ArrayList<String> IDs = saleData.getAllID(BillType.SALE);
		for (int i = 0; i < IDs.size(); i++) {
			SalesPO po = saleData.find(IDs.get(i));
			if (IDs.get(i).contains(ID)) {
				if (po.getClient().equals(clientName) && po.getSalesman().endsWith(salesman) && po.getStorage().equals(storage)) {
					return IDs.get(i);
				}
			}
		}
		return null;
	}
	
	public SalesVO show(String ID) {
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

}
