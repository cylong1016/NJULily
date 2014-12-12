package blservice.cashbillblservice;

import vo.CashBillVO;

/**
 * 建立现金费用单
 * 制定现金费用单
 * （管理报销等现金操作，单据中包含：单据编号（XJFYD-yyyyMMdd-xxxxx）,
 * 操作员（当前登录用户），银行账户，条目清单，总额。
 * 条目清单中包括：条目名，金额，备注。
 * 需要通过审批后才可将此单据入账。入账后将会减少该账户的余额。
 * @author Zing
 * @version 2014年10月31日下午6:00:29
 */
public interface CashBillBLService {
	
	/**
	 * 得到收款单的ID
	 * @return
	 */
	public String getID();
	
	/**
	 * 添加条目清单
	 * @param name
	 * @param money
	 * @param remark
	 * @return
	 */
	public void addBillItem(String name, double money, String remark);
	
	/**
	 * 提交单据
	 * @return
	 */
	public CashBillVO submit(String account);
	
	/**
	 * 保存单据
	 * @return
	 */
	public CashBillVO save(String account);
}
