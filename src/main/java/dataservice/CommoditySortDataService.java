package dataservice;

import message.ResultMessage;
import po.CommodityManagePO;

/**
 * 提供商品分类数据集体载入、保存、增删改查服务
 * @author cylong
 * @version Oct 26, 2014 3:55:35 PM
 */
public interface CommoditySortDataService extends DataService {

	/**
	 * 插入一个商品分类节点
	 * @param po
	 * @return 处理结果
	 */
	public ResultMessage insert(CommodityManagePO po);

	/**
	 * 用分类名称查找分类
	 * @param name
	 * @return 商品分类节点
	 */
	public CommodityManagePO find(String name);

	/**
	 * 以分类ID删除分类
	 * @param ID
	 * @return 处理结果
	 */
	public ResultMessage delete(String ID);

	/**
	 * 更新分类
	 * @param po
	 * @return 处理结果
	 */
	public ResultMessage update(CommodityManagePO po);

}
