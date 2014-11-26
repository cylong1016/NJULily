package server.data;

import message.ResultMessage;
import po.CommoditySortPO;
import server.io.DefineList;
import dataservice.CommoditySortDataService;

/**
 * @see dataservice.CommoditySortDataService
 * @author cylong
 * @version 2014年11月26日 下午3:21:10
 */
public class CommoditySortData implements CommoditySortDataService {

	private DefineList<CommoditySortPO> clientList;
	private String filePath;
	private String initID;

	public CommoditySortData() {
		
	}
	/**
	 * @see dataservice.DataService#init()
	 */
	@Override
	public void init() {
	}

	/**
	 * @see dataservice.DataService#getID()
	 */
	@Override
	public String getID() {
		return null;
	}

	/**
	 * @see dataservice.CommoditySortDataService#insert(po.CommoditySortPO)
	 */
	@Override
	public ResultMessage insert(CommoditySortPO po) {
		return null;
	}

	/**
	 * @see dataservice.CommoditySortDataService#find(java.lang.String)
	 */
	@Override
	public CommoditySortPO find(String name) {
		return null;
	}

	/**
	 * @see dataservice.CommoditySortDataService#delete(java.lang.String)
	 */
	@Override
	public ResultMessage delete(String ID) {
		return null;
	}

	/**
	 * @see dataservice.CommoditySortDataService#update(po.CommoditySortPO)
	 */
	@Override
	public ResultMessage update(CommoditySortPO po) {
		return null;
	}

}
