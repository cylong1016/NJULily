package dataservice;

import message.ResultMessage;
import po.PersistentObject;

/**
 * 提供单据的集体载入、保存、查看修改操作
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

}
