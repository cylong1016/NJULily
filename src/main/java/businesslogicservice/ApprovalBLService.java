package businesslogicservice;

import po.PersistentObject;
import message.ResultMessage;


/**
 * 负责实现审批界面所需要的服务
 * @author cylong
 * @version Oct 26, 2014 3:17:39 PM
 */
/**
 * 
 * @author Zing
 * @version 2014年10月28日下午7:43:52
 */
public interface ApprovalBLService {
	
	/**
	 * 查看单据内容
	 * @param record
	 * @return
	 */
	public ResultMessage checkRecord(PersistentObject record);
	
	/**
	 * 修改单据内容
	 * @return
	 */
	public ResultMessage updRecord();
	
	/**
	 * 确认单据内容没有错误
	 * @return
	 */
	public ResultMessage submitRecord();

}
