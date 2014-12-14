package dataservice.saledataservice;

import po.SalesPO;
import dataservice.TableInfoService;

/**
 * @see dataservice.TableInfoService
 * @author cylong
 * @version 2014年12月14日 上午7:34:07
 */
public interface SaleInfoService extends TableInfoService<SalesPO> {

	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "SaleInfo";

}
