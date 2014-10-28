package businesslogicservice;

import java.util.ArrayList;

import vo.CommodityVO;
import message.ResultMessage;

/**
 * 负责实现进货界面所需要的服务
 * @author cylong
 * @version Oct 26, 2014 3:11:13 PM
 */
/**
 * 
 * @author Zing
 * @version 2014年10月28日下午5:28:55
 */
public interface PurchaseBLService {
	
	/**
	 * 制定进货单
	 * @param commodity
	 * @param num
	 * @param price
	 * @param remark
	 * @return
	 */
	public ResultMessage addPur(ArrayList<CommodityVO> commodities,  int num, int price,  String remark);
	
	/**
	 * 制定进货退货单
	 * @param commodity
	 * @param num
	 * @param price
	 * @param remark
	 * @return
	 */
	public ResultMessage addPurBack(ArrayList<CommodityVO> commodities,int num, int price,  String remark);
	
	/**
	 * 
	 * @return
	 */
	public ResultMessage submit();


}
