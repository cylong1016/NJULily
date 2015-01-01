package dataservice.cashbilldataservice;

import po.CashBillPO;
import dataservice.CommonDataService;

public interface CashBillDataService extends CommonDataService<CashBillPO> {

	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "CashBillData";
	
}
