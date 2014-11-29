package blservice.purchaseblservice;

import java.util.ArrayList;

import dataenum.BillType;
import dataenum.Storage;
import vo.CommodityItemVO;
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
	 * 返回所有的进货（进货退货）单
	 * @return
	 * @author Zing
	 * @version Nov 29, 2014 2:59:02 PM
	 */
	public ArrayList<PurchaseVO> show();
	
	/**
	 *  新建进货（进货退货）单的时候返回给界面显示单据的ID
	 * @param type 单据的类型：进货单／进货退货单
	 * @return 单据的ID
	 * @author Zing
	 * @version Nov 29, 2014 2:59:37 PM
	 */
	public String getID(BillType type);
	
	/**
	 * 添加商品到进货（进货退货）单中
	 * @param item
	 * @author Zing
	 * @version Nov 29, 2014 3:02:01 PM
	 */
	public void addCommodities(CommodityItemVO item);
	
	/**
	 * 创建进货（进货退货）单时，变成审批状态
	 * @param info
	 * @return
	 * @author Zing
	 * @version Nov 29, 2014 3:09:49 PM
	 */
	public ResultMessage submit(PurInputInfo info);
	
	/**
	 * 创建进货（进货退货）单时，变成草稿状态
	 * @param info
	 * @return
	 * @author Zing
	 * @version Nov 29, 2014 3:09:52 PM
	 */
	public ResultMessage save(PurInputInfo info);
	
}
