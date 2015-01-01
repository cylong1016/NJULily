package dataservice.commoditydataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CommodityPO;
import dataenum.FindTypeCommo;
import dataservice.CommonDataService;

/**
 * 提供商品集体载入、保存、增删改查服务
 * @author cylong
 * @version Oct 26, 2014 3:52:31 PM
 */
public interface CommodityDataService extends CommonDataService<CommodityPO> {

	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "CommodityData";

	/**
	 * 根据keywords查看商品，type是以什么方式查找，null是模糊查找
	 * @param keywords
	 * @return 商品持久化数据
	 */
	public ArrayList<CommodityPO> find(String keywords, FindTypeCommo type) throws RemoteException;

	/**
	 * @param fatherID 商品父类的ID
	 * @return 新建商品的ID
	 * @author cylong
	 * @version 2014年12月1日 下午9:20:35
	 */
	public String getID(String fatherID) throws RemoteException;

	/**
	 * @return 全部商品的ID
	 * @author cylong
	 * @version 2014年11月28日 下午12:28:46
	 */
	public ArrayList<String> getAllID() throws RemoteException;
}
