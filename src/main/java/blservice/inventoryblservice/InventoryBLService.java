package blservice.inventoryblservice;

import java.util.ArrayList;

import dataenum.BillType;
import vo.InventoryBillVO;
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
	public InventoryCheckVO checkRecord();
	
	public ArrayList<InventoryBillVO> show(BillType type);
	
	public ArrayList<InventoryBillVO> show();
	
	public void buildBill(BillType type);
	
	
	/**
	 * 添加商品到单中
	 * @param commodity
	 * @return
	 */
	public void addCommodity(String ID, int number);
	
	
	public ResultMessage submit(String remark);
	
	public ResultMessage save(String remark);

}
