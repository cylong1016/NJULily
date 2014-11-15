package businesslogic.commoditysortbl;

import java.util.ArrayList;

import message.ResultMessage;
import vo.CommoditySortVO;
import businesslogicservice.CommoditySortBLService;

/**
 * 实现CommoditySortBLService的类
 * 调用CommoditySort对象
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


	public ArrayList<CommoditySortVO> show() {
		// TODO Auto-generated method stub
		return null;
	}


	public ResultMessage deleteCommoSort(String ID) {
		// TODO Auto-generated method stub
		return null;
	}


	public ResultMessage updCommoSort(String ID, String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
