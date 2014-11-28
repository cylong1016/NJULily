package blservice.accountainitblservice;

import java.util.ArrayList;

import vo.AccountVO;
import vo.ClientVO;
import vo.CommoditySortVO;
import vo.CommodityVO;
import message.ResultMessage;

/**
 * 负责实现建账界面所需要的服务
 * @author cylong
 * @version Oct 26, 2014 3:16:58 PM
 */
/**
 * 这个系统是可以支持建多套账的，每套帐在新建的时候都要经过期初建账这一环节，可以理解为一套帐的初始化操作。
 * 包括：
 * 添加商品信息（商品分类，某一商品的名称，类别，型号，进价/售价(默认为上年平均)，最近进价和最近售价留空），
 * 客户信息（客户分类，某一个客户的名称，联系方式等，应收应付(之前遗留)），
 * 银行账户信息（名称，余额）。
 * 期初的信息一旦建立完毕就会单独存储起来，同时将此信息作为系统的启动初始状态。
 * 之后的一切操作将会改变系统里的信息，但不会改变期初信息。期初信息随时可查。
 * @author Zing
 * @version 2014年10月28日下午5:36:24
 */
public interface AccountainitBLService {
	// TODO 需要建立Accountainit里面的商品条目、客户条目、账户条目吗？？？？
	public ResultMessage addCommodity(CommoditySortVO sort, String name, String kind, String type);
	
	public ResultMessage addClient(String kind, String name, String phone);
	
	public ResultMessage addAccount(String name, int money);
	
	/**
	 * 建立
	 * @param commodities
	 * @param clients
	 * @param accounts
	 * @return
	 */
	public ResultMessage addInit(ArrayList<CommodityVO> commodities, ArrayList<ClientVO> clients, ArrayList<AccountVO> accounts);
	
	/**
	 * 返回上年的平均进价和售价
	 * @param time
	 * @param purPrice
	 * @param salePrice
	 * @return
	 */
	public ResultMessage getEverage(int time, double purPrice, double salePrice);


}
