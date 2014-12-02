package businesslogic.commoditybl;

import java.util.ArrayList;

import po.CommodityPO;
import vo.CommodityVO;
import dataservice.commoditydataservice.CommodityDataService;
import businesslogic.accountainitbl.info.CommodityInfo_Init;
import businesslogic.inventorybl.info.CommodityInfo_Inventory;
import businesslogic.promotionbl.CommodityInfo_Promotion;
import businesslogic.salebl.CommodityInfo_Sale;

public class CommodityInfo implements CommodityInfo_Sale, businesslogic.purchasebl.CommodityInfo_Purchase, CommodityInfo_Inventory, CommodityInfo_Promotion, CommodityInfo_Init{
	
	private Commodity commodity;
	
	private CommodityDataService commodityData;
	
	private CommodityPO po;
	
	public CommodityInfo() {
		commodity = new Commodity();
		this.commodityData = commodity.getCommodityData();
	}
	
	/*
	 * (non-Javadoc)
	 * @see businesslogic.salebl.CommodityInfo_Sale#getType(java.lang.String)
	 */
	public String getType(String ID) {
		po = commodityData.find(ID);
		return 	po.getType();
	}
	
	/*
	 * (non-Javadoc)
	 * @see businesslogic.salebl.CommodityInfo_Sale#getName(java.lang.String)
	 */
	public String getName(String ID) {
		po = commodityData.find(ID);
		return po.getName();
	}

	/*
	 * (non-Javadoc)
	 * @see businesslogic.inventorybl.info.CommodityInfo_Inventory#getAllID()
	 */
	public ArrayList<String> getAllID() {
		return 	commodityData.getAllID();
	}

	/*
	 * (non-Javadoc)
	 * @see businesslogic.inventorybl.info.CommodityInfo_Inventory#getNumber(java.lang.String)
	 */
	public int getNumber(String ID) {
		po = commodityData.find(ID);
		return po.getInventoryNum();
	}

	/*
	 * (non-Javadoc)
	 * @see businesslogic.inventorybl.info.CommodityInfo_Inventory#getAvePrice(java.lang.String)
	 */
	public double getAvePrice(String ID) {
		po = commodityData.find(ID);
		return po.getPurPrice();
	}

	/*
	 * (non-Javadoc)
	 * @see businesslogic.inventorybl.info.CommodityInfo_Inventory#getPurPrice(java.lang.String)
	 */
	public double getPurPrice(String ID) {
		po = commodityData.find(ID);
		return po.getPurPrice();
	}

	/**
	 * 返回重组的商品PO给期初建账
	 */
	public ArrayList<CommodityPO> getCommodityPOs() {
		ArrayList<CommodityPO> POs = commodityData.show();
		ArrayList<CommodityPO> returnPOs = new ArrayList<CommodityPO>();
		for(CommodityPO po : POs) {
			CommodityPO returnPO = new CommodityPO(po.getID(), po.getName(), po.getType(), po.getSortID(), po.getAveSale(), po.getAvePur());
			returnPOs.add(returnPO);
		}
		return returnPOs;
	}

	public ArrayList<CommodityVO> getCommodityVOs(ArrayList<CommodityPO> POs) {
		ArrayList<CommodityVO> VOs = new ArrayList<CommodityVO>();
		for(CommodityPO po : POs) {
			CommodityVO vo = POtoVO(po);
			VOs.add(vo);
		}
		return VOs;
	}
	
	private CommodityVO POtoVO(CommodityPO po) {
		String ID = po.getID();
		String name = po.getName();
		String type = po.getType();
		String sortID = po.getSortID();
		double aveSale = po.getAveSale();
		double avePur = po.getAvePur();
		CommodityVO vo = new CommodityVO(ID, name, type, sortID, aveSale, avePur);
		return vo;
	}

}
