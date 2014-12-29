package blservice.purchaseblservice;

import vo.PurchaseVO;
import vo.commodity.CommodityItemVO;
import dataenum.ResultMessage;

/**
 * 负责实现进货界面所需要的服务
 * @author cylong
 * @version Oct 26, 2014 3:11:13 PM
 */
/**
 * @author Zing
 * @version 2014年10月31日下午4:36:47
 */
public interface PurchaseBLService {

	/**
	 * 新建进货（进货退货）单的时候返回给界面显示单据的ID
	 * @param type 单据的类型：进货单／进货退货单
	 * @return 单据的ID
	 * @author Zing
	 * @version Nov 29, 2014 2:59:37 PM
	 */
	public String getPurchaseID();

	public String getPurBackID();

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
	public PurchaseVO submit(PurInputInfo info);

	/**
	 * 创建进货（进货退货）单时，变成草稿状态
	 * @param info
	 * @return
	 * @author Zing
	 * @version Nov 29, 2014 3:09:52 PM
	 */
	public PurchaseVO save(PurInputInfo info);
	
	/**
	 * 修改草稿状态
	 * @param vo
	 * @return
	 * @author Zing
	 * @version Dec 29, 2014 12:45:22 AM
	 */
	public ResultMessage updateDraft(PurchaseVO vo);
	
	/**
	 * 提交草稿状态的单据
	 * @param ID
	 * @return
	 * @author Zing
	 * @version Dec 29, 2014 12:45:30 AM
	 */
	public ResultMessage submitDraft(String ID);

}
