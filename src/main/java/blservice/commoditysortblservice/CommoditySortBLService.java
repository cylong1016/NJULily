package blservice.commoditysortblservice;

import java.util.ArrayList;

import message.ResultMessage;
import vo.CommoditySortVO;

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
	 * 更改商品分类名称
	 * @param sortName 分类名称
	 * @return
	 */
	public ResultMessage updCommoSort(String ID, String name);
	

}
