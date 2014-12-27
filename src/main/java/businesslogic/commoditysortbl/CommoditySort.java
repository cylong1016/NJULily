package businesslogic.commoditysortbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CommoditySortPO;
import vo.commodity.CommoditySortVO;
import config.RMIConfig;
import dataenum.ResultMessage;
import dataservice.commoditysortdataservice.CommoditySortDataService;

public class CommoditySort {

	private CommoditySortDataService commoditySortData;

	private String ID;

	private CommoditySortPO po;

	public CommoditySort() {
		try {
			commoditySortData = (CommoditySortDataService)Naming.lookup(RMIConfig.PREFIX
																		+ CommoditySortDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	public String getID(String fatherID) throws RemoteException {
		this.ID = commoditySortData.getID(fatherID);
		return ID;
	}

	/**
	 * 得到商品分类的所有东西
	 * @return
	 * @author Zing
	 * @version Dec 1, 2014 7:37:48 PM
	 * @throws RemoteException
	 */
	public ArrayList<CommoditySortVO> show() throws RemoteException {
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
	 * @throws RemoteException
	 */
	public CommoditySortVO show(String ID) throws RemoteException {
		CommoditySortPO po = commoditySortData.find(ID);
		return POtoVO(po);
	}

	/**
	 * 添加商品分类
	 * @param sortName
	 * @param parentSort
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage addCommoSort(String sortName, String fatherID) throws RemoteException {
		
		// TODO 请jsw自己更改一下，从界面直接调用这个方法
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
	 * @throws RemoteException
	 */
	public ResultMessage deleteCommoSort(String ID) throws RemoteException {
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
	 * @throws RemoteException
	 */
	public ResultMessage updCommoSort(String ID, String name) throws RemoteException {
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
