package server.data;

import java.util.ArrayList;

import po.SalesPO;
import dataenum.BillType;
import dataservice.SaleDataService;

/**
 * @see dataservice.SaleDataService
 * @author cylong
 * @version 2014年11月27日 下午7:53:50
 */
public class SaleData extends CommonData<SalesPO> implements SaleDataService {

	/**
	 * @see dataservice.DataService#init()
	 */
	@Override
	public void init() {
	}

	/**
	 * @see dataservice.SaleDataService#getID(dataenum.BillType)
	 */
	@Override
	public String getID(BillType type) {
		return null;
	}

	/**
	 * @see dataservice.SaleDataService#getAllID(dataenum.BillType)
	 */
	@Override
	public ArrayList<String> getAllID(BillType type) {
		return null;
	}

}
