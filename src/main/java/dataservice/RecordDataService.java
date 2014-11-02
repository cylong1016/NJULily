package dataservice;

import java.util.ArrayList;

import po.PersistentObject;

/**
 * 提供销售明细表、经营历程表、经营情况表的查看
 * @author cylong
 * @version Oct 26, 2014 3:50:39 PM
 */
public interface RecordDataService extends DataService {

	/**
	 * 查看销售明细表
	 * @param item
	 * @return 满足需求的账单
	 */
	public ArrayList<PersistentObject> getSaleDetail(String item);

	/**
	 * 查看经营历程表
	 * @param item
	 * @return 满足需求的账单
	 */
	public ArrayList<PersistentObject> getBusinessProcess(String item);

	/**
	 * 查看经营情况表
	 * @param item
	 * @return 满足需求的账单
	 */
	public ArrayList<PersistentObject> getBusinessCondition(String item);

}
