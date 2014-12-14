package dataservice.cashbilldataservice;

import po.CashBillPO;
import dataservice.TableInfoService;

/**
 * @see dataservice.TableInfoService
 * @author cylong
 * @version 2014年12月14日 上午7:28:02
 */
public interface CashBillInfoService extends TableInfoService<CashBillPO> {

	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "CashBillInfo";

}
