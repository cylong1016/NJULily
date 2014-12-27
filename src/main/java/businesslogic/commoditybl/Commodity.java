package businesslogic.commoditybl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CommodityPO;
import vo.commodity.CommodityAddVO;
import vo.commodity.CommodityUpdateVO;
import vo.commodity.CommodityVO;
import businesslogic.commoditysortbl.CommoditySortInfo;
import config.RMIConfig;
import dataenum.FindTypeCommo;
import dataenum.ResultMessage;
import dataservice.commoditydataservice.CommodityDataService;

/**
 * 商品管理
 * @author Zing
 * @version 2014年11月9日下午2:53:19
 */
public class Commodity {

	private CommodityDataService commodityData;

	private CommodityPO po;

	private String ID;

	private CommodityTrans transPOVO;

	public Commodity() {
		try {
			commodityData = (CommodityDataService)Naming.lookup(RMIConfig.PREFIX + CommodityDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param sortID
	 * @return
	 * @author Zing
	 * @version Dec 1, 2014 9:16:41 PM
	 * @throws RemoteException
	 */
	public String getID(String sortID) throws RemoteException {
		ID = commodityData.getID(sortID);
		return ID;
	}

	/**
	 * 返回所有的商品
	 * @return
	 * @author Zing
	 * @version Dec 1, 2014 9:16:44 PM
	 * @throws RemoteException
	 */
	public ArrayList<CommodityVO> show() throws RemoteException {
		ArrayList<CommodityVO> VOs = new ArrayList<CommodityVO>();
		ArrayList<String> IDs = commodityData.getAllID();
		for(String ID : IDs) {
			CommodityVO vo = show(ID);
			VOs.add(vo);
		}
		return VOs;
	}

	/**
	 * 根据ID返回商品VO
	 * @param ID
	 * @return
	 * @author Zing
	 * @version Dec 1, 2014 9:16:47 PM
	 * @throws RemoteException
	 */
	public CommodityVO show(String ID) throws RemoteException {
		transPOVO = new CommodityTrans();
		CommodityPO po = commodityData.find(ID);
		CommodityVO vo = transPOVO.POtoVO(po);
		return vo;
	}

	/**
	 * 添加商品
	 * @param info
	 * @return
	 * @author Zing
	 * @version Dec 1, 2014 8:57:15 PM
	 * @throws RemoteException
	 */
	public ResultMessage addCommo(CommodityAddVO info) throws RemoteException {
		CommoditySort_Commodity sort = new CommoditySortInfo();
		po = new CommodityPO(ID, info.name, info.sortID, info.type, info.purPrice, info.salePrice, 0);
		if (sort.hasLeaf(info.sortID)) {
			return ResultMessage.FAILURE;
		}
		// 如果添加成功，更新商品分类的信息
		sort.addCommodity(info.sortID, ID);
		return commodityData.insert(po);
	}

	/**
	 * 删除商品（只有没有被操作过才可以）
	 * @param id
	 * @return
	 * @author Zing
	 * @version Dec 1, 2014 8:57:57 PM
	 * @throws RemoteException
	 */
	public ResultMessage deletCommo(String ID) throws RemoteException {
		double recentPurPrice = commodityData.find(ID).getRecentPurPrice();
		boolean canDelete = commodityData.find(ID).isCanDelete();
		if (recentPurPrice != 0) {
			return ResultMessage.FAILURE;
		}
		if (!canDelete) {
			return ResultMessage.FAILURE;
		}
		// 如果可以删除该商品，就顺便删除分类中的该商品
		String sortID = commodityData.find(ID).getSortID();
		CommoditySort_Commodity info = new CommoditySortInfo();
		info.deleteCommodity(sortID, ID);
		return commodityData.delete(ID);
	}

	/**
	 * 更新商品信息
	 * @param ID
	 * @param info
	 * @return
	 * @author Zing
	 * @version Dec 1, 2014 9:32:00 PM
	 * @throws RemoteException
	 */
	public ResultMessage updCommo(String ID, CommodityUpdateVO info) throws RemoteException {
		CommodityPO oldPO = commodityData.find(ID);
		po = new CommodityPO(ID, info.name, oldPO.getSortID(), info.type, info.purPrice, info.salePrice, oldPO.getAlarmNumber());
		return commodityData.update(po);
	}

	/**
	 * 返回符合查找条件的商品VO集合
	 * @param info
	 * @param type
	 * @return
	 * @author Zing
	 * @version Dec 1, 2014 9:30:58 PM
	 * @throws RemoteException
	 */
	public ArrayList<CommodityVO> findCommo(String info, FindTypeCommo type) throws RemoteException {
		transPOVO = new CommodityTrans();
		ArrayList<CommodityVO> VOs = new ArrayList<CommodityVO>();
		ArrayList<CommodityPO> POs = commodityData.find(info, type);
		for(CommodityPO po : POs) {
			CommodityVO vo = transPOVO.POtoVO(po);
			VOs.add(vo);
		}
		return VOs;
	}

	/**
	 * 设置某些商品的警戒数量
	 * @param IDs 那些商品的ID
	 * @param alarmNumber 警戒数量
	 * @return
	 * @author Zing
	 * @version Dec 2, 2014 5:37:06 PM
	 * @throws RemoteException
	 */
	public ResultMessage setAlarm(ArrayList<String> IDs, int alarmNumber) throws RemoteException {
		// 如果选择更改的商品现在数量少于设置的警戒数量，返回false
		for(String ID : IDs) {
			CommodityPO po = commodityData.find(ID);
			if (po.getInventoryNum() < alarmNumber) {
				return ResultMessage.FAILURE;
			}
		}
		for(String ID : IDs) {
			CommodityPO po = commodityData.find(ID);
			po.setAlarmNumber(alarmNumber);
			commodityData.update(po);
		}
		return ResultMessage.SUCCESS;
	}

	public CommodityDataService getCommodityData() {
		return this.commodityData;
	}

}
