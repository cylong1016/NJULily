package dataservice.purchasedataservice;

import po.PurchasePO;
import dataservice.TableInfoService;

/**
 * @see dataservice.TableInfoService
 * @author cylong
 * @version 2014年12月14日 上午7:32:21
 */
public interface PurchaseInfoService extends TableInfoService<PurchasePO> {

	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "PurchaseInfo";

}
