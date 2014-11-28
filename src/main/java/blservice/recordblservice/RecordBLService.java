package blservice.recordblservice;

import vo.ValueObject;
import dataenum.BillType;
import dataenum.Storage;
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
	 * 销售明细表
	 * 统计一段时间内商品的销售情况（应该就是查询销售出货单据记录）
	 * 筛选条件有：时间区间，商品名，客户，业务员，仓库。
	 * 显示符合上述条件的商品销售记录，以列表形式显示，
	 * 列表中包含如下信息：时间（精确到天），商品名，型号，数量，单价，总额。
	 * 需要支持导出数据。
	 * @param begin
	 * @param end
	 * @param commodity
	 * @param client
	 * @param salesman
	 * @param Storage
	 * @return
	 */
	public ResultMessage saleDetail(String begin, String end, String commodity, 
			String client, String salesman, Storage Storage);
	
	/**
	 * 制定经营历程表
	 * 
	 * @param begin
	 * @param end
	 * @param billType
	 * @param client
	 * @param salesman
	 * @param storage
	 * @return
	 */
	public ResultMessage bussinessPro(String begin, String end, BillType billType, 
			String client, String salesman, Storage storage);
	
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
	public ResultMessage businessState(String begin, String end);
}
