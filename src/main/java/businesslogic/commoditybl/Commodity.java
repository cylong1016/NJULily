package businesslogic.commoditybl;

import java.rmi.Naming;
import java.util.ArrayList;

import config.RMI;
import message.ResultMessage;
import po.CommodityPO;
import po.CommoditySortPO;
import vo.CommodityVO;
import blservice.commodityblservice.CommodityInputInfo;
import dataenum.FindTypeCommo;
import dataservice.DataFactoryService;
import dataservice.commoditydataservice.CommodityDataService;
import dataservice.commoditysortdataservice.CommoditySortDataService;
/**
 * 商品管理
 * @author Zing
 * @version 2014年11月9日下午2:53:19
 */
public class Commodity {
	
	private CommodityDataService commodityData;
	
	private CommoditySortDataService commoditySortData;
	
	private CommodityPO po;
	
	private String ID;
	
	public Commodity() {
		try {
			DataFactoryService factory = (DataFactoryService)Naming.lookup(RMI.URL);
			commodityData = factory.getCommodityData();
			commoditySortData = factory.getCommoditySortData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param sortID
	 * @return
	 * @author Zing
	 * @version Dec 1, 2014 9:16:41 PM
	 */
	public String getID(String sortID){
		ID = commodityData.getID(sortID);
		return ID;
	}
	
	/**
	 * 返回所有的商品
	 * @return
	 * @author Zing
	 * @version Dec 1, 2014 9:16:44 PM
	 */
	public ArrayList<CommodityVO> show() {
		ArrayList<CommodityVO> VOs = new ArrayList<CommodityVO>();
		ArrayList<String> IDs = commodityData.getAllID();
		for (String ID : IDs) {
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
	 */
	public CommodityVO show(String ID) {
		CommodityPO po = commodityData.find(ID);
		CommodityVO vo = POToVO(po);
		return vo;
	}
	
	/**
	 * 添加商品
	 * @param info
	 * @return
	 * @author Zing
	 * @version Dec 1, 2014 8:57:15 PM
	 */
	public ResultMessage addCommo(CommodityInputInfo info) {
		po = new CommodityPO(ID, info.name, info.sortID, info.type, info.purPrice, info.salePrice, 0);
		ResultMessage result = commodityData.insert(po);
		if (result != ResultMessage.SUCCESS) {
			return result;
		}
		// 如果添加成功，更新商品分类的信息
		CommoditySortPO sortPO = commoditySortData.find(info.sortID);
		sortPO.addCommodityID(ID);
		commoditySortData.update(sortPO);
		return result;
	}
	
	/**
	 * 删除商品（只有没有被操作过才可以）
	 * @param id
	 * @return
	 * @author Zing
	 * @version Dec 1, 2014 8:57:57 PM
	 */
	public ResultMessage deletCommo(String ID) {
		double purPrice = commodityData.find(ID).getPurPrice();
		if (purPrice == 0) {
			return ResultMessage.FAILURE;
		}
		// 如果可以删除该商品，就顺便删除分类中的该商品
		String sortID = commodityData.find(ID).getSortID();
		CommoditySortPO sortPO = commoditySortData.find(sortID);
		sortPO.removeCommodity(ID);
		commoditySortData.update(sortPO);
		return commodityData.delete(ID);
	}
	
	/**
	 * 更新商品信息
	 * @param ID
	 * @param info
	 * @return
	 * @author Zing
	 * @version Dec 1, 2014 9:32:00 PM
	 */
	public ResultMessage updCommo(String ID, CommodityInputInfo info){
		po = new CommodityPO(ID, info.name, info.sortID, info.type, info.purPrice, info.salePrice, info.alarmNumber);	
		return commodityData.update(po);
	}
	
	/**
	 * 返回符合查找条件的商品VO集合
	 * @param info
	 * @param type
	 * @return
	 * @author Zing
	 * @version Dec 1, 2014 9:30:58 PM
	 */
	public ArrayList<CommodityVO> findCommo(String info, FindTypeCommo type) {
		ArrayList<CommodityVO> VOs = new ArrayList<CommodityVO>();
		ArrayList<CommodityPO> POs = commodityData.find(info, type);
		for (CommodityPO po : POs) {
			CommodityVO vo = POToVO(po);
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
	 */
	public ResultMessage setAlarm(ArrayList<String> IDs, int alarmNumber) {
		// 如果选择更改的商品现在数量少于设置的警戒数量，返回false
		for (String ID : IDs) {
			CommodityPO po = commodityData.find(ID);
			if (po.getInventoryNum() < alarmNumber) {
				return ResultMessage.FAILURE;
			}
		}
		for (String ID : IDs) {
			CommodityPO po = commodityData.find(ID);
			po.setAlarmNumber(alarmNumber);
			commodityData.update(po);
		}
		return ResultMessage.SUCCESS;
	}
	
	public CommodityDataService getCommodityData() {
		return this.commodityData;
	}
	
	/**
	 * 把一个商品PO转换成VO
	 * @param po
	 * @return 一个商品VO
	 * @author Zing
	 * @version Dec 1, 2014 9:33:15 PM
	 */
	private CommodityVO POToVO(CommodityPO po) {
		String ID = po.getID();
		String name = po.getName();
		String type = po.getType();
		String sortID = po.getSortID();
		int inventoryNum = po.getInventoryNum();
		double purPrice = po.getPurPrice();
		double salePrice = po.getSalePrice();
		double recentPurpPrice = po.getRecentPurPrice();
		double recentSalePrice = po.getRecentSalePrice();
		int alarmNumber = po.getAlarmNumber();
		CommodityVO vo = new CommodityVO(ID, name, type, sortID, inventoryNum,
				purPrice, salePrice, recentPurpPrice, recentSalePrice,
				alarmNumber);
		return vo;
	}

}
