package businesslogicservice;

import dataenum.CommoditySort;
import message.ResultMessage;

/**
 * 负责实现商品与商品管理界面所需要的服务
 * @author cylong
 * @version Oct 26, 2014 3:05:16 PM
 */
/**
 * 添加内容
 * @author soujing
 * @version 2014年10月27日下午4:48:31
 */
public interface CommodityBLService {
	/**
	 * 添加商品分类
	 * @param sortName 分类名称
	 * @param parentSort 父类
	 * @return
	 */
	public ResultMessage addCommoSort(String sortName, CommoditySort parentSort);

	/**
	 * 删除商品分类
	 * @param sortName 商品分类的名称
	 * @return
	 */
	public ResultMessage deleteCommoSort(String sortName);
	
	/**
	 * 更改商品分类名称
	 * @param sortName 分类名称
	 * @return
	 */
	public ResultMessage updCommoSort(String sortName);
	
	/**
	 * 添加商品
	 * @param sortName 商品分类
	 * @param name 商品名称
	 * @param type 商品类型
	 * @param purPrice 商品进价
	 * @param salePrice 商品售价
	 * @return
	 */
	public ResultMessage addCommo(CommoditySort sortName, String name, 
			String type, int purPrice, int salePrice);

	/**
	 * 删除商品
	 * @param name 商品名称
	 * @return
	 */
	public ResultMessage deletCommo(String name);

	/**
	 * 更改商品信息
	 * @param name 商品名称
	 * @param sortName 商品分类
	 * @param type 商品类型
	 * @param purPrice 商品进价
	 * @param salePrice 商品售价
	 * @return
	 */
	public ResultMessage updCommo(String name, CommoditySort sortName, 
			String type, int purPrice, int salePrice);

	/**
	 * 查找商品
	 * @param name 商品名称
	 * @param id 商品编号
	 * @param type 商品型号
	 * @return
	 */
	public ResultMessage findCommo(String name, int id, String type);


}
