package blservice.commodityblservice;

import java.util.ArrayList;
import po.CommodityPO;
import dataenum.FindTypeCommo;
import vo.CommodityVO;
import message.ResultMessage;

/**
 * 负责实现商品与商品管理界面所需要的服务
 * @author cylong
 * @version Oct 26, 2014 3:05:16 PM
 */
/**
 * 添加内容
 * 每个商品都属于一个分类，点击某个叶节点分类后能显示该分类下的所有商品。
 * 商品的属性有：编号、名称、型号、库存数量、进价、零售价、最近进价、最近零售价。
 * 因为在实际中进价和售价一直都在变化，所以一开始规定一个进价和售价作为默认值，保存一个最近的进价和售价属性。
 * 商品的增删改查包括增加商品、删除商品、修改商品和查询商品。商品编号根据其所在的分类以及添加次序自动生成。
 * 商品的查询可以通过输入关键字、商品编号等进行模糊查找，系统会自动判断，然后直接给一个搜索结果
 * @author Zing
 * @version 2014年10月27日下午4:48:31
 */
public interface CommodityBLService {
	
	/**
	 * 显示所有的商品
	 */
	public ArrayList<CommodityVO> show();
	
	/**
	 * 根据ID显示特定商品信息
	 * @param ID
	 * @return
	 * @author Zing
	 * @version Dec 1, 2014 7:54:14 PM
	 */
	public CommodityVO show(String ID);
	
	/**
	 * 在创建一个商品的时候，得到商品的ID
	 * 需要父类的ID来确定商品的ID
	 * @return
	 * @author Zing
	 * @version Nov 30, 2014 10:31:48 AM
	 */
	public String getID(String sortID);
	
	/**
	 *  添加商品
	 * @param sortID
	 * @param info
	 * @return
	 * @author Zing
	 * @version Nov 30, 2014 10:37:08 AM
	 */
	public ResultMessage addCommo(CommodityInputInfo info);

	/**
	 * 删除商品
	 * @param id 商品名称
	 * @return
	 */
	public ResultMessage deletCommo(String ID);

	/**
	 * 更改商品信息
	 * @param sortID
	 * @param ID
	 * @param info
	 * @return
	 * @author Zing
	 * @version Nov 30, 2014 10:37:46 AM
	 */
	public ResultMessage updCommo(String ID, CommodityInputInfo info);

	/**
	 * 查找商品
	 * @param name 商品名称
	 * @return
	 */
	public ArrayList<CommodityVO> findCommo(String info, FindTypeCommo type);


}
