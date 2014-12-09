package vo.sale;

import vo.ValueObject;
import dataenum.Storage;

/**
 * 添加一个销售单时的其他输入
 * @author Zing
 * @version Dec 9, 2014 5:40:20 PM
 */
public class saleAddVO extends ValueObject{
	
	/** 仓库 */
	public Storage storage;
	/** 折让金额 */
	public double allowance;
	/** 代金券金额 */
	public double voucher;
	/** 备注 */
	public String remark;
	
	public saleAddVO(Storage storage, double allowance, double voucher, String remark) {
		super();
		this.storage = storage;
		this.allowance = allowance;
		this.voucher = voucher;
		this.remark = remark;
	}
}
