package dataservice.recorddataservice;

import java.util.ArrayList;

import po.PersistentObject;

/**
 * 提供销售明细表、经营历程表、经营情况表的查看
 * @author cylong
 * @version Oct 26, 2014 3:50:39 PM
 */
public interface RecordDataService {

	/**
	 * 查看销售明细表
	 * 统计一段时间内商品的销售情况（应该就是查询销售出货单据记录），
	 * 显示符合上述条件的商品销售记录，以列表形式显示，列表中包含如下信息：时间（精确到天），商品名，型号，数量，单价，总额。
	 * @param item 筛选条件有：时间区间，商品名，客户，业务员，仓库。
	 * @return 满足需求的账单
	 */
	public ArrayList<PersistentObject> getSaleDetail(String item);

	/**
	 * 查看经营历程表
	 * 查看一段时间里的所有单据，单据分为：
	 * 1. 销售类单据（销售出货单，销售退货单）
	 * 2. 进货类单据（进货单，进货退货单）
	 * 3. 财务类单据（付款单，收款单，现金费用单）
	 * 4. 库存类单据（报溢单，报损单，赠送单）。
	 * @param item 筛选条件为：时间区间，单据类型，客户，业务员，仓库
	 * @return 满足需求的账单
	 */
	public ArrayList<PersistentObject> getBusinessProcess(String item);

	/**
	 * 查看经营情况表
	 * 统计显示一段时间内的经营收支状况和利润。经营收入显示为折让后，并显示出折让了多少。
	 * 显示信息：
	 * 1. 收入类：销售收入、商品类收入（商品报溢收入 成本调价收入 进货退货差价 代金券与实际收款差额收入）。收入类显示折让后总收入，并显示折让了多少。
	 * 2. 支出类：销售成本、商品类支出（商品报损 商品赠出）。支出类显示总支出。
	 * 3. 利润：折让后总收入-总支出
	 * @param item
	 * @return 满足需求的账单
	 */
	public ArrayList<PersistentObject> getBusinessCondition(String item);

}
