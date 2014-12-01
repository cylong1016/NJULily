package server.data.cashbilldata;

import po.CashBillPO;
import server.data.CommonData;
import dataservice.cashbilldataservice.CashBillDataService;
import dataservice.cashbilldataservice.CashBillInfoService;

/**
 * dataservice.cashbilldataservice.CashBillDataService
 * @author cylong
 * @version 2014年12月1日 下午4:19:54
 */
public class CashBillData extends CommonData<CashBillPO> implements CashBillDataService {

	/**
	 * @see dataservice.DataService#init()
	 */
	@Override
	public void init() {
	}

	/**
	 * @see dataservice.cashbilldataservice.CashBillDataService#getInfo()
	 */
	@Override
	public CashBillInfoService getInfo() {
		return null;
	}

}
