package blservice.saleblservice;

import java.util.ArrayList;

import vo.commodity.CommodityItemVO;
import vo.promotion.PromotionBargainVO;
import vo.promotion.PromotionClientVO;
import vo.promotion.PromotionTotalVO;
import vo.sale.SalesVO;
import vo.sale.saleAddVO;

/**
 * 负责实现销售界面所需要的服务
 * @author cylong
 * @version Oct 26, 2014 3:13:51 PM
 */
/**
 * @author Zing
 * @version 2014年10月28日下午5:31:15
 */
/**
 * @author cylong
 * @version 2014年11月28日 下午7:40:21
 */
public interface SaleBLService {

	
	/**
	 * 新建销售（销售退货）单的时候返回给界面显示单据的ID
	 * @param type 单据的类型（销售单，销售退货单）
	 * @return 单据的ID
	 * @author cylong
	 * @version 2014年11月28日 下午4:15:09
	 */
	public String getSaleID();
	public String getSaleBackID();
	
	/**
	 * 查看已有的特价包
	 * @return
	 * @author Zing
	 * @version Dec 15, 2014 3:57:53 PM
	 */
	public ArrayList<PromotionBargainVO> showBargains();

	/**
	 * 销售时候添加一条商品条目
	 * @param item 商品条目
	 * @author cylong
	 * @version 2014年11月28日 下午7:13:07
	 */
	public void addCommodities(CommodityItemVO item);
	
	/**
	 * 因为需要判断客户等级查看是否有对应促销策略，所以客户也要单独添加
	 * @param clientID
	 * @author Zing
	 * @version Dec 9, 2014 5:40:58 PM
	 */
	public void addClient(String clientID);
	
	/**
	 * 查看是否有合适的销售策略
	 * @return
	 * @author Zing
	 * @version Dec 9, 2014 5:41:34 PM
	 */	
//	public ArrayList<PromotionCommodityVO> findFitPromotionCommodity();

	public ArrayList<PromotionClientVO> findFitPromotionClient();
	
	public ArrayList<PromotionTotalVO> findFitPromotionTotal();
	
	/**
	 * 创建销售（销售退货）单时需要的除商品以外的数据（变成审批状态）
	 * @param inputInfo
	 * @see blservice.saleblservice.SaleInputInfo
	 * @return 处理结果
	 * @author cylong
	 * @version 2014年11月28日 下午7:40:43
	 */
	public SalesVO submit(saleAddVO inputInfo);

	/**
	 * 创建销售（销售退货）单时需要的除商品以外的数据（变成草稿状态）
	 * @param inputInfo
	 * @see blservice.saleblservice.SaleInputInfo
	 * @return 处理结果
	 * @author cylong
	 * @version 2014年11月28日 下午7:40:24
	 */
	public SalesVO save(saleAddVO inputInfo);

}
