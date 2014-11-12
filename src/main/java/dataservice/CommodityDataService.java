package dataservice;

import message.ResultMessage;
import po.CommodityPO;
import dataenum.FindTypeCommo;

/**
 * 提供商品集体载入、保存、增删改查服务
 * @author cylong
 * @version Oct 26, 2014 3:52:31 PM
 */
public interface CommodityDataService extends DataService {

	/**
	 * 插入一条商品信息
	 * @param po
	 * @return 处理结果
	 */
	public ResultMessage insert(CommodityPO po);

	/**
	 * 根据keywords查看商品，type是以什么方式查找，null是模糊查找
	 * @param keywords
	 * @return 商品持久化数据
	 */
	public CommodityPO find(String keywords, FindTypeCommo type);

	/**
	 * 以ID删除商品数据
	 * @param ID
	 * @return 处理结果
	 */
	public ResultMessage delete(String ID);

	/**
	 * 更新商品数据
	 * @param po
	 * @return 处理结果
	 */
	public ResultMessage update(CommodityPO po);
}
