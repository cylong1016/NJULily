package businesslogic.commoditysortbl;

import java.util.ArrayList;

import message.ResultMessage;
import vo.CommoditySortVO;
import blservice.commoditysortblservice.CommoditySortBLService;

/**
 * 实现CommoditySortBLService的类
 * 调用CommoditySort对象
 * @author Zing
 * @version 2014年11月9日下午3:01:57
 */
public class CommoditySortController implements CommoditySortBLService{
	
	private CommoditySort commoditySort;
	
	public CommoditySortController() {
		commoditySort = new CommoditySort();
	}
	
	public ResultMessage addCommoSort(String sortName, CommoditySortVO parentSort) {	
		return commoditySort.addCommoSort(sortName, parentSort);
	}

	public ArrayList<CommoditySortVO> show() {
		return commoditySort.show();
	}


	public ResultMessage deleteCommoSort(String ID) {
		return commoditySort.deleteCommoSort(ID);
	}


	public ResultMessage updCommoSort(String ID, String name) {
		return commoditySort.updCommoSort(ID, name);
	}

}
