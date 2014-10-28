package businesslogicservice;

import po.DocumentPO;
import vo.ClientVO;
import vo.CommodityVO;
import vo.UserVO;
import dataenum.Date;
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
	 * @param begin
	 * @param end
	 * @param commodity
	 * @param client
	 * @param user
	 * @param Storage
	 * @return
	 */
	public ResultMessage saleDetail(Date begin, Date end, CommodityVO commodity, ClientVO client, UserVO user, Storage Storage);
	
	/**
	 * 制定经营历程表
	 * @param begin
	 * @param end
	 * @param kind
	 * @param client
	 * @param user
	 * @param storage
	 * @return
	 */
	public ResultMessage bussinessPro(Date begin, Date end, String kind, ClientVO client, UserVO user, Storage storage);
	
	/**
	 * 添加红冲
	 * @param record
	 * @return
	 */
	
	public ResultMessage red(DocumentPO document);
	
	/**
	 * 修改红冲
	 * @param record
	 * @return
	 */
	
	public ResultMessage copyRed(DocumentPO document);
	/**
	 * 制定经营情况表
	 * @param begin
	 * @param end
	 * @param kind
	 * @return
	 */
	public ResultMessage businessState(Date begin, Date end, String kind);
	
	/**
	 * 计算得到的收入
	 * @return
	 */
	public ResultMessage earning();
	
	/**
	 * 计算支出
	 * @return
	 */
	public ResultMessage expense();

}
