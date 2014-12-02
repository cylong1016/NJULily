package dataservice.accountbilldataservice;

import java.util.ArrayList;

import po.AccountBillPO;
import dataenum.BillType;
import dataservice.CommonDataService;
import dataservice.TableInfoService;

/**
 * 收款单、付款单、现金单的集体载入、保存、查看修改操作
 * @author cylong
 * @version Oct 26, 2014 3:51:07 PM
 */
public interface AccountBillDataService extends CommonDataService<AccountBillPO> {

	/**
	 * 根据单据类型生成编号
	 * @param type 收款单或者付款单
	 * @return 可用的单据编号 ；若为null则传入类型错误
	 * @author cylong
	 * @version 2014年11月30日 下午10:54:18
	 */
	public String getID(BillType type);

	/**
	 * 按照单据类型返回单据【收款单或者付款单】
	 * @param type
	 * @return
	 * @author cylong
	 * @version 2014年12月1日 下午3:13:56
	 */
	public ArrayList<AccountBillPO> show(BillType type);

	/**
	 * @return AccountBillInfoService 的实例
	 * @author cylong
	 * @version 2014年12月2日 上午2:42:37
	 */
	public TableInfoService<AccountBillPO> getInfo();
}
