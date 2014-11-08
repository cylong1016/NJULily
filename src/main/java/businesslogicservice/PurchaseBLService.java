package businesslogicservice;

import java.util.ArrayList;

import dataenum.Storage;
import vo.ClientVO;
import vo.SaleCommodityItemVO;
import vo.UserVO;
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
	 * 得到进货单的编号
	 * @return
	 */
	public ResultMessage getID ();
	
	/**
	 * 添加商品到进货单
	 * @param name
	 * @param num
	 * @param price
	 * @param remark
	 * @return
	 */
	public ResultMessage addCommodities(String name,  int num, int price,  String remark);
	
	/**
	 * 得到商品总价
	 * @param commodities
	 * @return
	 */
	public ResultMessage getBeforePrice(ArrayList<SaleCommodityItemVO> commodities);

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
	public ResultMessage addSale(String ID, ClientVO client, UserVO user,  Storage storage, 
			ArrayList<SaleCommodityItemVO> commodities, int sumPrice, String remark);
	
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
	public ResultMessage addSaleBack(String ID, ClientVO client, UserVO user,  Storage storage, 
			ArrayList<SaleCommodityItemVO> commodities, int sumPrice);
	
	/**
	 * 提交单据进行审核
	 * @return
	 */
	public ResultMessage submit();


}
