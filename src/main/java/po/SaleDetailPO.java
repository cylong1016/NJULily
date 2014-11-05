package po;

import dataenum.Date;
import dataenum.Storage;

/**
 * 销售明细表
 * 统计一段时间内商品的销售情况（应该就是查询销售出货单据记录）
 * 筛选条件有：时间区间，商品名，客户，业务员，仓库。
 * 显示符合上述条件的商品销售记录，以列表形式显示，
 * 列表中包含如下信息：时间（精确到天），商品名，型号，数量，单价，总额。
 * 需要支持导出数据。
 * @author Zing
 * @version 2014年11月4日下午7:21:18
 */
public class SaleDetailPO {

	/** 起始时间 */
	private Date begin;
	/** 结束时间 */
	private Date end;
	/** 商品名*/
	private CommodityPO commodity;
	/** 客户 */
	private ClientPO client;
	/** 业务员 */
	private UserPO salesman;
	/** 仓库 */
	private Storage storage;
	
	public SaleDetailPO(Date begin, Date end, CommodityPO commodity, ClientPO client, UserPO salesman, Storage storage) {
		this.begin = begin;
		this.end = end;
		this.commodity = commodity;
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

	public CommodityPO getCommodity() {
		return commodity;
	}

	public void setCommodity(CommodityPO commodity) {
		this.commodity = commodity;
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
