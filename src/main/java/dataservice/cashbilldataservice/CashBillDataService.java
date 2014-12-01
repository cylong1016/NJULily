package dataservice.cashbilldataservice;

import po.CashBillPO;
import dataservice.CommonDataService;

public interface CashBillDataService extends CommonDataService<CashBillPO> {

	/**
	 * @return CashBillInfoService 的实例
	 * @author cylong
	 * @version 2014年12月2日 上午2:45:35
	 */
	public CashBillInfoService getInfo();
}
