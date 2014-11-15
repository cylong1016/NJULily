package businesslogicservice;


import dataenum.Storage;
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
	public void addCommodities(String name,  int num, int price,  String remark);
	
	/**
	 * 得到商品折让后的价格
	 * @param beforePrice
	 * @param allowance
	 * @param voucher
	 * @return
	 */
	public double getAfterPrice(double beforePrice, double allowance, double voucher);


	/**
	 * 制定出新的销售单
	 * @param client
	 * @param saleman
	 * @param user
	 * @param storage
	 * @param allowance
	 * @param voucher
	 * @param remark
	 * @return
	 */
	public ResultMessage addSale(String client, String salesman,
			String user, Storage storage, double allowance, double voucher, String remark);
	
	/**
	 * 制定出新的销售退货单
	 * @param client
	 * @param saleman
	 * @param user
	 * @param storage
	 * @param allowance
	 * @param voucher
	 * @param remark
	 * @return
	 */
	public ResultMessage addSaleBack(String client,String salesman, String user, 
			Storage storage, double allowance, double voucher, String remark);
	/**
	 * 单据提交发送
	 * @return
	 */
	public ResultMessage submit();


}
