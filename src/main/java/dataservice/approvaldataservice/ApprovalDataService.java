package dataservice.approvaldataservice;

import java.util.ArrayList;

import message.ResultMessage;
import po.AccountBillPO;
import po.CashBillPO;
import po.InventoryBillPO;
import po.PurchasePO;
import po.SalesPO;

/**
 * 提供需要审批的单据的集体载入、保存、查看修改操作
 * @deprecated 逻辑层在审批的时候修改单据类型直接从其他逻辑层调用数据
 * @author cylong
 * @version Oct 26, 2014 3:51:31 PM
 */
public interface ApprovalDataService {

	/**
	 * 更新一个需要审批的销售（销售退货）单
	 * @param po 需要审批的销售（销售退货）单
	 * @return 处理信息
	 * @author cylong
	 * @version Nov 15, 2014 2:54:57 PM
	 */
	public ResultMessage update(SalesPO po);

	/**
	 * 更新一个需要审批的进货（进货退货）单
	 * @param po 需要审批的进货（进货退货）单
	 * @return 处理信息
	 * @author cylong
	 * @version 2014年11月28日 上午11:51:40
	 */
	public ResultMessage update(PurchasePO po);

	/**
	 * 更新一个需要审批的收款（付款）单
	 * @param po 需要审批的收款（付款）单
	 * @return 处理信息
	 * @author cylong
	 * @version 2014年11月28日 上午11:52:09
	 */
	public ResultMessage update(AccountBillPO po);

	/**
	 * 更新一个需要审批的赠送单、报溢单、报损单、报警单
	 * @param po 需要审批的赠送单、报溢单、报损单、报警单
	 * @return 处理信息
	 * @author cylong
	 * @version 2014年11月28日 上午11:52:09
	 */
	public ResultMessage update(InventoryBillPO po);

	/**
	 * 更新一个需要审批的现金费用单
	 * @param po 需要审批的现金费用单
	 * @return 处理信息
	 * @author cylong
	 * @version 2014年11月28日 下午12:25:38
	 */
	public ResultMessage update(CashBillPO po);

	/**
	 * 审批过后删除销售（销售退货）单
	 * @param po 销售（销售退货）单
	 * @return 处理信息
	 * @author cylong
	 * @version Nov 15, 2014 3:02:38 PM
	 */
	public ResultMessage delete(SalesPO po);

	/**
	 * 审批过后删除进货（进货退货）单
	 * @param po 进货（进货退货）单
	 * @return 处理信息
	 * @author cylong
	 * @version 2014年11月28日 下午12:00:22
	 */
	public ResultMessage delete(PurchasePO po);

	/**
	 * 审批过后删除收款（付款）单
	 * @param po 收款（付款）单
	 * @return 处理信息
	 * @author cylong
	 * @version 2014年11月28日 下午12:00:36
	 */
	public ResultMessage delete(AccountBillPO po);

	/**
	 * 审批过后删除赠送单、报溢单、报损单、报警单
	 * @param po 赠送单、报溢单、报损单、报警单
	 * @return 处理信息
	 * @author cylong
	 * @version 2014年11月28日 下午12:00:42
	 */
	public ResultMessage delete(InventoryBillPO po);

	/**
	 * 审批过后删除现金费用单
	 * @param po 现金费用单
	 * @return 处理信息
	 * @author cylong
	 * @version 2014年11月28日 下午12:26:12
	 */
	public ResultMessage delete(CashBillPO po);

	/**
	 * @return 全部需要审批的销售（销售退货）单
	 * @author cylong
	 * @version 2014年11月28日 下午12:04:30
	 */
	public ArrayList<SalesPO> getAllSaleBills();

	/**
	 * @return 全部需要审批的进货（进货退货）单
	 * @author cylong
	 * @version 2014年11月28日 下午12:04:36
	 */
	public ArrayList<PurchasePO> getAllPurchaseBills();

	/**
	 * @return 全部需要审批的收款（付款）单
	 * @author cylong
	 * @version 2014年11月28日 下午12:04:41
	 */
	public ArrayList<AccountBillPO> getAllAccountBills();

	/**
	 * @return 全部需要审批的赠送单、报溢单、报损单、报警单
	 * @author cylong
	 * @version 2014年11月28日 下午12:04:46
	 */
	public ArrayList<InventoryBillPO> getAllInventoryBills();

	/**
	 * @return 全部需要审批的现金费用单
	 * @author cylong
	 * @version 2014年11月28日 下午12:04:46
	 */
	public ArrayList<CashBillPO> getAllCashBills();

}
