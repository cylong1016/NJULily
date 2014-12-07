package vo.sale;

import vo.ValueObject;
import dataenum.Storage;

public class saleAddVO extends ValueObject{
	
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
	
	public saleAddVO(String clientID, Storage storage, double allowance, double voucher, String remark) {
		super();
		this.clientID = clientID;
		this.storage = storage;
		this.allowance = allowance;
		this.voucher = voucher;
		this.remark = remark;
	}
}
