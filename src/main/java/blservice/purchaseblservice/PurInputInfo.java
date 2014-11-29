package blservice.purchaseblservice;

import dataenum.Storage;

public class PurInputInfo {
	/** 供应商 */
	public String clientID;
	/** 仓库 */
	public Storage storage;
	/** 备注 */
	public String remark;
	
	public PurInputInfo(String clientID, Storage storage, String remark) {
		this.clientID = clientID;
		this.storage = storage;
		this.remark = remark;
	}
}
