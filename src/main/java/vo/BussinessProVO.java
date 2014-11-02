package vo;

import dataenum.BillType;
import dataenum.Date;
import dataenum.Storage;

/**
 * 经营历程表
 * 查看一段时间里的所有单据，单据分为：
 * 1. 销售类单据（销售出货单，销售退货单）
 * 2. 进货类单据（进货单，进货退货单） 
 * 3. 财务类单据（付款单，收款单，现金费用单）
 * 4. 库存类单据（报溢单，报损单，赠送单）。
 * 筛选条件为：时间区间，单据类型，客户，业务员，仓库。
 * 显示出符合条件的单据后，可以对单据进行查看操作，但是不可修改和删除。
 * @author Zing
 * @version 2014年11月2日下午3:45:41
 */
public class BussinessProVO {
	/** 起始时间 */
	public Date begin;
	/** 结束时间 */
	public Date end;
	/** 单据类型 */
	public BillType billType;
	/** 客户 */
	public ClientVO client;
	/** 业务员 */
	public UserVO salesman;
	/** 仓库 */
	public Storage storage;
	
	public BussinessProVO(Date begin, Date end, BillType billType, ClientVO client, UserVO salesman, Storage storage) {
		this.begin = begin;
		this.end = end;
		this.billType = billType;
		this.client = client;
		this.salesman = salesman;
		this.storage = storage;
		
	}
}
