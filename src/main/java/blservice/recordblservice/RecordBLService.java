package blservice.recordblservice;

import java.util.ArrayList;

import vo.BusinessStateVO;
import vo.SaleDetailVO;
import vo.ValueObject;
import message.ResultMessage;

/**
 * 负责实现查看表单界面所需要的服务
 * @author cylong
 * @version Oct 26, 2014 3:15:07 PM
 */
/**
 * 
 * @author Zing
 * @version 2014年10月28日下午5:32:16
 */
public interface RecordBLService {
	
	/**
	 * 制定销售明细表
	 * @param info
	 * @return
	 * @author Zing
	 * @version Nov 30, 2014 10:26:24 AM
	 */
	public ArrayList<SaleDetailVO> saleDetail(RecordInputInfo info);
	
	/**
	 * 制定经营历程表
	 * @param info
	 * @return
	 * @author Zing
	 * @version Nov 30, 2014 10:26:12 AM
	 */
	public ArrayList<ValueObject> bussinessPro(RecordInputInfo info);
	
	/**
	 * 添加红冲
	 * @param record
	 * @return
	 */
	
	public ResultMessage red(ValueObject valueRecord);
	
	/**
	 * 修改红冲
	 * @param record
	 * @return
	 */
	
	public ResultMessage copyRed(ValueObject valueRecord);
	/**
	 * 制定经营情况表
	 * @param begin
	 * @param end
	 * @param kind
	 * @return
	 */
	public BusinessStateVO businessState(RecordInputInfo info);
}
