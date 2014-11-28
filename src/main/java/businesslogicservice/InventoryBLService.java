package businesslogicservice;

import java.util.ArrayList;

import vo.InventoryCheckVO;
import message.ResultMessage;

/**
 * 负责实现仓库管理界面所需要的服务
 * @author cylong
 * @version Oct 26, 2014 3:09:11 PM
 */
/**
 * 添加内容
 * @author Zing
 * @version 2014年10月27日下午4:48:12
 */
public interface InventoryBLService {
	
	/**
	 * 显示在此时间段内的出／入库数量／金额，销售／进货数量／金额，以及库存合计
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public ResultMessage viewInventory (String beginDate, String endDate);
	
	/**
	 * 显示截至盘点时间的库存快照
	 * @return
	 */
	public ArrayList<InventoryCheckVO> checkRecord();
	
//	/**
//	 * TODO 是直接添加商品的VO还是添加字符串之类的？
//	 * 添加商品到商品赠送单中
//	 * @param commodity
//	 * @return
//	 */
//	public ResultMessage addCommodity(String ID, int number);
//	
//	/**
//	 * 生成相应的库存赠送单
//	 * @param commodities
//	 * @return
//	 */
//	public ResultMessage giftRecord();
//	
//	/**
//	 * 生成相应的库存报溢单
//	 * @param commodity
//	 * @param num
//	 * @return
//	 */
//	public ResultMessage overflowRecord(BillType billType, String commodityID, int num, String remark);
//	
//	/**
//	 * 生成相应的库存报损单
//	 * @param commodity
//	 * @param num
//	 * @return
//	 */
//	public ResultMessage lossRecord(BillType billType, String commodityID, int num, String remark);
//	
//	/**
//	 * 生成相应的库存报警单
//	 * @param commodity
//	 * @param num
//	 * @return
//	 */
//	public ResultMessage alarmRecord(BillType billType, String commodityID, int nowNum, int alarmNum, String remark);
//
//
//

}
