package businesslogicservice;

import message.ResultMessage;
import vo.CommoditySortVO;

public interface CommoditySortBLService {
	/**
	 * 添加商品分类
	 * @param sortName 分类名称
	 * @param parentSort 父类
	 * @return
	 */
	public ResultMessage addCommoSort(String sortName, CommoditySortVO parentSort);

	/**
	 * 删除商品分类
	 * @param sortName 商品分类的名称
	 * @return
	 */
	public ResultMessage deleteCommoSort(CommoditySortVO sort);
	
	/**
	 * 更改商品分类名称
	 * @param sortName 分类名称
	 * @return
	 */
	public ResultMessage updCommoSort(CommoditySortVO sort);
	

}
