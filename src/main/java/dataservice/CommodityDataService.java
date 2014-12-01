package dataservice;

import java.util.ArrayList;

import po.CommodityPO;
import dataenum.FindTypeCommo;

/**
 * 提供商品集体载入、保存、增删改查服务
 * @author cylong
 * @version Oct 26, 2014 3:52:31 PM
 */
public interface CommodityDataService extends CommonDataService<CommodityPO> {

	/**
	 * 根据keywords查看商品，type是以什么方式查找，null是模糊查找
	 * @param keywords
	 * @return 商品持久化数据
	 */
	public ArrayList<CommodityPO> find(String keywords, FindTypeCommo type);

	/**
	 * 已商品的ID查找其所有的型号
	 * @param ID
	 * @return 商品型号的ArrayList
	 * @author cylong
	 * @version Nov 15, 2014 11:10:25 AM
	 */
	public ArrayList<String> findType(String ID);

	/**
	 * @return 全部商品的ID
	 * @author cylong
	 * @version 2014年11月28日 下午12:28:46
	 */
	public ArrayList<String> getAllID();
}
