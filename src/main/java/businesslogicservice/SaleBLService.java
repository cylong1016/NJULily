package businesslogicservice;

import java.util.ArrayList;

import dataenum.Storage;
import vo.ClientVO;
import vo.SaleCommodityItemVO;
import vo.UserVO;
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
	 * 添加商品到商品清单
	 * @param name
	 * @param num
	 * @param price
	 * @param remark
	 * @return
	 */
	public ResultMessage addCommodities(String name,  int num, int price,  String remark);
	
	
	/**
	 * 添加得到所有商品的总价（折让前）
	 * @param commodities
	 * @return
	 */
	public ResultMessage getBeforePrice(ArrayList<SaleCommodityItemVO> commodities);
	
	/**
	 * 得到商品折让后的价格
	 * @param beforePrice
	 * @param allowance
	 * @param voucher
	 * @return
	 */
	public ResultMessage getAfterPrice(int beforePrice, int allowance, int voucher);


	/**
	 * 制定出新的销售单
	 * @param ID
	 * @param client
	 * @param saleman
	 * @param user
	 * @param storage
	 * @param commodities
	 * @param beforePrice
	 * @param allowance
	 * @param voucher
	 * @param remark
	 * @param afterPrice
	 * @return
	 */
	public ResultMessage addSale(String ID, ClientVO client, UserVO salesman, UserVO user,  Storage storage, 
			ArrayList<SaleCommodityItemVO> commodities, int beforePrice, int allowance, 
			int voucher, String remark , int afterPrice);
	
	/**
	 * 制定出新的销售退货单
	 * @param ID
	 * @param client
	 * @param saleman
	 * @param user
	 * @param storage
	 * @param commodities
	 * @param beforePrice
	 * @param allowance
	 * @param voucher
	 * @param afterPrice
	 * @param remark
	 * @return
	 */
	public ResultMessage addSaleBack(String ID, ClientVO client, UserVO salesman, UserVO user,  Storage storage,
			ArrayList<SaleCommodityItemVO> commodities, int beforePrice, int allowance, 
			int voucher, int afterPrice, String remark);
	/**
	 * 单据提交发送
	 * @return
	 */
	public ResultMessage submit();


}
