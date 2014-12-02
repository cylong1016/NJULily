package blservice.approvalblservice;

import java.util.ArrayList;

import dataenum.BillType;
import vo.ApprovalVO;
import vo.ValueObject;
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
/**
 * 审批接口
 * @author Zing
 * @version Dec 1, 2014 11:02:26 PM
 */
public interface ApprovalBLService {
		
	/**
	 * 查看单据内容
	 * @param record
	 * @return
	 */
	public ApprovalVO show();
	
	/**
	 * 修改单据内容
	 * @return
	 */
	public ResultMessage updateBill(ValueObject vo, BillType billType);
	
	/**
	 * 确认单据内容没有错误
	 * @return
	 */
	public ResultMessage passBill(ArrayList<ValueObject> VOs, ArrayList<BillType> billTypes);

}
