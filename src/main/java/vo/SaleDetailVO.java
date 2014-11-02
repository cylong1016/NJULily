package vo;

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
 * @version 2014年11月2日下午3:43:00
 */
public class SaleDetailVO {
	/** 起始时间 */
	public Date begin;
	/** 结束时间 */
	public Date end;
	/** 商品名*/
	public CommodityVO commodity;
	/** 客户 */
	public ClientVO client;
	/** 业务员 */
	public UserVO salesman;
	/** 仓库 */
	public Storage storage;
	
	public SaleDetailVO(Date begin, Date end, CommodityVO commodity, ClientVO client, UserVO salesman, Storage storage) {
		this.begin = begin;
		this.end = end;
		this.commodity = commodity;
		this.client = client;
		this.salesman = salesman;
		this.storage = storage;
	}
}
