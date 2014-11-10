package businesslogic.commoditybl;

import java.util.ArrayList;

import message.ResultMessage;
import po.CommodityPO;
import vo.CommoditySortVO;
import dataenum.FindTypeCommo;
import dataservice.CommodityDataService;
import dataservice.CommoditySortDataService;
/**
 * 商品管理
 * @author Zing
 * @version 2014年11月9日下午2:53:19
 */
public class Commodity {
	
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
	
	public Commodity(CommodityDataService commodityData) {
		this.commodityData = commodityData;
	}
	
	public Commodity(CommoditySortDataService commoditySortData){
		this.commoditySortData = commoditySortData;
	}

	public ResultMessage addCommo(CommoditySortVO sort, String name,
			String type, double purPrice, double salePrice) {
		// TODO Auto-generated method stub
		CommodityPO po = 
				new CommodityPO(
						commodityData.getID(), 
						name, 
						commoditySortData.find(sort.name), 
						type, purPrice, salePrice);
		commodityData.insert(po);
		return ResultMessage.SUCCESS;
	}

	public ResultMessage deletCommo(String name) {
		CommodityPO po = commodityData.find(name);
		if (po!=null) {
			return commodityData.delete(po.getId());
		}
		else 
			return ResultMessage.FAILURE;
	}

	public ResultMessage updCommo(String id, String name, CommoditySortVO sort,
		String type, double purPrice, double salePrice) {
		CommodityPO po = new CommodityPO(
				id, name, 
				commoditySortData.find(sort.name), 
				type, purPrice, salePrice);
		
		return commodityData.update(po);
	}

	public ArrayList<CommodityPO> findCommo(String info, FindTypeCommo type) {
		commodityData.find(info);
		// TODO
		return null;
	}

	public void showCommo() {
		// TODO Auto-generated method stub
		
	}


}
