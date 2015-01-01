package dataservice.accountbilldataservice;

import po.AccountBillPO;
import dataservice.TableInfoService;

/**
 * @see dataservice.TableInfoService
 * @author cylong
 * @version 2014年12月14日 上午7:24:58
 */
public interface AccountBillInfoService extends TableInfoService<AccountBillPO> {

	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "AccountBillInfo";

}
