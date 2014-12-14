package dataservice.promotiondataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.PromotionPO;
import dataenum.PromotionType;
import dataservice.CommonDataService;

/**
 * 提供数据的保存、修改操作，保存最近卖得比较少的商品。或者组合同一种分类下的商品，进行组合赠送什么的
 * @author cylong
 * @version Oct 26, 2014 3:54:50 PM
 */
public interface PromotionDataService extends CommonDataService<PromotionPO> {

	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "PromotionData";

	/**
	 * 查看不同类型的促销策略
	 * @param type 促销类型
	 * @return ArrayList<PromotionVO>
	 * @author cylong
	 * @version 2014年12月4日 下午7:52:43
	 */
	public ArrayList<PromotionPO> show(PromotionType type) throws RemoteException;

}
