package dataservice.commoditysortdataservice;

import dataservice.CommonDataService;
import po.CommoditySortPO;

/**
 * 提供商品分类数据集体载入、保存、增删改查服务
 * @author cylong
 * @version Oct 26, 2014 3:55:35 PM
 */
public interface CommoditySortDataService extends CommonDataService<CommoditySortPO> {

	/**
	 * @param fatherID 分类父类的ID
	 * @return 新建分类的ID
	 * @author cylong
	 * @version 2014年12月1日 下午9:20:35
	 */
	public String getID(String fatherID);
}
