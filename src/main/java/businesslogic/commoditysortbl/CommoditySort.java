package businesslogic.commoditysortbl;

import message.ResultMessage;
import po.CommoditySortPO;
import vo.CommoditySortVO;
import dataservice.CommoditySortDataService;

public class CommoditySort {
	
	private CommoditySortDataService commoditySortData;
	
	
	public CommoditySort(CommoditySortDataService commoditySortData) {
		this.commoditySortData = commoditySortData;
	}
	
	/**
	 * 添加商品分类
	 * @param sortName
	 * @param parentSort
	 * @return
	 */
	public ResultMessage addCommoSort(String sortName,
			CommoditySortVO parentSort) {
		
		CommoditySortPO po = 
				new CommoditySortPO(
						commoditySortData.getID(), 
						sortName, 
						commoditySortData.find(parentSort.name));
		commoditySortData.insert(po);
		return ResultMessage.SUCCESS;
	}

	/**
	 * 删除商品分类
	 * @param sort
	 * @return
	 */
	public ResultMessage deleteCommoSort(CommoditySortVO sort) {
		commoditySortData.delete(sort.name);
		return ResultMessage.SUCCESS;
	}

	/**
	 * 修改商品分类
	 * @param sort
	 * @return
	 */
	public ResultMessage updCommoSort(CommoditySortVO sort) {		
		CommoditySortPO po = 
				new CommoditySortPO(
						sort.ID, 
						sort.name, 
						commoditySortData.find(sort.name).getFather());
		commoditySortData.update(po);
		return ResultMessage.SUCCESS;
	}

}
