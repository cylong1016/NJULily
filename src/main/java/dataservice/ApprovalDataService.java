package dataservice;

import java.util.ArrayList;

import message.ResultMessage;
import po.PersistentObject;

/**
 * 提供需要审批的单据的集体载入、保存、查看修改操作
 * @author cylong
 * @version Oct 26, 2014 3:51:31 PM
 */
public interface ApprovalDataService extends DataService {

	/**
	 * 更新账单的状态
	 * @param po
	 * @return 处理结果
	 */
	public ResultMessage update(PersistentObject po);

	/**
	 * 添加一个需要审批的单据
	 * @param po 需要审批的单据
	 * @return 处理信息
	 * @author cylong
	 * @version Nov 15, 2014 2:54:57 PM
	 */
	public ResultMessage insert(PersistentObject po);

	/**
	 * 审批过后删除这个单子
	 * @param po
	 * @return 处理信息
	 * @author cylong
	 * @version Nov 15, 2014 3:02:38 PM
	 */
	public ResultMessage delete(PersistentObject po);

	/**
	 * @return 全部需要审批的单据
	 * @author cylong
	 * @version Nov 15, 2014 2:55:31 PM
	 */
	public ArrayList<PersistentObject> getAllBills();

}
