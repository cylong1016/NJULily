package businesslogic.commoditysortbl;

import java.rmi.Naming;
import java.util.ArrayList;

import message.ResultMessage;
import po.CommoditySortPO;
import vo.CommoditySortVO;
import dataservice.CommoditySortDataService;
import dataservice.DataFactoryService;

public class CommoditySort {
	
	private CommoditySortDataService commoditySortData;
	
	private String ID;
	
	private CommoditySortPO po;
	
	public CommoditySort() {
		try {
			DataFactoryService factory = (DataFactoryService)Naming.lookup("rmi://127.0.0.1:8888/factory");
			commoditySortData= (CommoditySortDataService)factory.getCommoditySortData();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public String getID(){
		ID = commoditySortData.getID();
		return ID;
	}
	
	/**
	 * 添加商品分类
	 * @param sortName
	 * @param parentSort
	 * @return
	 */
	public ResultMessage addCommoSort(String sortName, CommoditySortVO parentSort) {
		po = new CommoditySortPO(getID(), sortName, commoditySortData.find(parentSort.name));
		commoditySortData.insert(po);
		return ResultMessage.SUCCESS;
	}
	

	public ArrayList<CommoditySortVO> show() {
		// 需要展示所有分类的方法
		return null;
	}


	public ResultMessage deleteCommoSort(String ID) {
		return commoditySortData.delete(ID);
	}


	public ResultMessage updCommoSort(String ID, String name) {
		po = new CommoditySortPO(ID, name, commoditySortData.find(ID).getFather());
		return commoditySortData.update(po);
	}

}
