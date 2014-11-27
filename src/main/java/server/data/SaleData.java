package server.data;

import message.ResultMessage;
import po.SalesPO;
import dataenum.BillType;
import dataservice.SaleDataService;

/**
 * @see dataservice.SaleDataService
 * @author cylong
 * @version 2014年11月27日 下午7:53:50
 */
public class SaleData implements SaleDataService {

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
	 * @see dataservice.SaleDataService#insert(po.SalesPO)
	 */
	@Override
	public ResultMessage insert(SalesPO po) {
		return null;
	}

	/**
	 * @see dataservice.SaleDataService#find(java.lang.String)
	 */
	@Override
	public SalesPO find(String ID) {
		return null;
	}

	/**
	 * @see dataservice.SaleDataService#delete(java.lang.String)
	 */
	@Override
	public ResultMessage delete(String ID) {
		return null;
	}

	/**
	 * @see dataservice.SaleDataService#update(po.SalesPO)
	 */
	@Override
	public ResultMessage update(SalesPO po) {
		return null;
	}

	/**
	 * @see dataservice.SaleDataService#getID(dataenum.BillType)
	 */
	@Override
	public String getID(BillType type) {
		return null;
	}

	/**
	 * @see dataservice.SaleDataService#save(po.SalesPO)
	 */
	@Override
	public ResultMessage save(SalesPO po) {
		return null;
	}

}
