package businesslogicservice;

import java.util.ArrayList;

import vo.CommodityVO;
import message.ResultMessage;

/**
 * 负责实现销售界面所需要的服务
 * @author cylong
 * @version Oct 26, 2014 3:13:51 PM
 */
/**
 * 
 * @author Zing
 * @version 2014年10月28日下午5:31:15
 */
public interface SaleBLService {
	
	/**
	 * 制定出新的销售单
	 * @param commodities
	 * @param num
	 * @param price
	 * @param remark
	 * @return
	 */
	public ResultMessage addSale(ArrayList<CommodityVO> commodities,  int num, int price,  String remark);
	
	/**
	 * 制定出新的销售退货单
	 * @param commodity
	 * @param num
	 * @param price
	 * @return
	 */
	public ResultMessage addSaleBack(ArrayList<CommodityVO> commodities,  int num, int price,  String remark);
	
	/**
	 * 单据提交发送
	 * @return
	 */
	public ResultMessage submit();


}
