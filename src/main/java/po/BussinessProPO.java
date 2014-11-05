package po;


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
 * 支持数据导出
 * @author Zing
 * @version 2014年11月4日下午7:23:04
 */
public class BussinessProPO {

	/** 起始时间 */
	private Date begin;
	/** 结束时间 */
	private Date end;
	/** 单据类型 */
	private BillType billType;
	/** 客户 */
	private ClientPO client;
	/** 业务员 */
	private UserPO salesman;
	/** 仓库 */
	private Storage storage;
	
	public BussinessProPO(Date begin, Date end, BillType billType, ClientPO client, UserPO salesman, Storage storage) {
		this.begin = begin;
		this.end = end;
		this.billType = billType;
		this.client = client;
		this.salesman = salesman;
		this.storage = storage;
		
	}

	public Date getBegin() {
		return begin;
	}

	public void setBegin(Date begin) {
		this.begin = begin;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public BillType getBillType() {
		return billType;
	}

	public void setBillType(BillType billType) {
		this.billType = billType;
	}

	public ClientPO getClient() {
		return client;
	}

	public void setClient(ClientPO client) {
		this.client = client;
	}

	public UserPO getSalesman() {
		return salesman;
	}

	public void setSalesman(UserPO salesman) {
		this.salesman = salesman;
	}

	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}
	
	
}
