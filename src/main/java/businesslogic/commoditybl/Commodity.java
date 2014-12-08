package businesslogic.commoditybl;

import java.util.ArrayList;

import message.ResultMessage;
import po.CommodityPO;
import server.data.commoditydata.CommodityData;
import vo.commodity.CommodityAddVO;
import vo.commodity.CommodityVO;
import blservice.commodityblservice.CommodityBLService;
import businesslogic.commoditysortbl.CommoditySortInfo;
import dataenum.FindTypeCommo;
import dataservice.commoditydataservice.CommodityDataService;
/**
 * 商品管理
 * @author Zing
 * @version 2014年11月9日下午2:53:19
 */
public class Commodity implements CommodityBLService{
	
	private CommodityDataService commodityData;
	
	private CommodityPO po;
	
	private String ID;
	
	private CommodityTrans transPOVO;
	
	public Commodity() {
//		try {
//			DataFactoryService factory = (DataFactoryService)Naming.lookup(RMI.URL);
//			commodityData = factory.getCommodityData();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		// TODO 本地新建
		commodityData = new CommodityData();
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
	 */
	public ResultMessage addCommo(CommodityAddVO info) {
		po = new CommodityPO(ID, info.name, info.sortID, info.type, info.purPrice, info.salePrice, 0);
		CommoditySort_Commodity sort = new CommoditySortInfo();
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
	 */
	public ResultMessage deletCommo(String ID) {
		double purPrice = commodityData.find(ID).getPurPrice();
		if (purPrice != 0) {
			return ResultMessage.FAILURE;
		}
		// 如果可以删除该商品，就顺便删除分类中的该商品
		CommoditySort_Commodity info = new CommoditySortInfo();
		String sortID = commodityData.find(ID).getSortID();
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
	 */
	public ResultMessage updCommo(CommodityAddVO info){
		CommodityPO oldPO = commodityData.find(info.ID);
		po = new CommodityPO(info.ID, info.name, info.sortID, info.type, info.purPrice, info.salePrice, oldPO.getAlarmNumber());	
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
		transPOVO = new CommodityTrans();
		ArrayList<CommodityVO> VOs = new ArrayList<CommodityVO>();
		ArrayList<CommodityPO> POs = commodityData.find(info, type);
		for (CommodityPO po : POs) {
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

}
