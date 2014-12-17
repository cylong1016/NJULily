package blservice.recordblservice;

import dataenum.Storage;

public class SaleDetailInputInfo {
	/** 起始时间 */
	public String beginDate;
	/** 结束时间 */
	public String endDate;
	/** 客户名 */
	public String clientName;
	/** 业务员 */
	public String salesman;
	/** 仓库 */
	public Storage storage;
	/** 商品名 */
	public String commodityName;
	
	public SaleDetailInputInfo(String beginDate, String endDate, String commodityName, String clientName, String salesman, Storage storage) {
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.commodityName = commodityName;
		this.clientName = clientName;
		this.salesman = salesman;
		this.storage = storage;
	}
	
}
