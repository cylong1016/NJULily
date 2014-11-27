package businesslogic.cashbillbl;
import message.ResultMessage;
import dataenum.BillType;
import businesslogicservice.CashBillBLService;

/**
 * 建立现金费用单
 * 制定现金费用单
 * (管理报销等现金操作，单据中包含：单据编号（XJFYD-yyyyMMdd-xxxxx),
 * 操作员（当前登录用户），银行账户，条目清单，总额。
 * 条目清单中包括：条目名，金额，备注。
 * 需要通过审批后才可将此单据入账。入账后将会减少该账户的余额。
 * @author Zing
 * @version Nov 27, 201410:58:04 PM
 */
public class CashBillController implements CashBillBLService{
	private CashBill cashBill;
	
	public CashBillController() {
		cashBill = new CashBill();
	}
	public String getID(BillType type) {
		return cashBill.getID(type);
	}

	public void addBillItem(String name, double money, String remark) {
		cashBill.addBillItem(name, money, remark);
	}


	public ResultMessage submit(String account) {
		return cashBill.submit(account);
	}
	
	public ResultMessage save(String account) {
		return cashBill.save(account);
	}

}
