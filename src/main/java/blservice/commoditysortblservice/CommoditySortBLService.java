package blservice.commoditysortblservice;

import java.util.ArrayList;

import message.ResultMessage;
import vo.commodity.CommoditySortVO;

public interface CommoditySortBLService {

	/**
	 * 返回所有商品分类
	 * 可以找到根节点
	 * @return
	 */
	public ArrayList<CommoditySortVO> show();

	/**
	 * 根据商品分类的ID返回具体分类
	 * @param ID
	 * @return
	 * @author Zing
	 * @version Dec 1, 2014 7:43:08 PM
	 */
	public CommoditySortVO show(String ID);

	/**
	 * 创建商品分类的时候调用，显示商品分类ID
	 * 需要传父类的ID
	 * @return
	 * @author Zing
	 * @version Dec 1, 2014 6:45:00 PM
	 */
	public String getID(String fatherID);

	/**
	 * 添加商品分类
	 * @param sortName
	 * @param fatherID 父类的ID
	 * @return
	 * @author Zing
	 * @version Dec 1, 2014 6:54:53 PM
	 */
	public ResultMessage addCommoSort(String sortName, String fatherID);

	/**
	 * 删除商品分类
	 * @param ID 商品分类的ID
	 * @return
	 */
	public ResultMessage deleteCommoSort(String ID);

	/**
	 * @param ID 分类ID
	 * @param name 分类名称
	 * @return 更新结果
	 * @author cylong
	 * @version 2014年12月27日 下午7:26:42
	 */
	public ResultMessage updCommoSort(String ID, String name);

}
