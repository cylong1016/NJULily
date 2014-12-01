package server.data.saledata;

import java.util.ArrayList;

import po.SalesPO;
import server.data.CommonData;
import dataenum.BillType;
import dataservice.TableInfoService;
import dataservice.saledataservice.SaleDataService;

/**
 * @see dataservice.saledataservice.SaleDataService
 * @author cylong
 * @version 2014年11月27日 下午7:53:50
 */
public class SaleData extends CommonData<SalesPO> implements SaleDataService, TableInfoService {

	/**
	 * @see dataservice.DataService#init()
	 */
	@Override
	public void init() {
	}

	/**
	 * @see dataservice.saledataservice.SaleDataService#getID(dataenum.BillType)
	 */
	@Override
	public String getID(BillType type) {
		return null;
	}

	/**
	 * @see dataservice.saledataservice.SaleDataService#getAllID(dataenum.BillType)
	 */
	@Override
	public ArrayList<String> getAllID(BillType type) {
		return null;
	}

}
