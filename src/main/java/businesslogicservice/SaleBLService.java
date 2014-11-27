package businesslogicservice;


import java.util.ArrayList;

import vo.SalesVO;
import dataenum.BillType;
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

	public ArrayList<SalesVO> show();
	
	public String getID(BillType type);

	/**
	 * 添加商品到商品清单
	 * @param ID
	 * @param num
	 * @param price
	 * @param remark
	 * @return
	 */
	public void addCommodities(String ID,  int number, double price,  String remark);

	/**
	 * 单据提交发送
	 * @return
	 */
	public ResultMessage submit(String clientID, Storage storage, double allowance, double voucher, String remark);
	
	/**
	 * 保存
	 * @param client
	 * @param storage
	 * @param allowance
	 * @param voucher
	 * @param remark
	 * @return
	 */
	public ResultMessage save(String clientID, Storage storage, double allowance, double voucher, String remark);

}
