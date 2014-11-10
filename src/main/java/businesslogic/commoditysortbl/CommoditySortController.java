package businesslogic.commoditysortbl;

import message.ResultMessage;
import vo.CommoditySortVO;
import businesslogicservice.CommoditySortBLService;

/**
 * 实现CommoditySortBLService的类
 * @author Zing
 * @version 2014年11月9日下午3:01:57
 */
public class CommoditySortController implements CommoditySortBLService{
	
	private CommoditySort commoditySort;
	
	public ResultMessage addCommoSort(String sortName,
			CommoditySortVO parentSort) {
		
		return commoditySort.addCommoSort(sortName, parentSort);
	}

	
	public ResultMessage deleteCommoSort(CommoditySortVO sort) {
		return commoditySort.deleteCommoSort(sort);
	}

	public ResultMessage updCommoSort(CommoditySortVO sort) {		
		return commoditySort.updCommoSort(sort);
	}

}
