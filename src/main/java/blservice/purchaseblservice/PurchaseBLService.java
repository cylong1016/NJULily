package blservice.purchaseblservice;

import java.util.ArrayList;

import dataenum.Storage;
import vo.PurchaseVO;
import message.ResultMessage;

/**
 * 负责实现进货界面所需要的服务
 * @author cylong
 * @version Oct 26, 2014 3:11:13 PM
 */
/**
 * 
 * @author Zing
 * @version 2014年10月31日下午4:36:47
 */
public interface PurchaseBLService {
	
	/**
	 * 添加商品到进货单
	 * @param name
	 * @param num
	 * @param price
	 * @param remark
	 */
	public void addCommodities(String name,  int num, double price,  String remark);

	/**
	 * 添加进货单
	 * @param ID
	 * @param client
	 * @param user
	 * @param storage
	 * @param commodities
	 * @param sumPrice
	 * @param remark
	 * @return
	 */
	public ResultMessage addPur(String ID, String client, String user,  
			Storage storage, double sumPrice, String remark);
	
	/**
	 * 添加进货退货单
	 * @param ID
	 * @param client
	 * @param saleman
	 * @param user
	 * @param storage
	 * @param commodities
	 * @param sumPrice
	 * @return
	 */
	public ResultMessage addPurBack(String ID, String client, String user, 
			Storage storage, double sumPrice, String remark);
	
	/**
	 * 提交单据进行审核
	 * @return
	 */
	public ResultMessage submit();
	
	public ArrayList<PurchaseVO> show();

}
