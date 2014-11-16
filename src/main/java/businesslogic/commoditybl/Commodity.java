package businesslogic.commoditybl;

import java.rmi.Naming;
import java.util.ArrayList;

import message.ResultMessage;
import po.CommodityPO;
import vo.CommoditySortVO;
import vo.CommodityVO;
import businesslogic.salebl.CommodityInfo;
import dataenum.FindTypeCommo;
import dataservice.CommodityDataService;
import dataservice.CommoditySortDataService;
import dataservice.DataFactoryService;
/**
 * 商品管理
 * @author Zing
 * @version 2014年11月9日下午2:53:19
 */
public class Commodity implements CommodityInfo, businesslogic.purchasebl.CommodityInfo{
	
	/** 商品名称 */
	public String name;
	/** 商品型号 */
	public String type;
	/** 商品库存数量 */
	public int inventoryNum;
	/** 商品进价 */
	public double purPrice;
	/** 商品售价 */
	public double salePrice;
	/** 商品最近进价 */
	public double recentPurPrice;
	/** 商品最近售价 */
	public double recentSalePrice;
	
	private CommodityDataService commodityData;
	
	private CommoditySortDataService commoditySortData;
	
	private CommodityPO po;
	
	public Commodity() {
		try {
			DataFactoryService factory = (DataFactoryService)Naming.lookup("rmi://127.0.0.1:1994/factory");
			commodityData = (CommodityDataService)factory.getCommodityData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Commodity(CommoditySortDataService commoditySortData){
		this.commoditySortData = commoditySortData;
	}

	public ResultMessage addCommo(CommoditySortVO sort, String name,
			String type, double purPrice, double salePrice) {
		// TODO Auto-generated method stub
		po = new CommodityPO(commodityData.getID(), name, commoditySortData.find(sort.name), 
						type, purPrice, salePrice);
		commodityData.insert(po);
		return ResultMessage.SUCCESS;
	}

	public ResultMessage deletCommo(String id) {
		po = commodityData.find(id, FindTypeCommo.ID).get(0);
		if (po!=null) {
			return commodityData.delete(po.getId());
		}
		else 
			return ResultMessage.FAILURE;
	}

	public ResultMessage updCommo(String id, String name, CommoditySortVO sort,
		String type, double purPrice, double salePrice) {
		po = new CommodityPO(
				id, name, 
				commoditySortData.find(sort.name), 
				type, purPrice, salePrice);
		
		return commodityData.update(po);
	}

	public ArrayList<CommodityPO> findCommo(String info, FindTypeCommo type) {
		commodityData.find(info, type);
		// TODO
		return null;
	}

	public ArrayList<CommodityVO> showCommo() {
		return null;
		// TODO Auto-generated method stub
		
	}

	public String getType(String name) {
		po = commodityData.find(name, FindTypeCommo.NAME).get(0);
		return 	po.getType();
	}

	public String getID(String ID) {
		po = commodityData.find(ID, FindTypeCommo.ID).get(0);
		return po.getId();
	}


}
