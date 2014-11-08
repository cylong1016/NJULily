package businesslogicservice;

import java.util.ArrayList;

import po.CommodityPO;
<<<<<<< HEAD
import dataenum.FindType;
=======
>>>>>>> FETCH_HEAD
import vo.CommoditySortVO;
import message.ResultMessage;
import dataenum.FindType;

/**
 * 负责实现商品与商品管理界面所需要的服务
 * @author cylong
 * @version Oct 26, 2014 3:05:16 PM
 */
/**
 * 添加内容
 * @author Zing
 * @version 2014年10月27日下午4:48:31
 */
public interface CommodityBLService {
	
	/**
	 * 显示所有的商品
	 */
	public void showCommo();
	
	/**
	 * 添加商品
	 * @param sortName 商品分类
	 * @param name 商品名称
	 * @param type 商品类型
	 * @param purPrice 商品进价
	 * @param salePrice 商品售价
	 * @return
	 */
	public ResultMessage addCommo(CommoditySortVO sort, String name, 
			String type, double purPrice, double salePrice);

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
	public ResultMessage updCommo(String id, String name, CommoditySortVO sort, 
			String type, double purPrice, double salePrice);

	/**
	 * 查找商品
	 * @param name 商品名称
	 * @return
	 */
	public ArrayList<CommodityPO> findCommo(String info, FindType type);


}
