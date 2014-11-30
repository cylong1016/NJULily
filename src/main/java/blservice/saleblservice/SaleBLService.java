package blservice.saleblservice;

import java.util.ArrayList;

import message.ResultMessage;
import vo.CommodityItemVO;
import vo.ValueObject;
import dataenum.BillType;

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
	 * 返回给界面层显示全部的销售（销售退货）单
	 * @return 全部的销售（销售退货）单的ArrayList
	 * @author cylong
	 * @version 2014年11月28日 下午4:14:35
	 */
	public ArrayList<ValueObject> show(BillType type);

	/**
	 * 新建销售（销售退货）单的时候返回给界面显示单据的ID
	 * @param type 单据的类型（销售单，销售退货单）
	 * @return 单据的ID
	 * @author cylong
	 * @version 2014年11月28日 下午4:15:09
	 */
	public String getID(BillType type);

	/**
	 * 销售时候添加一条商品条目
	 * @param item 商品条目
	 * @author cylong
	 * @version 2014年11月28日 下午7:13:07
	 */
	public void addCommodities(CommodityItemVO item);

	/**
	 * 创建销售（销售退货）单时需要的除商品以外的数据（变成审批状态）
	 * @param inputInfo
	 * @see blservice.saleblservice.SaleInputInfo
	 * @return 处理结果
	 * @author cylong
	 * @version 2014年11月28日 下午7:40:43
	 */
	public ResultMessage submit(SaleInputInfo inputInfo);

	/**
	 * 创建销售（销售退货）单时需要的除商品以外的数据（变成草稿状态）
	 * @param inputInfo
	 * @see blservice.saleblservice.SaleInputInfo
	 * @return 处理结果
	 * @author cylong
	 * @version 2014年11月28日 下午7:40:24
	 */
	public ResultMessage save(SaleInputInfo inputInfo);

}
