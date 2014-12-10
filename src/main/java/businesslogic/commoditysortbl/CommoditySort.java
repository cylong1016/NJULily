package businesslogic.commoditysortbl;

import java.util.ArrayList;

import message.ResultMessage;
import po.CommoditySortPO;
import server.data.commoditysortdata.CommoditySortData;
import vo.commodity.CommoditySortVO;
import blservice.commoditysortblservice.CommoditySortBLService;
import dataservice.commoditysortdataservice.CommoditySortDataService;

public class CommoditySort implements CommoditySortBLService {

	private CommoditySortDataService commoditySortData;

	private String ID;

	private CommoditySortPO po;

	public CommoditySort() {
//		try {
//			DataFactoryService factory = (DataFactoryService)Naming.lookup(RMI.URL);
//			commoditySortData = factory.getCommoditySortData();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		commoditySortData = new CommoditySortData();
	}

	public String getID(String fatherID) {
		this.ID = commoditySortData.getID(fatherID);
		return ID;
	}

	/**
	 * 得到商品分类的所有东西
	 * @return
	 * @author Zing
	 * @version Dec 1, 2014 7:37:48 PM
	 */
	public ArrayList<CommoditySortVO> show() {
		return allPOtoVO(commoditySortData.show());
	}

	/**
	 * 把每一个PO转VO
	 * @param POs
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 8:34:56 PM
	 */
	public ArrayList<CommoditySortVO> allPOtoVO(ArrayList<CommoditySortPO> POs) {
		ArrayList<CommoditySortVO> VOs = new ArrayList<CommoditySortVO>();
		for(CommoditySortPO po : POs) {
			VOs.add(POtoVO(po));
		}
		return VOs;
	}

	/**
	 * 根据商品分类的ID返回单个商品分类
	 * @param ID
	 * @return
	 * @author Zing
	 * @version Dec 1, 2014 7:45:05 PM
	 */
	public CommoditySortVO show(String ID) {
		CommoditySortPO po = commoditySortData.find(ID);
		return POtoVO(po);
	}

	/**
	 * 添加商品分类
	 * @param sortName
	 * @param parentSort
	 * @return
	 */
	public ResultMessage addCommoSort(String sortName, String fatherID) {

		//这里加一行就万事大吉了
		//不对啊，是你那边要获得好吗！是你直接调用好吗！
		//不对啊！写到一起肯定好！呗呗儿的好儿

		getID(fatherID);

		if (fatherID == null) {
			po = new CommoditySortPO(ID, sortName, null, null, null);
		} else {
			CommoditySortPO father = commoditySortData.find(fatherID);
			// 如果父类里面有了商品的话，添加失败
			if (father.getCommoditiesID() != null) {
				if (!father.getCommoditiesID().isEmpty()) {
					return ResultMessage.FAILURE;
				}
			}
			po = new CommoditySortPO(ID, sortName, fatherID, null, null);
			// 当父类存在、并且父类中没有商品时，往父类中添加这个新建的子类
			father.addChildID(ID);
			commoditySortData.update(father);
		}
		commoditySortData.insert(po);
		return ResultMessage.SUCCESS;
	}

	/**
	 * 删除商品分类
	 * @param ID
	 * @return
	 * @author Zing
	 * @version Dec 1, 2014 7:36:16 PM
	 */
	public ResultMessage deleteCommoSort(String ID) {
		po = commoditySortData.find(ID);
		if (po.getCommoditiesID() != null) {
			if (!po.getCommoditiesID().isEmpty()) {
				return ResultMessage.FAILURE;
			}
		}
		return commoditySortData.delete(ID);
	}

	/**
	 * 更新商品分类的信息，主要是更新名字。
	 * @param ID 原有商品分类的ID
	 * @param name 更改的名称
	 * @return
	 * @author Zing
	 * @version Dec 1, 2014 7:33:34 PM
	 */
	public ResultMessage updCommoSort(String ID, String name) {
		CommoditySortPO beforePO = commoditySortData.find(ID);
		String fatherID = beforePO.getFatherID();
		ArrayList<String> childrenID = beforePO.getChildrenID();
		ArrayList<String> commoditiesID = beforePO.getCommoditiesID();
		po = new CommoditySortPO(ID, name, fatherID, childrenID, commoditiesID);
		return commoditySortData.update(po);
	}

	/**
	 * 将一个PO转换成VO返回
	 * @param po
	 * @return
	 * @author Zing
	 * @version Dec 1, 2014 7:47:55 PM
	 */
	private CommoditySortVO POtoVO(CommoditySortPO po) {
		String ID = po.getID();
		String name = po.getName();
		String fatherID = po.getFatherID();
		ArrayList<String> childrenID = po.getChildrenID();
		ArrayList<String> commoditiesID = po.getCommoditiesID();
		CommoditySortVO vo = new CommoditySortVO(ID, name, fatherID, childrenID, commoditiesID);
		return vo;
	}

	public CommoditySortDataService getCommoditySortData() {
		return commoditySortData;
	}

}
