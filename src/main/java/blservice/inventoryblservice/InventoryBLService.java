package blservice.inventoryblservice;


import dataenum.BillType;
import vo.InventoryCheckVO;
import vo.InventoryViewVO;
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
	public InventoryViewVO viewInventory (String beginDate, String endDate);
	
	/**
	 * 显示截至盘点时间的库存快照
	 * @return
	 */
	public InventoryCheckVO checkRecord();
	
		
	/**
	 * 建立库存报警单、报损单、报溢单、赠送单之前需要调用，确定建立的单据类型，得到ID
	 * @param type
	 * @author Zing
	 * @version Nov 30, 2014 3:41:46 PM
	 */
	public String getGiftID();
	public String getOverFlowID();
	public String getLossID();
	public String getAlarmID();
	
	
	/**
	 * 添加商品到单中
	 * @param commodity
	 * @return
	 */
	public void addCommodity(String ID, int number);
	
	/**
	 * 提交单据
	 * @param remark
	 * @return
	 * @author Zing
	 * @version Nov 30, 2014 4:03:43 PM
	 */
	public ResultMessage submit(String remark);
	
	/**
	 * 
	 * @param remark
	 * @return
	 * @author Zing
	 * @version Nov 30, 2014 4:03:51 PM
	 */
	public ResultMessage save(String remark);

}
