package blservice.saleblservice;

import dataenum.Storage;

/**
 * 创建销售（销售退货）单时需要的除商品以外的数据
 * @author cylong
 * @version 2014年11月28日 下午7:36:20
 */
public class SaleInputInfo {

	/** 客户ID */
	public String clientID;
	/** 仓库 */
	public Storage storage;
	/** 折让金额 */
	public double allowance;
	/** 代金券金额 */
	public double voucher;
	/** 备注 */
	public String remark;

	/**
	 * @param clientID
	 * @param storage
	 * @param allowance
	 * @param voucher
	 * @param remark
	 * @author cylong
	 * @version 2014年11月28日 下午7:38:39
	 */
	public SaleInputInfo(String clientID, Storage storage, double allowance, double voucher, String remark) {
		super();
		this.clientID = clientID;
		this.storage = storage;
		this.allowance = allowance;
		this.voucher = voucher;
		this.remark = remark;
	}

}
